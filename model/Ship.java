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

    public Ship(ShipType shipType) {
        this.shipType = shipType;
        this.squaresList = new ArrayList<>();
        this.placementSquaresList = new ArrayList<>();
    }

    public Integer getX() {
        return shipStartX;
    }

    public Integer getY() {
        return shipStartY;
    }


    public enum ShipOrientation {
        VERTICAL, HORIZONTAL
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

    public boolean isSunk() {
        if (squaresList != null) {
            for (Square s : squaresList) {
                if (s.getSquareStatus() == SquareStatus.SHIP) {
                    return false;
                }
            }
        }
        return true;
    }


}
