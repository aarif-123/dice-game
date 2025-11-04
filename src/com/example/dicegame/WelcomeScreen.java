package com.example.dicegame;
import javax.swing.*;
import java.awt.*;

public class WelcomeScreen extends JFrame {
    // jframe is a class that allows  you to create  and manage top level window in java application   
    // It sеrvеs as thе main window for GUI-basеd Java applications and providеs 
    // a platform-indеpеndеnt way to crеatе graphical usеr intеrfacеs.
    

    public WelcomeScreen() { // ye constructor he 
        setTitle("Dice Game Setup- mentor led project");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());  
        // it Sets the layout manager to GridBagLayout, which allows flexible positioning of components in a grid-like structure.
        
        
        
        GridBagConstraints gbc = new GridBagConstraints();
        //The gridBagConstraints is a class , her we do Creates an object that holds layout position 
        //and spacing rules for each component in the grid.
        // jaise
        // The boss (GridBagLayout) does all the thinking and arranging. The instructions (gbc) just tell it what to do for each component.

        gbc.insets = new Insets(15, 15, 15, 15);
        // .insets handles space or margins around components in the grid



        
        //Jlable is used to display text or images both 
        JLabel title = new JLabel("Welcome to mini Dice Game- mentor led project");
        title.setFont(new Font("Arial", Font.BOLD,  30));

        //ye hum title ko centre me align krne ke liye likhenge, 
        
        // gridx se hum columns ko horizontally control krte hein
        // and gridy se  rows ko vertically control krte hein

        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        

        add(title, gbc); // ye title ko add krega jpanle me with gbc constraints
        gbc.gridwidth = 1;
        gbc.gridy++;
        
        //hum yahan player ka jlable create krenge gbc ke sath aur use grid pe add krenge
        add(new JLabel("Player 1 Name:"), gbc);
        JTextField p1Field = new JTextField("Player 1", 15);//ye text field banaegi
        gbc.gridx = 1;
        add(p1Field, gbc);// text field ko add krenge grid pe
    

        //yahan hum player 2 ka jlable create krenge gbc ke sath aur use grid pe add krenge
        gbc.gridx = 0; gbc.gridy++;
        add(new JLabel("Player 2 Name:"), gbc);
        JTextField p2Field = new JTextField("CPU", 15);
        gbc.gridx = 1;// hum next  column mein text field add rekgne
        add(p2Field, gbc);// text field ko add krenge grid pe

        gbc.gridx = 0; gbc.gridy++;
         //gbc.gridy++ se hum next row me move krenge


        add(new JLabel("Rounds (1 to 20):"), gbc);
        JSpinner roundsSpinner = new JSpinner(new SpinnerNumberModel(5, 1, 20, 1));
        //JSpinner is a numeric input box

        gbc.gridx = 1;
        add(roundsSpinner, gbc);

        JButton startButton = new JButton("Start Game");
        gbc.gridx = 0; gbc.gridy++; gbc.gridwidth = 2;
        add(startButton, gbc);

        
        startButton.addActionListener(e -> {
            String p1Name = p1Field.getText().trim();
            String p2Name = p2Field.getText().trim();
            int rounds = (int) roundsSpinner.getValue();

            if (p1Name.isEmpty() || p2Name.isEmpty()) {
                // yahan pe JoptionPane dialog box dikhane ke liye he user ko
                JOptionPane.showMessageDialog(this,
                        "Player names cannot be empty!",
                        "Invalid Input",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            dispose(); // ye close krdega current windwo ko
            new GameWindow(new GameEngine(p1Name, p2Name, rounds)); // ye object banayege gamegnine  kn aure gamewindwo kholega
            
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
