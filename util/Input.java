package util;

import board.Square;
import model.Ship;
import view.Display;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import static java.lang.System.in;

public class Input {

    private InputController inputController;
    public static final String ANSI_BLACK = "\033[1;30m";
    public Input input;
    Scanner userInput = new Scanner(in);


    public Input(InputController inputController) {
        this.inputController = inputController;
    }


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

    public String[] chooseShipPlace() {
        while (true) {
            Scanner from = new Scanner(in);
            String shipPlace = from.nextLine();
            String[] splittedInput = inputController.splitString(shipPlace);
            if (inputController.checkLetter(splittedInput[0])) {
                if (inputController.checkNumber(splittedInput[1])) {
                    return splittedInput;
                } else {
                    System.out.println("You need to provide a number between 10 and ocen size!");
                }
            }
        }
    }

    public Integer[] convertedCoordinates() {
        String[] pawnStartPosition = chooseShipPlace();
        String pawnChar = pawnStartPosition[0];
        String pawnNum = pawnStartPosition[1];

        Integer convertedChar = inputController.convertLetterToNumber(pawnChar);
        Integer convertedNumber = Integer.parseInt(pawnNum);

        Integer[] ship = {convertedNumber - 1, convertedChar - 1};
//
//        Pawn pawn = board.getPawnByPosition(coordinates);
        return ship;
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

            public int getOrientation() {
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
