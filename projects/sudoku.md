[Back to Portfolio](./)

Sudoku Game
===============

-   **Groupmates:** Mack Wessels and Robert Squires.
-   **Class:** CSCI 325
-   **Grade:** A
-   **Language(s):** Java
-   **Source Code Repository:** [features/mastering-markdown](https://github.com/mtweigel/Sudoku)  
    (Please [email me](mailto:mtweigel@csustudent.net?subject=GitHub%20Access) to request access.)

## Project description

This project is a Sudoku game that includes features such as selectable difficulty levels, a leaderboard showcasing high scores based on lowest times to solve, and an auto-solver, all packaged in a user-friendly and interactive GUI.

## How to compile and run the program

How to run the program from the Windows Command Prompt. 

1. Open Command Prompt.
2. Navigate to the directory where the project is located.
3. Enter the following commands:

```bash
$ cd Sudoku/dist
$ java -jar "Sudoku.jar"
```

## UI Design

Once the game has been launched, the player is greeted with the main menu screen (See Fig 1). If the player selects one of the difficulty buttons of easy, medium, or hard, a valid Sudoku board is given (See Fig 2). The player will then attempt to solve the board by entering numbers from 1-9 into the empty boxes on the board while a timer counts up. If the player does not like the board given or wants to play a lower/higher difficulty, they may do so at any time by selected either the same or different difficulty. If the player becomes stuck at any time or wants to see the solution, they can select the "Show Solution" button which prompts the program to solve the board for them and shows the player which of their entries were incorrect by highlighting them in yellow (See Fig 3). Once the player thinks they have solved the board, they can select the "Check Solution. If the user entries are incorrect, the game will notify them that they failed to solve Sudoku and highlights all incorrect entries in red (See Fig 4). They can then chosoe to show soltion or pick a diffulty to play again. On the other hard, if the user is was able to solve Sudoku (See Fig 5), and the attempt is a new top three score, they will be congratulated and prompted to enter their initials (See Fig 6). The leaderboard then will be updated accordingly. At this point, the player can either choose a difficulty to play again, or can quit by hitting "Quit Game". <br>

Fig 1. The main menu
![screenshot](/images/sudoku/mainmenu.PNG)
<br>

Fig 2. After easy difficulty is selected

![screenshot](/images/sudoku/easy.PNG)
<br>

Fig 3. After selecting Show Solution.

![screenshot](/images/sudoku/showsolution.PNG)
<br>

Fig 4. After selecting Check Solution (incorrect).

![screenshot](/images/sudoku/incorrect.PNG)
<br>

Fig 5. After selecting Check Solution (correct).

![screenshot](/images/sudoku/correct.PNG)
<br>

Fig 6. New high score!

![screenshot](/images/sudoku/highscore.PNG)
<br>

Fig 7. Updated leaderboard.

![screenshot](/images/sudoku/leaderboard.PNG)
<br>

## Additional Considerations

- Boards and high scores are stored in text files for easy retrieval.
- There are only 5 boards for each difficulty level. Once the player has played on all the boards of one diffulty, they will be prompted to select one of the other two.
- Only the top three scores are recorded on the leaderboard. If the player wins but does not make the leaderboard, they will not be prompted to enter their initials.
- A video of a presentation of this project can be viewed [here](/images/sudoku/sudoku.mp4).

[Back to Portfolio](./)
