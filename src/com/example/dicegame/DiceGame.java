package com.example.dicegame; // it will help in organizing the code and avoiding naming conflicts.

import javax.swing.*; // it will import all the classes and compononents from the javax.swing package.
// what is javax ? 
// javax is a prefix in Java that stands for "Java Extension,"
// indicating a standard extension to the Java platform. 
// javax.swing is a specific package within this extension that provides a toolkit for building graphical user interfaces (GUIs) with components like buttons, labels, and text fields.
// The * in javax.swing.* is a wildcard that means "and all of its subpackages,"  allow to import all classes

public class DiceGame {
    public static void main(String[] args) {
        
        
        
        
        
        // Swing guarantees that tasks are processed one at a time, in order, with no conflicts.
        
        
        SwingUtilities.invokeLater(() -> { 
            // ISKO DEKH 
            // SwingUtilities.invokeLater(() -> { ... });
            // This ensures that all GUI-related tasks are executed on the Event Dispatch Thread (EDT).
            // The EDT is responsible for handling GUI updates in Swing applications.
            
            // ISKO DEKH EDT KYA KRATA HE SIR NE BATAYA 
            //     All events (like button clicks, mouse movements, key presses) are put into a queue.
            //     All painting requests (to draw or update components) are also put in that queue.
            //     The EDT's one and only job is to pull tasks from this queue, one by one, and execute them.
            // Using invokeLater() prevents issues like UI freezing or unexpected behavior.
            
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                //This sets the GUI’s Look and Feel to match the native operating system style.
                // For example, on Windows, buttons and dialogs will look like Windows components. 
                // ?So this block will ensure that ui looks 
                // like native os style

            } catch (Exception e) {
                e.printStackTrace();
            }
            //it is inital screen for game setup
            new WelcomeScreen();
        });
    }
}