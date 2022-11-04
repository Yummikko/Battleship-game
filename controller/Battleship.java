package controller;

import board.BoardFactory;
import model.Game;
import util.Input;
import util.InputController;
import view.Display;

public class Battleship {
    Display display;
    Input input;
    private final Game GAME;
    public boolean run;


    public Battleship(Display display, Input input, BoardFactory boardFactory, InputController inputController) {
        this.display = display;
        this.input = input;
        this.GAME = new Game(display, input, boardFactory, inputController);
        run = true;
    }


    public void gameMenu() {
        display.showLogo();
        input.clickToContinue();
        display.showMenu();
        while (run){
            int chosenOption = input.chooseMenuOption();
            switch (chosenOption) {
                case 0 -> {
                    input.playersName();
                    GAME.playerVsPlayer();
                }
                case 1 -> GAME.aiVsAi();
                case 2 -> {
                    input.playerName();
                    GAME.playerVsAi();
                }
                case 3 -> {
                    display.gameRules();
                    display.clickToContinue();
                    input.clickToContinue();
                    display.showMenu();
                }
                case 4 -> {
                    run = false;
                    display.printBlueMessages("Thank You for playing, see You next time!");
                }
                default -> {
                    display.printRedMessages("Invalid input, please try again!");
                    display.showMenu();
                }
            }
        }
    }
}
