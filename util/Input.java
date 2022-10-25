package util;
import java.util.Scanner;

public class Input {

    Scanner userInput = new Scanner(System.in);

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

}
