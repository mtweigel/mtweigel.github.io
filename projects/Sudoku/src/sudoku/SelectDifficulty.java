/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Matthew Weigel
 */
public class SelectDifficulty {

    public static final int BOARD_LENGTH = 81;
    private static String guiMessage = "";
    public static boolean allBoardsUsed = false;

    // ArrayList of all available Sudoku boards in the game
    public static ArrayList<int[]> availableBoards = new ArrayList<>();

    // Easy, medium, and hard board indexes of availableBoards. Used to keep
    // track of used boards.
    public static List<Integer> easyBoards = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
    public static List<Integer> mediumBoards = new ArrayList<>(Arrays.asList(5, 6, 7, 8, 9));
    public static List<Integer> hardBoards = new ArrayList<>(Arrays.asList(10, 11, 12, 13, 14));

    // Holds the board that is chosen after difficulty is selected 
    public static int[] chosenBoard;
    public static int boardDifficulty;
    public static int boardIndex;

    /* Method loads the Sudoku boards from three text files containing easy, 
       medium, and hard boards and adds them into the ArrayList availableBoards. 
     */
    public static void loadBoards() throws FileNotFoundException, IOException {
        FileInputStream fileEasy, fileMedium, fileHard;

        // Strings hold board data from each text file as a string
        String strE = "";
        String strM = "";
        String strH = "";

        // File input streams for easy, medium, and hard difficulty text files
        fileEasy = new FileInputStream("easyboards.txt");
        fileMedium = new FileInputStream("mediumboards.txt");
        fileHard = new FileInputStream("hardboards.txt");

        // Appends all contents of easy board text file to string strE
        Scanner inFS = new Scanner(fileEasy);
        while (inFS.hasNext()) {
            strE = strE.concat(inFS.nextLine());
        }
        add(strE); // Calls add method with updated string of easy boards

        // Appends all contents of medium board text file to string strM
        Scanner inFS2 = new Scanner(fileMedium);
        while (inFS2.hasNext()) {
            strM = strM.concat(inFS2.nextLine());
        }
        add(strM); // calls add method with updated string of medium boards

        // Appends all contents of hard board text file to string strH
        Scanner inFS3 = new Scanner(fileHard);
        while (inFS3.hasNext()) {
            strH = strH.concat(inFS3.nextLine());
        }
        add(strH); // calls add method with updated string of hard boards
    }

    /* Method takes a string of boards, converts it into 5 int[], and adds them
       to ArrayList availableBoards.
     */
    public static void add(String str) {

        // String is first divided into 5 seperate subtrings of 81 digits each,
        // which are then split into string arrays for each board.
        String board1 = str.substring(0, 81);
        String[] boardStr1 = board1.split("");
        String board2 = str.substring(81, 162);
        String[] boardStr2 = board2.split("");
        String board3 = str.substring(162, 243);
        String[] boardStr3 = board3.split("");
        String board4 = str.substring(243, 324);
        String[] boardStr4 = board4.split("");
        String board5 = str.substring(324, 405);
        String[] boardStr5 = board5.split("");

        // New int arrays are created to hold the contents of the string arrays
        int[] sudokuBoard1 = new int[BOARD_LENGTH];
        int[] sudokuBoard2 = new int[BOARD_LENGTH];
        int[] sudokuBoard3 = new int[BOARD_LENGTH];
        int[] sudokuBoard4 = new int[BOARD_LENGTH];
        int[] sudokuBoard5 = new int[BOARD_LENGTH];

        // The contents of the string arrays are parsed into integers and loaded
        // into the corresponding int arrays;
        for (int i = 0; i < BOARD_LENGTH; i++) {
            sudokuBoard1[i] = Integer.parseInt(boardStr1[i]);
            sudokuBoard2[i] = Integer.parseInt(boardStr2[i]);
            sudokuBoard3[i] = Integer.parseInt(boardStr3[i]);
            sudokuBoard4[i] = Integer.parseInt(boardStr4[i]);
            sudokuBoard5[i] = Integer.parseInt(boardStr5[i]);
        }

        // Each int array is then added into the ArrayList of available boards.
        availableBoards.add(sudokuBoard1);
        availableBoards.add(sudokuBoard2);
        availableBoards.add(sudokuBoard3);
        availableBoards.add(sudokuBoard4);
        availableBoards.add(sudokuBoard5);
    }

