package model;

import board.Board;
import util.Input;
import view.Display;

public class Game {
    private Board player1Board;
    private Board player2Board;
    private final Display DISPLAY;
    private final Input INPUT;

    public Game(Display display, Input input) {
        this.DISPLAY = display;
        this.INPUT = input;
    }

    public void endTurn(){
        DISPLAY.printBlueMessages("\nClick enter to end Your turn.");
        INPUT.clickToContinue();
    }

    public void newGame(){
        Integer oceanSize = INPUT.getOceanSize();

        player1Board = new Board(oceanSize);
        player1Board.initOcean();
        DISPLAY.showBoard(player1Board.getOcean());
        DISPLAY.showShips();
        DISPLAY.shipSizeVisualisation();
        //place ships function
        endTurn();
        DISPLAY.waitingScreen();
        INPUT.clickToContinue();

        player2Board = new Board(oceanSize);
        player2Board.initOcean();
        DISPLAY.showBoard(player2Board.getOcean());
        DISPLAY.showShips();
        DISPLAY.shipSizeVisualisation();
        endTurn();
        DISPLAY.shootingPhase();
        //place ship function

    }
}
