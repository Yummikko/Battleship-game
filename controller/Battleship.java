package controller;

import util.Input;
import view.Display;

public class Battleship {
    Display display;
    Input input;

    public Battleship(Display display, Input input) {
        this.display = display;
        this.input = input;
    }

    public void playGame() {
        display.showLogo();
        input.clickToContinue();
        display.showMenu();
        display.gameRules();
        display.clickToContinue();
        input.clickToContinue();
        input.playersName();

    }
}
