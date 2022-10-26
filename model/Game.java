package model;

import board.Board;
import util.Input;
import view.Display;

public class Game {
    private Board board;
    private final Display DISPLAY;
    private final Input INPUT;

    public Game(Display display, Input input) {
        this.DISPLAY = display;
        this.INPUT = input;
    }

    public void newGame(){
        Integer oceanSize = INPUT.getOceanSize();
        board = new Board(oceanSize);
        board.initOcean();
        DISPLAY.displayBoard(board.getOcean());
        DISPLAY.showShips();
        DISPLAY.shipSizeVisualisation();
    }
}
