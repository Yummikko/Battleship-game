package util;

import view.Display;
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
        while(true) {
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

//    public static String makeHeader(int size){
//        char[] letters = getLetters(size, true);
//        StringBuilder header = new StringBuilder("  ");
//        for (char letter: letters) {
//            header.append(" ").append(letter);
//        }
//        return String.valueOf(header);
//    }
//    public static char[] getLetters(int count, boolean capital){
//        char[] alphabet = new char[count];
//        int a;
//        if(capital)
//            a = 65;
//        else
//            a = 97;
//        for (int i = 0; i < count; i++) {
//            alphabet[i] = (char) (a + i);
//        }
//        return alphabet;
//    }
}
