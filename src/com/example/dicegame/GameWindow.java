//GameWindow is a JFrame-based GUI window that:

// Displays dice for two players.

// Shows scores, rounds, and results.

// Allows players to roll dice, start a new game, or exit.

// Includes a theme toggle (light/dark).

// Uses animations for rolling dice.

//


package com.example.dicegame;
import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame { // jframe isko main window banadega 
    private final GameEngine engine;
    private final DicePanel dice1Panel = new DicePanel();
    private final DicePanel dice2Panel = new DicePanel();
    private final JLabel scoreLabel1 = new JLabel();
    private final JLabel scoreLabel2 = new JLabel();
    private final JLabel roundLabel = new JLabel();
    private final JLabel resultLabel = new JLabel();
    private final JButton rollBtn = new JButton("Roll Dice");
    private boolean isDark = false;
    private boolean isAnimating = false;

    public GameWindow(GameEngine engine) {
        this.engine = engine;
        setTitle("Dice Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        // by using border layout we can adjust lables , btns on screen in three way 
        //     north : for round label and theme toggle button
        //     center : for player names and dice
        //     south : for scores, result text, and buttons
        // Top bar with round label and theme toggle button

        JPanel topPanel = new JPanel();
        JButton themeToggle = new JButton("Toggle Theme");
        themeToggle.addActionListener(e -> toggleTheme());
        topPanel.add(roundLabel);
        topPanel.add(themeToggle);
        add(topPanel, BorderLayout.NORTH);

        // Center panel with player names and dice
        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 40, 10, 40);

        gbc.gridx = 0; gbc.gridy = 0;
        centerPanel.add(new JLabel(engine.getP1().getName()), gbc);
        gbc.gridx = 1;
        centerPanel.add(new JLabel(engine.getP2().getName()), gbc);

        gbc.gridy = 1; gbc.gridx = 0;
        centerPanel.add(dice1Panel, gbc);
        gbc.gridx = 1;
        centerPanel.add(dice2Panel, gbc);

        add(centerPanel, BorderLayout.CENTER);

        // Bottom panel with scores, result text, and buttons
        JPanel bottomPanel = new JPanel(new GridLayout(3, 1));
        JPanel scorePanel = new JPanel(new GridLayout(1, 2));
        scorePanel.add(scoreLabel1);
        scorePanel.add(scoreLabel2);
        bottomPanel.add(scorePanel);

        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        bottomPanel.add(resultLabel);

        JPanel btnPanel = new JPanel();
        btnPanel.add(rollBtn);
        JButton newGameBtn = new JButton("New Game");
        JButton exitBtn = new JButton("Exit");
        btnPanel.add(newGameBtn);
        btnPanel.add(exitBtn);
        bottomPanel.add(btnPanel);

        add(bottomPanel, BorderLayout.SOUTH);

        // Button listeners
        rollBtn.addActionListener(e -> performRoll());
        newGameBtn.addActionListener(e -> {
            dispose();
            new WelcomeScreen();
        });
        exitBtn.addActionListener(e -> System.exit(0));

        // Initialize UI with current scores and round
        updateDisplay();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void performRoll() {
        if (isAnimating || !engine.isActive()) return;

        isAnimating = true;
        rollBtn.setEnabled(false);
        resultLabel.setText("Rolling dice...");
        int animationFrames = 10;                                           
        Timer animTimer = new Timer(100, null);
        final int[] frame = {0};

        animTimer.addActionListener(e -> {
            // Show random dice faces while animating
            dice1Panel.setValue(1 + (int)(Math.random() * 6));
            dice2Panel.setValue(1 + (int)(Math.random() * 6));
            frame[0]++;

            if (frame[0] >= animationFrames) {
                animTimer.stop();

                // Perform actual dice roll and update game state
                RoundData rd = engine.playRound();

                // Update dice faces to actual roll results
                dice1Panel.setValue(rd.p1Roll);
                dice2Panel.setValue(rd.p2Roll);

                // Update scores and round info display
                updateDisplay();

                // ye Show krega round result message
                if (rd.winner.equals("Tie")) {
                    resultLabel.setText("It's a tie!");
                } else {
                    resultLabel.setText(rd.winner + " wins the round!");
                }

                if (!engine.isActive()) {
                    String winner = engine.getGameWinner();
                    JOptionPane.showMessageDialog(this,
                        winner.equals("Tie Game") ? "Game Over! It's a tie!" : "Game Over! " + winner + " wins!");
                }

                isAnimating = false;
                rollBtn.setEnabled(engine.isActive());
            }
        });

        animTimer.setInitialDelay(0);
        animTimer.start();
    }

    private void updateDisplay() {
        roundLabel.setText("Round " + engine.getCurrentRound() + " / " + engine.getTotalRounds());
        scoreLabel1.setText(engine.getP1().getName() + " Score: " + engine.getP1().getScore() + " | Wins: " + engine.getP1().getRoundsWon());
        scoreLabel2.setText(engine.getP2().getName() + " Score: " + engine.getP2().getScore() + " | Wins: " + engine.getP2().getRoundsWon());
    }

    private void toggleTheme() {
        isDark = !isDark;
        Color bg = isDark ? Color.DARK_GRAY : Color.WHITE;
        Color fg = isDark ? Color.WHITE : Color.BLACK;
        getContentPane().setBackground(bg);
        for (Component c : getContentPane().getComponents()) {
            updateColors(c, bg, fg);
        }
        repaint();
    }
// ye Recursively changes the background and foreground colors of every Swing component (JPanels, Labels, Buttons).
    private void updateColors(Component comp, Color bg, Color fg) {
        comp.setBackground(bg);
        comp.setForeground(fg);
        if (comp instanceof JPanel) {
            for (Component child : ((JPanel) comp).getComponents()) {
                updateColors(child, bg, fg);
            }
        }
    }
}
