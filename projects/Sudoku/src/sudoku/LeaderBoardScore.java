/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Matthew Weigel
 */
public class LeaderBoardScore implements Comparable<LeaderBoardScore> {
    public static ArrayList<LeaderBoardScore> easyScores = new ArrayList<>();
    public static ArrayList<LeaderBoardScore> mediumScores = new ArrayList<>();
    public static ArrayList<LeaderBoardScore> hardScores = new ArrayList<>();
    
    private static String guiMessage = "";    
    private String initials;
    private int time;
    public static int timeToReplace;
    
    // Parameterized constructor for a leaderboard score
    public LeaderBoardScore(String initials, int time) {
        this.initials = initials;
        this.time = time;
    }
    
    public String getInitials() {
        return initials;
    }
    
    public int getTime() {
        return time;
    }
    
    public static void loadScores() throws FileNotFoundException, IOException {
        FileInputStream fileEasy, fileMedium, fileHard;
        Scanner inFS;
        LeaderBoardScore score;
        String initials;
        int time;
        
        // File input streams for easy, medium, and hard score text files
        fileEasy = new FileInputStream("easyscores.txt");
        fileMedium = new FileInputStream("mediumscores.txt");
        fileHard = new FileInputStream("hardscores.txt");
        
        inFS = new Scanner(fileEasy);        
        while (inFS.hasNext()) {  
            for (int i = 0; i < 3; i++) {
                initials = inFS.nextLine();
                time = inFS.nextInt();
                inFS.nextLine();
                score = new LeaderBoardScore(initials, time);
                easyScores.add(score);
            }
        }        
        inFS = new Scanner(fileMedium);        
        while (inFS.hasNext()) {  
            for (int i = 0; i < 3; i++) {
                initials = inFS.nextLine();
                time = inFS.nextInt();
                inFS.nextLine();
                score = new LeaderBoardScore(initials, time);
                mediumScores.add(score);
            }
        }        
        inFS = new Scanner(fileHard);        
        while (inFS.hasNext()) {  
            for (int i = 0; i < 3; i++) {
                initials = inFS.nextLine();
                time = inFS.nextInt();
                inFS.nextLine();
                score = new LeaderBoardScore(initials, time);
                hardScores.add(score);
            }
        }
    }
    
    public static void updateScoreFiles(int difficulty) throws IOException {
        FileWriter fw;
        
        switch (difficulty) {
            case 1:
                fw = new FileWriter("easyscores.txt", false);
                for (int i = 0; i < easyScores.size(); i++) {
                    fw.write(easyScores.get(i).initials);
                    fw.write("\n");
                    fw.write(Integer.toString(easyScores.get(i).time));
                    fw.write("\n");
                }   fw.close();
                break;
            case 2:
                fw = new FileWriter("mediumscores.txt", false);
                for (int i = 0; i < mediumScores.size(); i++) {
                    fw.write(mediumScores.get(i).initials);
                    fw.write("\n");
                    fw.write(Integer.toString(mediumScores.get(i).time));
                    fw.write("\n");
                }   fw.close();
                break;
            case 3:
                fw = new FileWriter("hardscores.txt", false);
                for (int i = 0; i < hardScores.size(); i++) {
                    fw.write(hardScores.get(i).initials);
                    fw.write("\n");
                    fw.write(Integer.toString(hardScores.get(i).time));
                    fw.write("\n");
                }   fw.close();
                break;
            default: 
                break;
        }
    }
    
    // Adds a new score to the leaderboard if the score is valid.
    public static void writeScore(int difficulty, String initials, int time) throws IOException {
        
        switch (difficulty) {
            case 1:
                LeaderBoardScore eScore = new LeaderBoardScore(initials, time);             
                for (int i = 0; i < easyScores.size(); i++) {
                    if (easyScores.get(i).time == timeToReplace) {
                        easyScores.set(i, eScore);
                    }
                }
                updateScoreFiles(1);
                break;
            case 2:
                LeaderBoardScore mScore = new LeaderBoardScore(initials, time);
                for (int i = 0; i < mediumScores.size(); i++) {
                    if (mediumScores.get(i).time == timeToReplace) {
                        mediumScores.set(i, mScore);
                    }
                }
                updateScoreFiles(2);
                break;
            case 3:
                LeaderBoardScore hScore = new LeaderBoardScore(initials, time);
                for (int i = 0; i < hardScores.size(); i++) {
                    if (hardScores.get(i).time == timeToReplace) {
                        hardScores.set(i, hScore);
                    }
                }
                updateScoreFiles(3);
                break;
            default:
                break;
        }  
    }    
    
