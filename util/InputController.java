package util;

import view.Colors;

public class InputController {

    public static Boolean checkIfInteger(String inputToCheck) {
        try {
            Integer.parseInt(inputToCheck);
            return true;
        }catch(NumberFormatException e) {
            System.out.println(Colors.ANSI_RED + "Invalid input, You need to provide a number!");
            return false;
        }
    }

    public Boolean checkLetter(String input) {
        if (input.length() == 1) {
            return true;
        } else {
            System.out.println(Colors.ANSI_RED + "Enter a single character to continue.");
            return false;
        }
    }

    public Boolean checkNumber(String userPawn) {
        if (checkIfInteger(userPawn)) {
            return (Integer.parseInt(userPawn) >= 0) && (Integer.parseInt(userPawn) <= 20);
        }
        return false;
    }
    public String[] splitString(String str) {
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

    public Integer convertLetterToNumber(String letterToConvert) {
        char charToConvert = letterToConvert.charAt(0);
        return charToConvert - 'a' + 1;
    }

    public void pause(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
}
