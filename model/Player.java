package model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Ship> shipList;

    public Player() {
        this.shipList = new ArrayList<>();
        createShipList();
    }

    public void createShipList(){
        for (ShipType shipType : ShipType.values()){
            addShips(new Ship(shipType));
        }
    }

    public void addShips(Ship ship) {
        shipList.add(ship);
    }

    public List<Ship> getShipList() {
        return shipList;
    }

    public void setShipList(List<Ship> shipList) {
        this.shipList = shipList;
    }

}
