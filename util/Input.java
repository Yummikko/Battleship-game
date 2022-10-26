package util;

import board.Square;
import view.Display;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import static java.lang.System.in;

public class Input {

    public static final String ANSI_BLACK = "\033[1;30m";
    Scanner userInput = new Scanner(in);

    public void playersName() {

        System.out.println("Player 1, please enter Your nickname: ");
        String firstPlayerName = userInput.nextLine();
        System.out.println("Player 2, please enter Your nickname: ");
        String secondPlayerName = userInput.nextLine();

        System.out.println("\nHello " + firstPlayerName + " & " + secondPlayerName + ", welcome to the Battleship Game!\n");

    }


    public void clickToContinue() {
        String clickToContinue = userInput.nextLine();
    }

    public int chooseMenuOption() {
        String input = userInput.nextLine();
        while (!checkIfInteger(input)) {
            input = userInput.nextLine();
        }
        return Integer.parseInt(input);
    }

    private boolean checkIfInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (
                NumberFormatException e) {
            // wrongInput();
            return false;
        }
    }

    public int getOceanSize() {
        while (true) {
            System.out.println("Please provide ocean size: ");
            Scanner oceanSize = new Scanner(in);
            String userInput = oceanSize.nextLine();
            if (checkInput(userInput)) {
                return Integer.parseInt(userInput);
            }
            System.out.println("You need to provide a number between 10 and 20!");
        }
    }

    private Boolean checkInput(String userInput) {
        if (checkIfInteger(userInput)) {
            return (Integer.parseInt(userInput) >= 10) && (Integer.parseInt(userInput) <= 20);
        }
        return false;
    }

    public int getValue() {
        while (true) {
            System.out.println("Choose placement 1 for manual and 2 for random: ");
            Scanner placement = new Scanner(in);
            String userInput = placement.nextLine();
            if (checkInput(userInput)) {
                return Integer.parseInt(userInput);
            }
            System.out.println("You need to provide a number between 1 and 2!");
        }
    }

    public int getRowNumber() {
        while (true) {
            System.out.println("Choose row: ");
            Scanner row = new Scanner(in);
            String userInput = row.nextLine();
            if (checkInput(userInput)) {
                return Integer.parseInt(userInput);
            }
            System.out.println("Wrong row number!");
        }
    }

    public Boolean checkLetter(String input) {
        if (input.length() == 1) {
            return true;
        } else {
            System.out.println("Enter a single character to continue.");
            return false;
        }
    }

    public static String[] splitString(String str) {
        StringBuffer alpha = new StringBuffer(),
                num = new StringBuffer();

        for (int i=0; i<str.length(); i++)
        {
            if (Character.isDigit(str.charAt(i)))
                num.append(str.charAt(i));
            else
                alpha.append(str.charAt(i));
        }


        String letters = alpha.toString();
        String numbers = num.toString();
        return new String[]{letters, numbers};
    }

    public static Integer convertLetterToNumber(String letterToConvert) {
        char charToConvert = letterToConvert.charAt(0);
        return charToConvert - 'a' + 1;
    }
//    public int getColumnLetter() {
//        System.out.println("Choose column: ");
//        Scanner column = new Scanner(in);
//        String userInput = column.nextLine();
//        if (userInput) {
//            return userInput;
//        }
//        System.out.println("Wrong row number!");
//    }

    public int getOrientation () {
        String orientation = userInput.next();
        String[] letterList = {"H", "V"};
        if ((Arrays.asList(letterList)).contains(orientation.toUpperCase())) {
            int orientationNumber = (Arrays.asList(letterList)).indexOf(orientation.toUpperCase());
            return orientationNumber;
        } else {
            System.out.println("Wrong row number!");
        }
        return 0;
    }
}