    /* Method checks the boards of a chosen difficulty to make sure that some
       still remain to play on, since each time a board is beaten, it is removed
       from availableBoards.
     */
    public static boolean checkDifficulty(int difficulty) {
        boolean retVal = false;
        // First each difficulty's ArrayList of board indexes are checked to see
        // if they have all been beaten.
        if (easyBoards.isEmpty() && mediumBoards.isEmpty() && hardBoards.isEmpty()) {
            // If they are all empty, the player has beaten Sudoku and is congratuated
            setGuiMessage("No more boards remain.");
            retVal = true;
            allBoardsUsed = true;
        } else { // If they are not all empty...
            switch (difficulty) {
                case 1:
                    // Checks if easy boards have all been beaten
                    if (easyBoards.isEmpty()) {
                        // If so, player is requested to choose another difficulty
                        setGuiMessage("No more easy boards. Please select "
                                + "another difficulty.");
                        retVal = true;
                    } else {
                        // If not empty, method setBoard is called with easy difficulty
                        setBoard(difficulty);
                        setGuiMessage(null);
                    }
                    break;
                case 2:
                    // Checks if medium boards have all been beaten
                    if (mediumBoards.isEmpty()) {
                        // If so, player is requested to choose another difficulty
                        setGuiMessage("No more medium boards. Please select "
                                + "another difficulty.");
                        retVal = true;
                    } else {
                        // If not empty, method setBoard is called with medium difficulty
                        setBoard(difficulty);
                        setGuiMessage(null);
                    }
                    break;
                case 3:
                    // Checks if hard boards have all been beaten
                    if (hardBoards.isEmpty()) {
                        // If so, player is requested to choose another difficulty
                        setGuiMessage("No more hard boards. Please select "
                                + "another difficulty.");
                        retVal = true;
                    } else {
                        // If not empty, method setBoard is called with hard difficulty
                        setBoard(difficulty);
                        setGuiMessage(null);
                    }
                    break;
                default:
                    // In the case of difficulty other than 1, 2, 3.
                    System.out.println("Invalid difficulty!");
                    break;
            }
        }
        System.out.println("RetVal: " + retVal);
        return retVal;
    }

    /* Method takes a difficulty that has been vefified by checkDifficulty.
       Picks a random index from the boards of that difficulty and assigns it to
       int array chosenBoard.
     */
    public static void setBoard(int difficulty) {
        Random randGen = new Random();
        int index;

        switch (difficulty) {
            case 1: // If easy difficulty...
                // Assigns index a random index of easyBoards
                index = easyBoards.get(randGen.nextInt(easyBoards.size()));
                // Sets board index and difficulty
                boardIndex = index;
                boardDifficulty = difficulty;

                /* Used for testing */
                System.out.println("Index: " + index);
                System.out.print("Indexes remaining: ");
                for (int i = 0; i < easyBoards.size(); i++) {
                    System.out.print(easyBoards.get(i) + ", ");
                }
                System.out.println();
                break;
            case 2: // If medium difficulty...
                // Assigns index a random index of mediumBoards
                index = mediumBoards.get(randGen.nextInt(mediumBoards.size()));
                // Sets board index and difficulty
                boardIndex = index;
                boardDifficulty = difficulty;

                /* Used for testing */
                System.out.println("Index: " + index);
                System.out.print("Indexes remaining: ");
                for (int i = 0; i < mediumBoards.size(); i++) {
                    System.out.print(mediumBoards.get(i) + ", ");
                }
                System.out.println();
                break;
            case 3:
                // Assigns index a random index of hardBoards
                index = hardBoards.get(randGen.nextInt(hardBoards.size()));
                // Sets board index and difficulty
                boardIndex = index;
                boardDifficulty = difficulty;

                /* Used for testing */
                System.out.println("Index: " + index);
                System.out.print("Indexes remaining: ");
                for (int i = 0; i < hardBoards.size(); i++) {
                    System.out.print(hardBoards.get(i) + ", ");
                }
                System.out.println();
                break;
            default:     // Will never get here since method is only called if 
                return;  // difficulty is 1, 2, or 3.     
        }
        int[] board = availableBoards.get(index);
        chosenBoard = board;
    }

    // Returns the chosen board
    public static int[] getBoard() {
        return chosenBoard;
    }

    public static void removeBoard() {
        int difficulty = boardDifficulty;
        int index = boardIndex;

        switch (difficulty) {
            case 1:
                easyBoards.remove(Integer.valueOf(index));
                break;
            case 2:
                mediumBoards.remove(Integer.valueOf(index));
                break;
            case 3:
                hardBoards.remove(Integer.valueOf(index));
                break;
            default:
                return;
        }
    }

    // Returns the available boards
    public static ArrayList<int[]> getAvailableBoards() {
        return availableBoards;
    }

    public static void setGuiMessage(String message) {
        guiMessage = message;
    }

    public static String getGuiMessage() {
        return guiMessage;
    }
}
