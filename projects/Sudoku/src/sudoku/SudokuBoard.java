package sudoku;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author mackw
 */
public class SudokuBoard {

    private int[][] solved;
    private int[][] board;
    private int[] lastPos;
    

//solved version to check against method result !!!delete later
//            {{5, 3, 4, 6, 7, 8, 9, 1, 2}
//            ,{6, 7, 2, 1, 9, 5, 3, 4, 8}
//            ,{1, 9, 8, 3, 4, 2, 5, 6, 7}
//            ,{8, 5, 9, 7, 6, 1, 4, 2, 3}
//            ,{4, 2, 6, 8, 5, 3, 7, 9, 1}
//            ,{7, 1, 3, 9, 2, 4, 8, 5, 6}
//            ,{9, 6, 1, 5, 3, 7, 2, 8, 4}
//            ,{2, 8, 7, 4, 1, 9, 6, 3, 5}
//            ,{3, 4, 5, 2, 8, 6, 1, 7, 9}};
    
    //example of an array that will solve sudoku !!!delete later
    int[] testScrubInput
            = {4, 6, 8, 9, 1, 2,
                7, 2, 3, 4, 8,
                1, 3, 4, 2, 5, 7,
                5, 9, 7, 1, 4, 2,
                2, 6, 5, 7, 9,
                1, 3, 9, 4, 8, 5,
                9, 1, 5, 3, 7, 4,
                2, 8, 7, 6, 3,
                3, 4, 5, 2, 6, 1};

    //easy sudoku
    public SudokuBoard() {
        board = new int[9][9];
//        {{5, 3, 0, 0, 7, 0, 0, 0, 0},
//        {6, 0, 0, 1, 9, 5, 0, 0, 0},
//        {0, 9, 8, 0, 0, 0, 0, 6, 0},
//        {8, 0, 0, 0, 6, 0, 0, 0, 3},
//        {4, 0, 0, 8, 0, 3, 0, 0, 1},
//        {7, 0, 0, 0, 2, 0, 0, 0, 6},
//        {0, 6, 0, 0, 0, 0, 2, 8, 0},
//        {0, 0, 0, 4, 1, 9, 0, 0, 5},
//        {0, 0, 0, 0, 8, 0, 0, 7, 9}};
        //generateSolved();
    }

    //constructor to start with given board
    public SudokuBoard(int[] newBoard) {
        board = new int[9][9];
        loadBoard(newBoard);
    }

    public int[][] getBoard() {
        return board;
    }

    public int[][] getSolvedBoard() {
        return solved;
    }

    //print for testing
    public void print(int[][] curBoard) {
        if (curBoard != null) {
            for (int j = 0; j < 9; j++) {
                for (int i = 0; i < 9; i++) {
                    System.out.print(curBoard[j][i] + " ");
                }
                System.out.println();
            }
        }
    }

    //takes a array of ints and loads them into the board
    public void loadBoard(int[] newBoard) {
        int pos = 0;
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                board[j][i] = newBoard[pos];
                pos++;
            }
        }
        //after loading the board, generate the solved version
        solved = null;
        generateSolved();
    }

    //cycle through the board, if you find a blank return its position
    public ArrayList<Integer> findBlank(int[][] curBoard) {
        ArrayList<Integer> pos = new ArrayList<>();
        pos.clear();
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                if (curBoard[j][i] == 0 && pos.size() < 2) {
                    pos.add(0, j);
                    pos.add(1, i);
                }
            }
        }
        return pos;
    }

    //checks if a number can fit into a position for sudoku
    public boolean checkIfValid(int num, ArrayList<Integer> pos, int[][] curBoard) {
        boolean retVal = true;
        lastPos = new int [2];
        lastPos[0]= pos.get(0);
        lastPos[1]= pos.get(1);

        //check the row
        for (int i = 0; i < 9; i++) {
            if (curBoard[pos.get(0)][i] == num) {
                retVal = false;
            }
        }

        //check the column
        for (int j = 0; j < 9; j++) {
            if (curBoard[j][pos.get(1)] == num) {
                retVal = false;
            }
        }

        //check squares
        //int division to drop the remainder
        //then *3 to go back to the top left of the square
        int squareY = (pos.get(0) / 3) * 3;
        int squareX = (pos.get(1) / 3) * 3;

        for (int j = squareY; j < squareY + 3; j++) {
            for (int i = squareX; i < squareX + 3; i++) {
                if (curBoard[j][i] == num) {
                    retVal = false;
                }
            }
        }
        return retVal;
    }

    //creates a solution to the current board with recursion
    public boolean generateSolved() {
        boolean retVal = false;
        ArrayList<Integer> pos;

        //this creates a copy of the original board named solved
        //doing solved = board just creates a new name for board and will alter
        //both with any changes
        if (solved == null) {
            solved = new int[9][9];
            for (int j = 0; j < 9; j++) {
                for (int i = 0; i < 9; i++) {
                    solved[j][i] = board[j][i];
                }
            }
        }

        //check to see if the board is already solved
        pos = findBlank(solved);
        if (pos.isEmpty()) {
            retVal = true;
        }

        //recursivly try 1-9 in every cell till a solution is found
        if (retVal == false) {
            for (int i = 1; i <= 9; i++) {
                if (checkIfValid(i, pos, solved)) {
                    //this is stepping forward in the puzzle
                    solved[pos.get(0)][pos.get(1)] = i;
                    if (generateSolved()) {
                        retVal = true;
                    }
                }
                //this is stepping back after a incorrect solution
                if (!retVal) {
                    solved[pos.get(0)][pos.get(1)] = 0;
                }
            }
        }
        return retVal;
    }

    //runs through the user input to check if they solved sudoku
    public boolean checkUserInput(int[] answerArray) {
        Queue<Integer> userInput = new LinkedList<>();
        for (int i = 0; i < answerArray.length; i++) {
            userInput.add(answerArray[i]);
        }

        int num;
        int size = userInput.size();
        int amtBlanks = 0;
        ArrayList<Integer> pos;
        boolean retVal = true;

        //create a copy of the board to test the user input
        int[][] checkBoard = new int[9][9];
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                checkBoard[j][i] = board[j][i];
            }
        }

        //counts the amount of entries that user input has to be
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                if (checkBoard[j][i] == 0) {
                    amtBlanks++;
                }
            }
        }

        //check to make sure the userInput has the right size
        if (userInput.size() != amtBlanks) {
            retVal = false;
        }

        //inserts the user input into the copy of the board to check for sudoku 
        for (int i = 0; i < size; i++) {
            num = userInput.poll();
            pos = findBlank(checkBoard);
            if (checkIfValid(num, pos, checkBoard)) {
                checkBoard[pos.get(0)][pos.get(1)] = num;
            } else {
                retVal = false;
            }
        }
        return retVal;
    }
    
    public int[] getLastPos() {
        return lastPos;
    }
}
