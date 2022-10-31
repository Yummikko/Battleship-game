package controller;

import board.BoardFactory;
import model.Game;
import util.Input;
import view.Display;

public class Battleship {
    Display display;
    Input input;

//    BoardFactory boardFactory;
    private Game game;
    public boolean run;



    public Battleship(Display display, Input input, BoardFactory boardFactory) {
        this.display = display;
        this.input = input;
        game = new Game(display, input, boardFactory);
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
                    display.printBlueMessages("Thank You for playing, see You next time!");
                    break;
                default:
                    display.printRedMessages("Invalid input, please try again!");
                    display.showMenu();
            }
        }
    }
}
