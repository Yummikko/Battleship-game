package model;

import board.Square;

import java.util.List;

public class Ship {
    private List<Square> occupiedCells;

    public List<Square> getOccupiedCells() {
        return occupiedCells;
    }

    public Ship(List<Square> occupiedCells) {
        this.occupiedCells = occupiedCells;
    }
}
