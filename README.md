# connect-four-game


## How to start this app

### IntelliJ IDEA

### How to Run a Spring Boot Application in IntelliJ IDEA

1. **Open IntelliJ IDEA**: Launch IntelliJ IDEA and open the project containing your Spring Boot application.

2. **Configure Spring Boot Application**: Ensure that you have a valid Spring Boot application class with the `@SpringBootApplication` annotation, which serves as the entry point to your application.

3. **Install Spring Boot Plugin (Optional)**: If you haven't already installed the Spring Boot plugin, go to "Settings" (or "Preferences" on macOS) -> "Plugins" -> search for "Spring Boot" and install it. This plugin provides enhanced support for Spring Boot applications.

4. **Build Project**: Before running the application, make sure you have built the project by clicking on "Build" -> "Build Project" or using the keyboard shortcut `Ctrl + F9` (Windows) or `Cmd + F9` (macOS).

5. **Run Configuration**: To run the Spring Boot application, you need to create a run configuration. Go to "Run" -> "Edit Configurations...". Click on the "+" button in the top-left corner and select "Spring Boot".

6. **Configure the Run Configuration**:
    - Name: Provide a descriptive name for your run configuration (e.g., "Spring Boot App").
    - Main class: Select the main class of your Spring Boot application (the one annotated with `@SpringBootApplication`).
    - Use classpath of module: Choose the module containing your application code.

7. **Optional: Set Program Arguments**: If your Spring Boot application requires any program arguments, you can set them in the "Program arguments" field. For example, to set a specific profile, you can use `--spring.profiles.active=dev`.

8. **Optional: Set Environment Variables**: If your application requires environment variables, you can set them in the "Environment variables" section.

9. **Run the Application**: Click on "Apply" and then "OK" to save the run configuration. Now, you can run the Spring Boot application by clicking on the green "Run" arrow or using the keyboard shortcut `Shift + F10` (Windows) or `Control + R` (macOS).

10. **View Application Output**: IntelliJ IDEA's "Run" panel will display the output of the Spring Boot application, including logs and server startup messages.

That's it! Your Spring Boot application should now be up and running in IntelliJ IDEA.

Note: If you have multiple Spring Boot configurations, you can choose the desired one from the dropdown next to the run button before running the application.

### Docker

1. Navigate to root directory
2. Run `docker-compose up -d` command in terminal
3. Acces http://localhost:9002/swagger-ui/index.html#/connect-four-controller-v-1/makeMove using your browser

## How to Play

### How to Play Connect Four

Connect Four is a classic two-player strategy game played on a 6x7 board. The objective is to connect four of your pieces in a horizontal, vertical, or diagonal line before your opponent does.

**Game Setup:**

1. The game starts with an empty 6x7 grid.
2. Two players take turns. One player is assigned the 'X' symbol, and the other player is assigned the 'O' symbol.

**Game Rules:**

1. Players take turns placing their symbols ('X' or 'O') into one of the columns.
2. The pieces fall to the lowest available position in the selected column.
3. The game ends when either player connects four of their symbols in a row, column, or diagonal or when the board is completely filled (resulting in a draw).

**How to Make a Move:**

1. On your turn, choose the column (numbered from 1 to 7) where you want to drop your piece.
2. The piece will fall to the lowest available cell in that column.

**Winning the Game:**

The first player to create a sequence of four of their symbols in a horizontal, vertical, or diagonal line wins the game.

**Draw:**

If all the cells on the board are filled, and no player has formed a winning sequence, the game ends in a draw.

**Example Board:**

Here's an example of what the board may look like during the game:

```
1 2 3 4 5 6 7
--------------
| | | | | | | |
| | | | | | | |
| | | | | | | |
| | | | | | | |
| | | |X|O| | |
| | |X|O|O| | |
```

In this example, 'X' and 'O' are the symbols of the two players, and they are taking turns placing their pieces on the board.

Now that you know the rules, get ready for some exciting gameplay! The player who successfully connects four of their symbols in a line is the Connect Four champion. Good luck!

### How to play on this app

1. You can access:

[Swagger UI](http://localhost:9002/swagger-ui/index.html#/) - if you are running this app using docker

[Swagger UI](http://localhost:8080/swagger-ui/index.html#/) - if you are running this app using intellij

2. Available APIS

`POST /api/v1/connect-four`: Creates a new game.

`GET /api/v1/connect-four`: Retrieves the current game board.

`PATCH /api/v1/connect-four/make-move/{column}`: Makes a move by specifying the column number.

3. Click on the endpoint that you want to use
4. Click in `Try it out` button on the right side of the screen.
5. Click on the blue button `Execute` 

### Instructions

1. Start a new game or restart a existing game performing a request to `POST /api/v1/connect-four`
2. Each play should make a move using this endpoint choosing the column and passing as parameter: `PATCH /api/v1/connect-four/make-move/{column}`
