# Dice Game

A Java-based dice game with a graphical user interface built using Swing.

## Project Overview

This is a dice rolling game where players take turns rolling dice and competing for the highest score. The game features a graphical user interface with animations and sound effects for an immersive gaming experience.

## Features

- Interactive GUI with welcome screen and game window
- Single and multiplayer game modes
- Animated dice rolling
- Score tracking and round management
- Sound effects for dice rolls and game events
- Customizable player names

## Project Structure

The project is organized into several Java classes:

- `DiceGame.java`: Main entry point for the application
- `WelcomeScreen.java`: Initial screen for game setup and player configuration
- `GameWindow.java`: Main game interface where gameplay occurs
- `GameEngine.java`: Core game logic and rules implementation
- `Dice.java`: Representation of dice objects with rolling functionality
- `DicePanel.java`: Visual component for displaying dice
- `Player.java`: Player data and score management
- `RoundData.java`: Tracking game rounds and turn information

## How to Run

There are three ways to run the game:

1. **Using the Executable**:
   - Double-click on `DiceGame.exe` to launch the game directly

2. **Using the JAR File**:
   - Ensure you have Java installed
   - Run the command: `java -jar DiceGameApp.jar`

3. **Using the Batch File**:
   - Run `build_run.bat` which will launch the game using the included JRE

## Game Rules

1. Each player takes turns rolling the dice
2. The player with the highest total score after rolling wins the round
3. Special combinations (like doubles) may award bonus points
4. The game continues for a set number of rounds
5. The player with the most wins at the end is declared the overall winner

## Technical Details

- Built with Java and Swing for the GUI
- Packaged with Launch4j to create the Windows executable
- Includes a bundled JRE (Java Runtime Environment) for standalone execution
- XML configuration for game settings

## Requirements

- Windows operating system
- No additional installation required (JRE is included)

## Credits

Developed as a demonstration project for learning Java GUI programming and game development concepts.

## License

This project is for educational purposes only.