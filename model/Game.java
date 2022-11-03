package model;

import board.Board;
import board.BoardFactory;
import board.Square;
import java.util.Scanner;
import util.Input;
import view.Colors;
import view.Display;

import java.util.Arrays;

public class Game {
    private Player player1;
    private Board player1Board;
    private Player player2;
    private Board player2Board;
    private Player currentPlayer;
    private Player currentEnemy;
    private Board currentBoard;
    private Board enemyBoard;
    private final Display DISPLAY;
    private final Input INPUT;
    private final BoardFactory BOARDFACTORY;

    public Game(Display display, Input input, BoardFactory boardFactory) {
        this.DISPLAY = display;
        this.INPUT = input;
        this.BOARDFACTORY = boardFactory;
    }

    public void endTurn(){
        DISPLAY.printBlueMessages("\nClick enter to end Your turn.");
        INPUT.clickToContinue();
    }

    public void cleanScreen() {
        int screenSize = 50;
        for (int i = 0; i < screenSize; i++) {
            System.out.println("\n");
        }
    }


    public void newGame(){
        Integer oceanSize = INPUT.getOceanSize();
        player1 = new Player();
        player2 = new Player();
        player1Board = new Board(oceanSize);
        player1Board.initOcean();
        BOARDFACTORY.choosePlacement(player1, player1Board);
        endTurn();
        //cleanScreen();
        DISPLAY.waitingScreen();
        INPUT.clickToContinue();
        player2Board = new Board(oceanSize);
        player2Board.initOcean();
        BOARDFACTORY.choosePlacement(player2, player2Board);
        endTurn();
        //cleanScreen();
        DISPLAY.shootingPhase();
        currentPlayer = player1;
        currentBoard = player1Board;
        //cleanScreen();
        currentEnemy = player2;
        enemyBoard = player2Board;
        while (!player1Board.checkIfDestroy() && !player2Board.checkIfDestroy()) {
            playRound();
            endTurn();
            changePlayer();
        }
        handleEndGame();
        playAgain();
        //cleanScreen();
    }

    private void playRound() {
        if (currentEnemy == player1) {
            DISPLAY.printBlueMessages("SECOND PLAYER TURN! \n");
            DISPLAY.printBlackMessages("First player board: ");
        } else {
            DISPLAY.printBlueMessages("FIRST PLAYER TURN! \n");
            DISPLAY.printBlackMessages("Second player board: ");
        }
        DISPLAY.showBoard(enemyBoard.getOcean(), true);
        Square enemySquare = getEnemySquareByCoordinates(INPUT.chooseShootPlace());
        enemyBoard.handleShot(enemySquare);
        DISPLAY.showBoard(enemyBoard.getOcean(), true);
    }

    private Square getEnemySquareByCoordinates(Integer[] coordinates) {
        if (currentEnemy == player1) {
            return player2Board.getSquareByCoordinates(coordinates);
        } else {
            return player1Board.getSquareByCoordinates(coordinates);
        }
    }

    private void changePlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
            currentBoard = player2Board;
            enemyBoard = player1Board;
            currentEnemy = player1;
        } else {
            currentPlayer = player1;
            currentEnemy = player2;
            currentBoard = player1Board;
            enemyBoard = player2Board;
        }
    }

    private void handleEndGame() {
        if (player1Board.checkIfDestroy()) {
            DISPLAY.printBlueMessages("Player 2 won! ");
        } else {
            DISPLAY.printBlueMessages("Player 1 won! ");
        }
    }

    private void playAgain() {
        DISPLAY.printBlueMessages("\nDo you want play again? (Y/N): ");
        Scanner keyboard = new Scanner(System.in);
        String replay = keyboard.nextLine();
        if (replay.equals("Y")) {
            newGame();
        } else {
            DISPLAY.printBlueMessages("Thank you for playing.");
        }
    }
}
