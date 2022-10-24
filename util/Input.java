package util;
import java.util.Scanner;

public class Input {

    Scanner userInput = new Scanner(System.in);

    public String firstPlayerName() {
        String firstPlayerName = userInput.nextLine();
        return firstPlayerName;
    }

    public String secondPlayerName() {
        String secondPlayerName = userInput.nextLine();
        return secondPlayerName;
    }

    public void clickToContinue() {
        String clickToContinue = userInput.nextLine();
    }

}
