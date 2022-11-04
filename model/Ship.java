package model;

import board.Square;
import board.SquareStatus;
import java.util.ArrayList;

public class Ship {

    ArrayList<Square> squaresList;
    ArrayList<Square> placementSquaresList;

    private ShipOrientation shipOrientation;
    private ShipType shipType;
    private int shipStartX;
    private int shipStartY;

    public Ship(ShipType shipType) {
        this.shipType = shipType;
        this.squaresList = new ArrayList<>();
        this.placementSquaresList = new ArrayList<>();
    }


    public enum ShipOrientation {
        VERTICAL, HORIZONTAL
    }


    public void placeShip(Square[][] ocean) {
        for (int i = 0; i < this.shipType.getShipLength(); i++) {
            switch (this.shipOrientation) {
                case HORIZONTAL -> {
                    ocean[this.shipStartY][this.shipStartX + i].setSquareStatus(SquareStatus.SHIP);
                }
                case VERTICAL -> {
                    ocean[this.shipStartY + i][this.shipStartX].setSquareStatus(SquareStatus.SHIP);
                }
            }
        }
    }

    public ArrayList<Square> getSquaresList() {
        return squaresList;
    }

    public void setShipOrientation(ShipOrientation shipOrientation) {
        this.shipOrientation = shipOrientation;
    }

    public void setSquaresList() {
        this.squaresList.clear();

        for (int i = 0; i < this.shipType.getShipLength(); i++) {
            switch (this.shipOrientation) {
                case HORIZONTAL -> {
                    this.squaresList.add(
                            new Square(this.shipStartY, this.shipStartX + i, SquareStatus.SHIP));
                }
                case VERTICAL -> {
                    this.squaresList.add(
                            new Square(this.shipStartY + i, this.shipStartX, SquareStatus.SHIP));
                }
            }
        }
    }

    public void setShipStartX(int shipStartX) {
        this.shipStartX = shipStartX;
    }

    public void setShipStartY(int shipStartY) {
        this.shipStartY = shipStartY;
    }

}
