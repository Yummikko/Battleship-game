package board;

import model.Ship;
import util.Input;

import java.util.ArrayList;

public class Board {
    private Square[][] ocean;
    public Integer sideLength;

    public Board(Integer sideLength) {
        this.sideLength = sideLength;
    }

    public Square[][] getOcean() {
        return ocean;
    }

    public void setOcean(Square[][] ocean) {
        this.ocean = ocean;
    }

    public Integer getSideLength() {
        return sideLength;
    }

    public void initOcean() {
        Integer n = sideLength;
        ocean = new Square[n][n];

        for (int y = 0; y < ocean.length; y++) {
            for (int x = 0; x < ocean[y].length; x++) {
                ocean[y][x] = new Square(y, x, SquareStatus.EMPTY);
            }
        }
    }

    public boolean isPlacementOk (Ship ship, Square[][] ocean) {
        ArrayList<Square> shipsElements = ship.getSquaresList();
        for (Square shipElement : shipsElements){
            if (shipElement.getX() < 0 ||  shipElement.getY() < 0 || shipElement.getX() >= ocean.length ||
                    shipElement.getY() >= ocean.length)
            {
                return false;
            }
            if ((ocean[shipElement.getY()][shipElement.getX()]).getSquareStatus() != SquareStatus.EMPTY){
                return false;
            }
        }
        return true;
    };

    public void handleShotInBoard(Square shotSquare, Ship ship) {
        if (board[shotSquare.getY()][shotSquare.getX()].getSquareStatus() == SquareStatus.EMPTY) {
            board[shotSquare.getY()][shotSquare.getX()].setSquareStatus(SquareStatus.MISSED);
        } else if (board[shotSquare.getY()][shotSquare.getX()].getSquareStatus() == SquareStatus.SHIP) {
            board[shotSquare.getY()][shotSquare.getX()].setSquareStatus(SquareStatus.HIT);
        }

        if (ship != null && ship.isSunk())
        {
            handleSunk(ship);
        }
    }

    public void handleSunk(Ship sunkShip) {
        for (Square square : sunkShip.getSquaresList()) {
            board[square.getY()][square.getX()].setSquareStatus(SquareStatus.SUNK);
        }
    }
}