    // Sorts and prints the scores of a selected difficulty
    public static String readScores(int difficulty) throws IOException {      
        ArrayList<LeaderBoardScore> scores = new ArrayList<>();        
        Collections.sort(easyScores);
        Collections.sort(mediumScores);
        Collections.sort(hardScores);
        String scoresStr = "";
       
        switch (difficulty) {
            case 1:
                scores = easyScores;         
                break;
            case 2:
                scores = mediumScores;             
                break;
            case 3:
                scores = hardScores;
                break;
            default:
                break;
        }
        
        for (int i = 0; i < scores.size(); i++) {
            scoresStr += scores.get(i).initials;
            scoresStr += "   ";
            scoresStr += secsToMins(scores.get(i).time);
            scoresStr += "\n";
        }
        return scoresStr;
    }
    
    public static boolean checkScore(int difficulty, int time) {
        boolean isHighScore = false;        
        ArrayList<Integer> oldScores = new ArrayList<>();
        
        switch (difficulty) {
            case 1:
                if (hasSpace(difficulty)) {
                    isHighScore = true;
                } else {
                    for (int i = 0; i < easyScores.size(); i++) {
                        if (time < easyScores.get(i).time) {
                            oldScores.add(easyScores.get(i).time);
                        }
                    }
                    if (oldScores.isEmpty()) {
                        isHighScore = false;
                    } else {
                        isHighScore = true;
                        timeToReplace = Collections.max(oldScores);
                    }                    
                }
                break;
            case 2:
                if (hasSpace(difficulty)) {
                    isHighScore = true;
                } else {
                    for (int i = 0; i < mediumScores.size(); i++) {
                        if (time < mediumScores.get(i).time) {
                            oldScores.add(mediumScores.get(i).time);
                        }
                    }
                    if (oldScores.isEmpty()) {
                        isHighScore = false;
                    } else {
                        isHighScore = true;
                        timeToReplace = Collections.max(oldScores);
                    }                    
                }
                break;
            case 3:
                if (hasSpace(difficulty)) {
                    isHighScore = true;
                } else {
                    for (int i = 0; i < hardScores.size(); i++) {
                        if (time < hardScores.get(i).time) {
                            oldScores.add(hardScores.get(i).time);
                        }
                    }
                    if (oldScores.isEmpty()) {
                        isHighScore = false;
                    } else {
                        isHighScore = true;
                        timeToReplace = Collections.max(oldScores);
                    }                    
                }
                break;
            default:
                break;
        }        
        return isHighScore;
    }
    
    // Method checks if a chosen difficulty has space for a new entry on the
    // leaderboard.
    public static boolean hasSpace(int difficulty) {
        boolean retVal = false;
        
        switch (difficulty) {
            case 1:
                retVal = easyScores.size() < 3;
                break;
            case 2:
                retVal = mediumScores.size() < 3;
                break;
            case 3:
                retVal = hardScores.size() < 3;
                break;
            default:
                System.out.println("Invalid difficulty");
                break;                       
        }    
        return retVal;
    }
    
    // Method converts seconds to a string of mins and seconds
    public static String secsToMins(int secs) {
        int minutes = secs / 60;
        int seconds = secs % 60;        
        String time;    
        
        if (seconds < 10 && minutes < 10) {
            time = "0" + minutes + ":" + "0" + seconds;
        } else if (minutes < 10) {
            time = "0" + minutes + ":" + seconds;
        } else if (seconds < 10) {
            time = minutes + ":" + "0" + seconds;
        } else {
            time = minutes + ":" + seconds;
        }      
        return time;
    }
    
    // Method used for sorting scores in the leaderboard
    @Override
    public int compareTo(LeaderBoardScore score) {
        int currObj = time;
        int comparisonObj = score.time;
        
        int retVal = 0;       
        if (currObj < comparisonObj) {
            retVal = -1;
        }
        else if (currObj > comparisonObj) {
            retVal = 1;
        }
        return retVal;
    }
    
    public static void setGuiMessage(String message) {
        guiMessage = message;
    }

    public static String getGuiMessage() {
        return guiMessage;
    }
}
