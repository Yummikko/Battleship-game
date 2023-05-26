package model;


public enum ShipType {
    CARRIER(5),
    CRUISER(4),
    BATTLESHIP(3),
    SUBMARINE(2),
    DESTROYER(1);
    ;

    private final int shipLength;

    ShipType(int shipLength) {this.shipLength = shipLength;}

    public int getShipLength() {
        return this.shipLength;
    }
}
