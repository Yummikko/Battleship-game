package util;

import board.Square;
import model.Ship;
import view.Colors;
import view.Display;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import static java.lang.System.in;

public class Input {

    private InputController inputController;
    Scanner userInput = new Scanner(in);


    public Input(InputController inputController) {
        this.inputController = inputController;
    }


    public void playersName() {

        System.out.println("Player 1, please enter Your nickname: ");
        String firstPlayerName = userInput.nextLine();
        System.out.println("Player 2, please enter Your nickname: ");
        String secondPlayerName = userInput.nextLine();

        System.out.println("\nHello " + Colors.CYAN_BOLD + firstPlayerName + Colors.ANSI_BLACK + " & " + Colors.CYAN_BOLD + secondPlayerName + Colors.ANSI_BLACK + ", welcome to the Battleship Game!\n");

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
            Scanner placement = new Scanner(in);
            String userInput = placement.nextLine();
            if (Integer.parseInt(userInput) == 1 || Integer.parseInt(userInput) == 2 ) {
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
                    System.out.println("You need to provide a number between 10 and ocean size!");
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

        return ship;
    }


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

    public Integer[] chooseShootPlace() {
        String[] shootCoordinates = getShootCoordinates();

        String shootChar = shootCoordinates[0];
        String shootNum = shootCoordinates[1];

        Integer convertedChar = inputController.convertLetterToNumber(shootChar);
        Integer convertedNumber = Integer.parseInt(shootNum);

        return new Integer[]{convertedChar - 1, convertedNumber - 1};
    }

    private String[] getShootCoordinates() {
        while (true) {
            System.out.println("Please provide shoot coordinates");
            Scanner from = new Scanner(in);
            String shootPlace = from.nextLine();
            String[] splittedInput = inputController.splitString(shootPlace);
            if (inputController.checkLetter(splittedInput[0])) {
                if (inputController.checkNumber(splittedInput[1])) {
                    return splittedInput;
                } else {
                    System.out.println("You need to provide a number between 10 and ocean size!");
                }
            }
        }
    }
}
