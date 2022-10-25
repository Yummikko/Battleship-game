package model;

import board.Board;
import util.Input;
import view.Display;

public class Game {
    private Board ocean;
    private final Display DISPLAY;
    private final Input INPUT;

    public Game(Display display, Input input) {
        this.DISPLAY = display;
        this.INPUT = input;
    }

    public void newGame(){
        Integer oceanSize = INPUT.getOceanSize();
        ocean = new Board(oceanSize);
        DISPLAY.showShips();
        DISPLAY.shipSizeVisualisation();
    }
}
