package model;

import board.Square;
import board.SquareStatus;

import java.util.ArrayList;

public class Ship {

    ArrayList<Square> squaresList;
    ArrayList<Square> placementSquaresList;
    ArrayList<ShipType> shipsList;

    private ShipOrientation shipOrientation;
    private ShipType shipType;
    private int shipStartX;
    private int shipStartY;

    public Ship(Integer shipStartX, Integer shipStartY) {
        this.shipStartX = shipStartX;
        this.shipStartY = shipStartY;
    }

    public void setShipCoordinates(Integer shipStartX, Integer shipStartY) {
        this.shipStartX = shipStartX;
        this.shipStartY = shipStartY;
    }
//
//    public void setShipStartY() {
//        this.shipStartY = shipStartY;
//    }

    public Integer getX() {
        return shipStartX;
    }

    public Integer getY() {
        return shipStartY;
    }


    public enum ShipOrientation {
        VERTICAL, HORIZONTAL
    }

    public Ship(ShipType shipType) {
        this.shipType = shipType;
        this.squaresList = new ArrayList<>();
        this.placementSquaresList = new ArrayList<>();
    }


    public void placeShip(Square[][] ocean) {
        for (int i = 0; i < this.shipType.getShipLength(); i++) {
            switch (this.shipOrientation) {
                case HORIZONTAL: {
                    ocean[this.shipStartY][this.shipStartX + i].setSquareStatus(SquareStatus.SHIP);
                    break;
                }
                case VERTICAL: {
                    ocean[this.shipStartY + i][this.shipStartX].setSquareStatus(SquareStatus.SHIP);
                    break;
                }
            }
        }
    }

    public void placeShipOnPlacementBoard(Square[][] ocean) {
        for (int i = 0; i < this.shipType.getShipLength(); i++) {
            switch (this.shipOrientation) {
                case HORIZONTAL: {
                    for (int j = -1; j < 2; j++) {
                        for (int k = -1; k < 2; k++)
                            if ((this.shipStartY + j) >= 0 && (this.shipStartY + j) < ocean.length && this.shipStartX + i + k >= 0 && this.shipStartX + i + k < ocean.length) {
                                ocean[this.shipStartY + j][this.shipStartX + i + k].setSquareStatus(SquareStatus.SHIP);
                            }
                    }
                    break;
                }
                case VERTICAL: {
                    for (int j = -1; j < 2; j++) {
                        for (int k = -1; k < 2; k++)
                            if ((this.shipStartY + i + j) >= 0 && (this.shipStartY + i + j) < ocean.length && this.shipStartX + k >= 0 && this.shipStartX + k < ocean.length) {
                                ocean[this.shipStartY + i + j][this.shipStartX + k].setSquareStatus(SquareStatus.SHIP);
                            }
                    }
                    break;


                }
            }
        }
    }

    public ArrayList<Square> getSquaresList() {
        return squaresList;
    }

    public ArrayList<Square> getPlacementSquaresList() {
        return placementSquaresList;
    }


    public void setShipOrientation(ShipOrientation shipOrientation) {
        this.shipOrientation = shipOrientation;
    }

    public void setSquaresList() {
        this.squaresList.clear();
        for (int i = 0; i < this.shipType.getShipLength(); i++) {
            switch (this.shipOrientation) {
                case HORIZONTAL: {
                    this.squaresList.add(
                            new Square(this.shipStartY, this.shipStartX + i, SquareStatus.SHIP));
                    break;
                }
                case VERTICAL: {
                    this.squaresList.add(
                            new Square(this.shipStartY + i, this.shipStartX, SquareStatus.SHIP));
                    break;
                }
            }
        }


    }

    public void setSquaresList(ArrayList<Square> squaresList) {
        this.squaresList = squaresList;
    }

    public void setPlacementSquaresList(ArrayList<Square> placementSquaresList) {
        this.placementSquaresList = placementSquaresList;
    }

    public ShipOrientation getShipOrientation() {
        return shipOrientation;
    }

    public ShipType getShipType() {
        return shipType;
    }

    public void setShipType(ShipType shipType) {
        this.shipType = shipType;
    }

    public int getShipStartX() {
        return shipStartX;
    }

    public void setShipStartX(int shipStartX) {
        this.shipStartX = shipStartX;
    }

    public int getShipStartY() {
        return shipStartY;
    }

    public void setShipStartY(int shipStartY) {
        this.shipStartY = shipStartY;
    }
}
