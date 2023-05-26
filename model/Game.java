package model;

import board.Board;
import board.BoardFactory;
import board.Square;

import java.util.Objects;
import java.util.Scanner;
import util.Input;
import util.InputController;
import view.Display;


public class Game {
    private final Player PLAYER1;
    private Board player1Board;
    private final Player PLAYER2;
    private Board player2Board;
    private Player currentPlayer;
    private Player currentEnemy;
    private Board currentBoard;
    private Board enemyBoard;
    private final Display DISPLAY;
    private final Input INPUT;
    private final InputController INPUT_CONTROLLER;
    private final BoardFactory BOARDFACTORY;


    public Game(Display display, Input input, BoardFactory boardFactory, InputController inputController) {
        this.DISPLAY = display;
        this.INPUT = input;
        this.INPUT_CONTROLLER = inputController;
        this.BOARDFACTORY = boardFactory;
        this.PLAYER1 = new Player();
        this.PLAYER2 = new Player();
        this.currentPlayer = PLAYER1;
        this.currentEnemy = PLAYER2;
    }



    public void playerVsPlayer(){
        Integer oceanSize = INPUT.getOceanSize();
        player1Board = initOcean("player1", oceanSize);
        BOARDFACTORY.choosePlacementMode(PLAYER1, player1Board);
        endTurn();
        DISPLAY.waitingScreen();
        INPUT.clickToContinue();
        player2Board = initOcean("player2", oceanSize);
        BOARDFACTORY.choosePlacementMode(PLAYER2, player2Board);
        endTurn();
        DISPLAY.shootingPhase();
        currentBoard = player1Board;
        enemyBoard = player2Board;
        
        while (!player1Board.checkIfDestroy() && !player2Board.checkIfDestroy()) {
            playRound();
            endTurn();
            changePlayer();
        }
        handleEndGame();
        playAgain();
    }

    
    private Board initOcean(String player, Integer oceanSize) {
        switch (player) {
            case "player1" -> {
                player1Board = new Board(oceanSize);
                player1Board.initOcean();
                return player1Board;
            }
            case "player2" -> {
                player2Board = new Board(oceanSize);
                player2Board.initOcean();
                return player2Board;
            }
        }
        return null;
    }


    public void aiVsAi() {
        Integer oceanSize = INPUT.getRandomOceanSize();
        player1Board = initOcean("player1", oceanSize);
        BOARDFACTORY.randomPlacement(PLAYER1, player1Board);
        DISPLAY.waitingScreen();
        player2Board = initOcean("player2", oceanSize);
        BOARDFACTORY.randomPlacement(PLAYER2, player2Board);
        DISPLAY.shootingPhase();
        currentBoard = player1Board;
        enemyBoard = player2Board;
        while (!player1Board.checkIfDestroy() && !player2Board.checkIfDestroy()) {
            playAiVsAi();
            changePlayer();
        }
        handleEndGame();
        playAgain();
    }

    public void playerVsAi(){
        Integer oceanSize = INPUT.getOceanSize();
        player1Board = initOcean("player1", oceanSize);
        BOARDFACTORY.choosePlacementMode(PLAYER1, player1Board);
        endTurn();
        DISPLAY.waitingScreen();
        INPUT.clickToContinue();
        player2Board = initOcean("player2", oceanSize);
        BOARDFACTORY.randomPlacement(PLAYER2, player2Board);
        DISPLAY.shootingPhase();
        currentBoard = player1Board;
        enemyBoard = player2Board;

        while (!player1Board.checkIfDestroy() && !player2Board.checkIfDestroy()) {
            playPlayerVsAi();
            endTurn();
            changePlayer();
        }
        handleEndGame();
        playAgain();
    }


    private void playRound() {
        if (currentEnemy == PLAYER1) {
            DISPLAY.printBlueMessages("SECOND PLAYER TURN!");
            DISPLAY.printBlueMessages("Aim your missiles and sink the enemy's fleet!\n");
            DISPLAY.printBlackMessages("First player board: ");
        } else {
            DISPLAY.printBlueMessages("FIRST PLAYER TURN!");
            DISPLAY.printBlueMessages("Aim your missiles and sink the enemy's fleet!\n");
            DISPLAY.printBlackMessages("Second player board: ");
        }
        DISPLAY.showBoard(enemyBoard.getOcean(), true);
        Square enemySquare = getEnemySquareByCoordinates(INPUT.chooseShootPlace());
        enemyBoard.handleShot(enemySquare);
        DISPLAY.showBoard(enemyBoard.getOcean(), true);
    }


    private void playPlayerVsAi() {
        if (currentEnemy == PLAYER1) {
            DISPLAY.printBlueMessages("AI TURN! \n");
            INPUT_CONTROLLER.pause(1000);
            DISPLAY.printBlackMessages("First player board: ");
            DISPLAY.showBoard(enemyBoard.getOcean(), true);
            Square enemySquare = getEnemySquareByCoordinates(INPUT.randomShootPlace(currentBoard));
            enemyBoard.handleShot(enemySquare);
            DISPLAY.showBoard(enemyBoard.getOcean(), true);
        } else {
            DISPLAY.printBlueMessages("FIRST PLAYER TURN! \n");
            DISPLAY.printBlackMessages("AI board: ");
            DISPLAY.showBoard(enemyBoard.getOcean(), true);
            Square enemySquare = getEnemySquareByCoordinates(INPUT.chooseShootPlace());
            enemyBoard.handleShot(enemySquare);
            DISPLAY.showBoard(enemyBoard.getOcean(), true);
        }
    }


    private Square getEnemySquareByCoordinates(Integer[] coordinates) {
        if (currentEnemy == PLAYER1) {
            return player2Board.getSquareByCoordinates(coordinates);
        } else {
            return player1Board.getSquareByCoordinates(coordinates);
        }
    }


    private void playAiVsAi() {
        if (currentEnemy == PLAYER1) {
            DISPLAY.printBlueMessages("SECOND AI TURN! \n");
            DISPLAY.printBlackMessages("First AI board: ");
        } else {
            DISPLAY.printBlueMessages("FIRST AI TURN! \n");
            DISPLAY.printBlackMessages("Second AI board: ");
        }
        DISPLAY.showBoard(enemyBoard.getOcean(), true);
        Square enemySquare = getEnemySquareByCoordinates(INPUT.randomShootPlace(currentBoard));
        enemyBoard.handleShot(enemySquare);
        DISPLAY.showBoard(enemyBoard.getOcean(), true);
        //INPUT_CONTROLLER.pause(1000);
    }


    private void changePlayer() {
        if (currentPlayer == PLAYER1) {
            currentPlayer = PLAYER2;
            currentBoard = player2Board;
            enemyBoard = player1Board;
            currentEnemy = PLAYER1;
        } else {
            currentPlayer = PLAYER1;
            currentEnemy = PLAYER2;
            currentBoard = player1Board;
            enemyBoard = player2Board;
        }
    }


    public void endTurn(){
        DISPLAY.printBlueMessages("\nClick enter to end Your turn.");
        INPUT.clickToContinue();
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
            playerVsPlayer();
        } else {
            DISPLAY.printBlueMessages("Thank you for playing.");
        }
    }
}
