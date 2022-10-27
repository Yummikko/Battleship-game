package board;

import model.Player;
import model.Ship;
import util.Input;
import util.InputController;
import view.Colors;
import view.Display;

import java.util.Random;

public class BoardFactory {
    private Display display;
    private Input input;
    private Random random;
    private Ship ship;

    public BoardFactory(Display display, Input input, Random random) {
        this.display = display;
        this.input = input;
        this.random = random;
    }

//    public void choosePlacement(Player player, Board playerBoard, Board placementBoard){
//        display.printMessage(String.format("%s, your turn!"));
//        display.printPlacementMode();
//        int placementMode = input.getValue();
//        switch (placementMode){
//            case 1: {manualPlacement(player, playerBoard);
//                break;}
////            case 2: {randomPlacement(player, playerBoard, placementBoard);
////                break;}
//        }
//
//    }

    public void manualPlacement(Player player, Board playerBoard) {
        display.printBlueMessages("\nYou chose manual ship placement. Place your ships.\n");
        for (Ship currentShip : player.getShipList()) {
            boolean isFirstTry = true;
            display.showBoard(playerBoard.getOcean());
            display.showShips();
            display.shipSizeVisualisation();
            do {
                if (!isFirstTry) {
                    display.printRedMessages("\nYou can not place your ship on the place you chose. Please select other option.\n");
                }
                display.printBlueMessages("\nPlease provide ship's starting place: \n");
                Integer[] shipPlace = input.convertedCoordinates();
                currentShip.setShipStartY(shipPlace[0]);
                currentShip.setShipStartX(shipPlace[1]);

                display.printBlueMessages("\nPlease insert orientation, where H means Horizontal and V means Vertical\n");
                int orientation = input.getOrientation();
                currentShip.setShipOrientation(orientation == 0 ? Ship.ShipOrientation.HORIZONTAL : Ship.ShipOrientation.VERTICAL);
                currentShip.setSquaresList();
                isFirstTry = false;
            } while (!(playerBoard.isPlacementOk(currentShip, playerBoard.getOcean())));
            currentShip.placeShip(playerBoard.getOcean());
            //currentShip.placeShipOnPlacementBoard(playerBoard.getOcean());
        }
    }
}
