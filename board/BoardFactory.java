package board;

import model.Player;
import model.Ship;
import util.Input;
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

    public void choosePlacement(Player player, Board playerBoard, Board placementBoard){
        display.printMessage(String.format("%s, your turn!"));
        display.printPlacementMode();
        int placementMode = input.getValue();
        switch (placementMode){
            case 1: {manualPlacement(player, playerBoard, placementBoard);
                break;}
//            case 2: {randomPlacement(player, playerBoard, placementBoard);
//                break;}
        }

    }

    public void manualPlacement(Player player, Board playerBoard, Board placementBoard){
        display.printMessage(String.format("%s you chose manual ship placement. Place your ships."));
        for (Ship currentShip : player.getShipList()){
            boolean isFirstTry = true;
            display.showBoard(playerBoard.getOcean());
            do{
                if (!isFirstTry){
                    display.printMessage("You can not place your ship on the place you chose. Please select other option.");
                }
                display.printMessage("Please insert row number: ");
                int rowNumber = input.getRowNumber();
                currentShip.setShipStartY(rowNumber);
                display.printMessage("Please insert column letter: ");
//                int columnNumber = input.getColumnLetter();
//                currentShip.setShipStartX(columnNumber);
                display.printMessage("Please insert orientation, where H means Horizontal and V means Vertical");
                int orientation = input.getOrientation();
                currentShip.setShipOrientation(orientation == 0 ? Ship.ShipOrientation.HORIZONTAL : Ship.ShipOrientation.VERTICAL);
                currentShip.setSquaresList();
                isFirstTry = false;
            } while (!(playerBoard.isPlacementOk(currentShip, placementBoard.getOcean())));
            currentShip.placeShip(playerBoard.getOcean());
            currentShip.placeShipOnPlacementBoard(placementBoard.getOcean());}
        display.showBoard(playerBoard.getOcean());
    };
}