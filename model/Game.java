package model;

import board.Board;
import board.BoardFactory;
import util.Input;
import view.Display;

public class Game {
    private Board player1Board;
    private Board player2Board;
    private final Display DISPLAY;
    private final Input INPUT;
    private final BoardFactory BOARDFACTORY;

    public Game(Display display, Input input, BoardFactory boardFactory) {
        this.DISPLAY = display;
        this.INPUT = input;
        this.BOARDFACTORY = boardFactory;
    }

    public void newGame(){
        Integer oceanSize = INPUT.getOceanSize();
        Player player = new Player();
        player1Board = new Board(oceanSize);
        player2Board = new Board(oceanSize);
        player1Board.initOcean();
        player2Board.initOcean();
        BOARDFACTORY.manualPlacement(player, player1Board, player1Board);


        DISPLAY.showBoard(player1Board.getOcean());
        DISPLAY.showBoard(player2Board.getOcean());
        DISPLAY.showShips();
        DISPLAY.shipSizeVisualisation();
    }
}
