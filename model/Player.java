package model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final List<Ship> SHIP_LIST;

    public Player() {
        this.SHIP_LIST = new ArrayList<>();
        createShipList();
    }

    public void createShipList(){
        for (ShipType shipType : ShipType.values()){
            addShips(new Ship(shipType));
        }
    }

    public void addShips(Ship ship) {
        SHIP_LIST.add(ship);
    }

    public List<Ship> getShipList() {
        return SHIP_LIST;
    }

}
