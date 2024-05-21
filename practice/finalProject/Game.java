package finalProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Game {
    public static final String FACE = "programming";
    private int difficulty = 0;
    private int speed = 0;
    private String[] words;
    private String[][] wordCheckArray2;
    private String[][] visibleArray;
    
    private int elapsedTime = 0;
    private Timer timer;


    public Game() {
        //load words in 
        try {
            File file = new File("practice\\finalProject\\myWordList.txt");
            Scanner scanner = new Scanner(file);

            words = new String[50];
            for (int i = 0; i < words.length; i++) {
                words[i] = scanner.nextLine();
            }
            randomizeArray(words);

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        startGame();
    }

    public void startGame() {
        //difficulty selection menu
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Level of Play: \n" + //
                        "1. 4 x 4 grid (Easy) \n" + //
                        "2. 6 x 6 grid (Moderate) \n" + //
                        "3. 8 X 8 grid (Difficult) \n");
        System.out.print("Choose your difficulty: ");
        difficulty = sc.nextInt();

        System.out.println("Speed of Play: \n" + //
                        "1. 2 seconds  (Difficult) \n" + //
                        "2. 4 seconds (Moderate) \n" + //
                        "3. 6 seconds (Easy) \n");
        System.out.print("Choose your speed: ");
        speed = sc.nextInt();

        //setup game array
        int arrSize = 0;
        if (difficulty == 1) {
            arrSize = 4;
        } else if (difficulty == 2) {
            arrSize = 6;
        } else if (difficulty == 3) {
            arrSize = 8;
        } else {
            System.out.println("Difficulty not selected");
        }

        wordCheckArray2 = new String[arrSize][arrSize];
        //grab x amount of words, double it, randomize, and put into 2d array
        words = Arrays.copyOf(words, arrSize * 2);
        String[] wordsDouble = Arrays.copyOf(words, words.length * 2);
        System.arraycopy(words, 0, wordsDouble, words.length, words.length);
        randomizeArray(wordsDouble);
        for (int i = 0; i < wordsDouble.length; i++) {
            wordCheckArray2[i / wordCheckArray2.length][i % wordCheckArray2.length] = wordsDouble[i];
        }

        visibleArray = new String[arrSize][arrSize];

    }

    public void playGame() {
        //implement timer
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                elapsedTime++;
            }
        }, 0, 1000);

        //initialize visible array
        for (int i = 0; i < visibleArray.length; i++) {
            Arrays.fill(visibleArray[i], FACE);
        }

        //start gameplay loop
        Scanner scanner = new Scanner(System.in);
        while (!checkGameOver()) {
            displayGameState();
    
            //select the first cell
            int firstRow, firstCol;
            while (true) {
                System.out.println("Select the first square (e.g., A1):");
                String firstInput = scanner.nextLine().toUpperCase();
                firstRow = firstInput.charAt(1) - '1';
                firstCol = firstInput.charAt(0) - 'A';
                if (visibleArray[firstRow][firstCol].equals(FACE)) {
                    visibleArray[firstRow][firstCol] = wordCheckArray2[firstRow][firstCol];
                    break;
                } else {
                    System.out.println("This square has already been selected. Please select another square.");
                }
            }
            displayGameState();
    
            //select the second cell
            int secondRow, secondCol;
            while (true) {
                System.out.println("Select the second square (e.g., B2):");
                String secondInput = scanner.nextLine().toUpperCase();
                secondRow = secondInput.charAt(1) - '1';
                secondCol = secondInput.charAt(0) - 'A';
                if (visibleArray[secondRow][secondCol].equals(FACE)) {
                    visibleArray[secondRow][secondCol] = wordCheckArray2[secondRow][secondCol];
                    break;
                } else {
                    System.out.println("This square has already been selected. Please select another square.");
                }
            }
            displayGameState();
            
            //check for equality
            if (!visibleArray[firstRow][firstCol].equals(visibleArray[secondRow][secondCol])) {
                //replace with face term after delay
                try {
                    Thread.sleep(speed * 1000); //delay in seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                visibleArray[firstRow][firstCol] = FACE;
                visibleArray[secondRow][secondCol] = FACE;
            }
        }
    }

    private void randomizeArray(String[] input) {
        for (int i = 0; i < input.length; i++) {
            int randomIndex = (int) (Math.random() * input.length);
            String temp = input[i];
            input[i] = input[randomIndex];
            input[randomIndex] = temp;
        }
    }

    private void displayGameState() {
        System.out.println();

        //show timer
        System.out.println("Elapsed time: " + elapsedTime + " seconds");
        
        //print column names
        System.out.printf("%-11s ", "-".repeat(11)); //offset column names
        for (int i = 0; i < visibleArray[0].length; i++) {
            System.out.printf("%-11s ", "Col " + (char)('A' + i));
        }
        System.out.println();

        //update game state
        for (int i = 0; i < visibleArray.length; i++) {
            System.out.printf("%-11s ", "Row " + (i + 1));
            for (int j = 0; j < visibleArray[i].length; j++) {
                System.out.printf("%-11s ", visibleArray[i][j]);
            }
            System.out.println();
        }
    }

    
    private boolean checkGameOver() {
        for (int i = 0; i < visibleArray.length; i++) {
            for (int j = 0; j < visibleArray[i].length; j++) {
                if (visibleArray[i][j].equals(FACE)) {
                    return false; // game is not over, there are still squares to be matched
                }
            }
        }
        timer.cancel();
        System.out.println("You win!\nTotal time: " + elapsedTime + " seconds");
        return true; // game is over, all pairs have been found
    }
}
