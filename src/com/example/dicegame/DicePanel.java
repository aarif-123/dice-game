package com.example.dicegame;

import javax.swing.*;
import java.awt.*;

public class DicePanel extends JPanel {
    private int value = 1; // Dice value 1 to 6

    public DicePanel() {
        setPreferredSize(new Dimension(100, 100));
        setOpaque(false);
    }

    // Sets the dice value; must be between 1 and 6
    public void setValue(int v) {
        if (v < 1 || v > 6) {
            throw new IllegalArgumentException("Dice value must be between 1 and 6");
        }
        value = v;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Enable smooth graphics
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int size = Math.min(getWidth(), getHeight()) - 20;
        int x = (getWidth() - size) / 2;
        int y = (getHeight() - size) / 2;

        // Dice background - white rounded rectangle
        g2.setColor(Color.WHITE);
        g2.fillRoundRect(x, y, size, size, 25, 25);

        // Dice border - black rounded rectangle stroke
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(3));
        g2.drawRoundRect(x, y, size, size, 25, 25);

        // Dot details
        g2.setColor(Color.BLACK);
        int dotSize = size / 6;
        int centerX = x + size / 2 - dotSize / 2;
        int centerY = y + size / 2 - dotSize / 2;

        int offset = size / 4;

        int leftX = x + offset - dotSize / 2;
        int rightX = x + size - offset - dotSize / 2;
        int topY = y + offset - dotSize / 2;
        int bottomY = y + size - offset - dotSize / 2;

        // Draw dots according to dice face number
        switch (value) {
            case 1:
                g2.fillOval(centerX, centerY, dotSize, dotSize);
                break;
            case 2:
                g2.fillOval(leftX, topY, dotSize, dotSize);
                g2.fillOval(rightX, bottomY, dotSize, dotSize);
                break;
            case 3:
                g2.fillOval(leftX, topY, dotSize, dotSize);
                g2.fillOval(centerX, centerY, dotSize, dotSize);
                g2.fillOval(rightX, bottomY, dotSize, dotSize);
                break;
            case 4:
                g2.fillOval(leftX, topY, dotSize, dotSize);
                g2.fillOval(rightX, topY, dotSize, dotSize);
                g2.fillOval(leftX, bottomY, dotSize, dotSize);
                g2.fillOval(rightX, bottomY, dotSize, dotSize);
                break;
            case 5:
                g2.fillOval(leftX, topY, dotSize, dotSize);
                g2.fillOval(rightX, topY, dotSize, dotSize);
                g2.fillOval(centerX, centerY, dotSize, dotSize);
                g2.fillOval(leftX, bottomY, dotSize, dotSize);
                g2.fillOval(rightX, bottomY, dotSize, dotSize);
                break;
            case 6:
                g2.fillOval(leftX, topY, dotSize, dotSize);
                g2.fillOval(rightX, topY, dotSize, dotSize);
                g2.fillOval(leftX, centerY, dotSize, dotSize);
                g2.fillOval(rightX, centerY, dotSize, dotSize);
                g2.fillOval(leftX, bottomY, dotSize, dotSize);
                g2.fillOval(rightX, bottomY, dotSize, dotSize);
                break;
        }

        g2.dispose();
    }
}
