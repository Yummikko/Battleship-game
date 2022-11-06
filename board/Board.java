package board;

import model.Ship;
import view.Colors;
import java.util.ArrayList;
import java.util.Objects;

public class Board {
    private Square[][] ocean;
    public Integer sideLength;

    public Board(Integer sideLength) {
        this.sideLength = sideLength;
    }

    public Square[][] getOcean() {
        return ocean;
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

    public boolean checkNeighbours(ArrayList<Square> shipElements){
        for (int i = 0; i < shipElements.size(); i++) {
            int x = shipElements.get(i).getX();
            int y = shipElements.get(i).getY();
            if(x == 0){
                if(y == 0){
                    if(ocean[x+1][y].getSquareStatus() == SquareStatus.SHIP || ocean[x][y+1].getSquareStatus() == SquareStatus.SHIP){
                        return false;
                    }
                } else {
                    if(ocean[x][y-1].getSquareStatus()  == SquareStatus.SHIP || ocean[x][y+1].getSquareStatus() == SquareStatus.SHIP ||
                    ocean[x+1][y].getSquareStatus() == SquareStatus.SHIP){
                        return false;
                    }
                }
            } else {
                if(y == 0) {
                    if(ocean[x+1][y].getSquareStatus() == SquareStatus.SHIP || ocean[x-1][y].getSquareStatus() == SquareStatus.SHIP ||
                    ocean[x][y+1].getSquareStatus() == SquareStatus.SHIP){
                        return false;
                    }
                } else {
                    if(ocean[x+1][y].getSquareStatus() == SquareStatus.SHIP || ocean[x-1][y].getSquareStatus() == SquareStatus.SHIP ||
                    ocean[x][y+1].getSquareStatus() == SquareStatus.SHIP || ocean[x][y-1].getSquareStatus()  == SquareStatus.SHIP){
                        return false;
                    }
                }
            }
        }
        return true;
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
        return checkNeighbours(shipsElements);
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
                    //System.out.println(ocean[j][i].getSquareStatus().getCharacter());
                    if (Objects.equals(ocean[j][i].getSquareStatus().getCharacter(), "S")) {
                        changeSquareStatus(SquareStatus.HIT, ocean[j][i]);
                        System.out.println(Colors.CYAN_BOLD + "\n\nYou hit Your enemy ship! ");
                    } else if (Objects.equals(ocean[j][i].getSquareStatus().getCharacter(), "H")
                    || Objects.equals(ocean[j][i].getSquareStatus().getCharacter(), "M")){
                        System.out.println(Colors.ANSI_RED + "\n\nYou already shot this place! ");
                    } else {
                        changeSquareStatus(SquareStatus.MISSED, ocean[j][i]);
                        System.out.println(Colors.ANSI_RED + "\n\nYou missed! ");
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
