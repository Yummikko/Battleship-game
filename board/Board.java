package board;

import util.Input;

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
                ocean[y][x] = new Square(y, x);
            }
        }
    }
}
