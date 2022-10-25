package controller;

import model.Game;
import util.Input;
import view.Display;

public class Battleship {
    Display display;
    Input input;
    private Game game;
    public boolean run;



    public Battleship(Display display, Input input) {
        this.display = display;
        this.input = input;
        game = new Game(display, input);
        run = true;

    }
    public void gameMenu() {
        display.showLogo();
        input.clickToContinue();
        display.showMenu();
        while (run){
            int chosenOption = input.chooseMenuOption();
            switch (chosenOption){
                case 0:
                    input.playersName();
                    game.newGame();
                    break;
                case 1:
                    display.gameRules();
                    display.clickToContinue();
                    input.clickToContinue();
                    display.showMenu();
                    break;
                case 2:
                    run = false;
                    display.printExitMessage();
                    break;
                default:
                    display.wrongInput();
                    display.showMenu();
            }
        }
    }
}
