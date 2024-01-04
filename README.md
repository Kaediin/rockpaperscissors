# IMC's Rock Paper Scissors Project
This Java-based application allows users to play the classic game of Rock, Paper, Scissors against a computer opponent. Below is a brief overview of the project structure, how to get started, and the libraries used.

## Project Structure:
- `Main.java`: The entry point of the application. It initializes the game and starts the gameplay loop.
- `Game.java`: Contains the core logic for the game, including initializing the game state, playing rounds, and keeping score.
- `Hand.java`: An enum representing the possible choices: Rock, Paper, and Scissors.
- `UserInputInterface.java`: An interface abstracting user input, allowing for easier testing (and possible future changes to input methods).
- `ScannerUserInput.java`: An implementation of UserInputInterface using Java's Scanner for console input.
- `GameTest.java`: Contains unit tests for the Game class, ensuring that the game logic is correct.

## How to Run:
1. **Compile the Code:** Use your preferred Java compiler or IDE to compile the .java files.
2. **Run the Application:** Execute the Main class to start the game. Follow the on-screen prompts to play against the computer.

## Libraries Used

- **JUnit 5**: A popular unit testing framework for Java. Used for writing and executing tests in `GameTest.java` to ensure the game logic is accurate and stable.
    - **Purpose**: Provides annotations and assertions for writing tests, running tests, and checking results. It's essential for maintaining code quality and ensuring that changes don't break existing functionality.

- **Mockito**: A mocking framework for unit tests in Java. Used in conjunction with JUnit to test `Game` class functionality.
    - **Purpose**: Allows the creation of test double objects (mocks) in automated unit tests. Particularly useful for mocking dependencies like user input in `GameTest.java`.

## Getting Started

To get started with the Rock Paper Scissors project:

1. **Set Up Your Environment**: Ensure you have Java and an IDE or text editor installed. (This project was coded and tested in JetBrain's IntelliJ)
2. **Install Libraries**: Ensure JUnit 5 and Mockito are added to your project's dependencies.
3. **Compile and Run**: Compile the Java files and run the `Main` class to start the game.
