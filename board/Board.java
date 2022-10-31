package board;

import model.Ship;

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

//    public void setOcean(Square[][] ocean) {
//        this.ocean = ocean;
//    }

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

    public boolean isPlacementOk (Ship ship) {
        ArrayList<Square> shipsElements = ship.getSquaresList();
        for (Square shipElement : shipsElements){
            if (shipElement.getX() < 0 ||  shipElement.getY() < 0 || shipElement.getX() >= ocean.length - 1 ||
                    shipElement.getY() >= ocean.length - 1)
            {
                return false;
            }
            if (ocean[shipElement.getX()][shipElement.getY()].getSquareStatus() != SquareStatus.EMPTY) {
                return false;
            }
        }

        return true;
    };

    public Square getSquareByCoordinates(Integer[] coordinates) {
        int x = coordinates[0];
        int y = coordinates[1];

        return ocean[y][x];
    }

    public void changeSquareStatus(SquareStatus newStatus, Square square) {
        for (int i = 0; i < ocean.length; i++) {
            for (int j = 0; j <ocean[i].length; j++) {
                if (ocean[j][i].getX() == square.getX() && ocean[j][i].getY() == square.getY()) {
                    ocean[j][i].setSquareStatus(newStatus);
                }
            }
        }
    }

    public void handleShot(Square shot) {
        for (int i = 0; i < ocean.length; i++) {
            for (int j = 0; j <ocean[i].length; j++) {
                if (ocean[j][i].getX() == shot.getX() && ocean[j][i].getY() == shot.getY()) {
                    if (ocean[j][i].getSquareStatus().getCharacter() == "S") {
                        changeSquareStatus(SquareStatus.HIT, ocean[j][i]);
                    } else {
                        changeSquareStatus(SquareStatus.MISSED, ocean[j][i]);
                    }
                }
            }
        }
    }

    public boolean checkIfDestroy() {
        for (int i = 0; i < ocean.length; i++) {
            for (int j = 0; j < ocean[i].length; j++) {
                if (ocean[j][i].getSquareStatus().getCharacter() == "S") {
                    return false;
                }
            }
        }
        return true;
    }

}
