[Back to Portfolio](../)

Magic Number Guessing Game
==========================

-   **Class:** CSCI 301
-   **Grade:** A
-   **Language(s):** Perl
-   **Source Code Repository:** [mtweigel/Magic-Number-Guessing-Game](https://github.com/mtweigel/Magic-Number-Guessing-Game)  
    (Please [email me](mailto:mtweigel@csustudent.net?subject=GitHub%20Access) to request access.)

## Project description

This project is a simple number guessing game that allows the player to keep guessing until the number is found.

## How to run the program

How to run the program from the Windows Command Prompt. 

1. Download and install the 64-bit version of Perl from here: https://strawberryperl.com/
2. Open Command Prompt.
3. Navigate to the directory where the project is located.
4. Enter the following command:

```bash
$ perl NumberGuessingGame.pl
```

## UI Design

Once the game is launched the user is welcomed and told to hit Enter to begin playing (See Fig 1). The game then asks the user to guess the random magic number that lies between 1 and 100 (See Fig 2). If the user's guess is too low they are told so and prompted to try again (See Fig 3). Likewise, if the user's guess is too high, they are told so and prompted to try again (See Fig 4). This loop continues until the user guesses the correct number and is both congratulated (See Fig 5) and told how many tries it took them to guess it. At this point, game asks the user if they would like to play again. If the user chooses Y/y, the game generates a new number to guess (See Fig 6). Otherwise, if the user chooses N/n, the game will close.

*Fig 1. Welcome message*

![screenshot](/images/numberguessing/welcome.PNG)

*Fig 2. User is prompted to guess a number*

![screenshot](/images/numberguessing/guess.PNG)

*Fig 3. Guess is too low.*

![screenshot](/images/numberguessing/toolow.PNG)

*Fig 4. Guess is too high.*

![screenshot](/images/numberguessing/toohigh.PNG)

*Fig 5. Correct guess!*

![screenshot](/images/numberguessing/winner.PNG)

*Fig 6. New game.*

![screenshot](/images/numberguessing/playagain.PNG)

## Additional Considerations

- If a digit other than a numerical one is entered, a error message pops up but the user is able to keep playing.

[Back to Portfolio](../)
