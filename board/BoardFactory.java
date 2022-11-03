package board;

import model.Player;
import model.Ship;
import util.Input;
import util.InputController;
import view.Display;
import java.util.Arrays;
import java.util.Random;


public class BoardFactory {
    private final Display DISPLAY;
    private final Input INPUT;
    private final InputController INPUT_CONTROLLER;

    public BoardFactory(Display display, Input input, InputController inputController) {
        this.DISPLAY = display;
        this.INPUT = input;
        this.INPUT_CONTROLLER = inputController;
    }

    public void choosePlacementMode(Player player, Board playerBoard) {
        DISPLAY.printPlacementMode();
        int placementMode = INPUT.getValue();
        switch (placementMode) {
            case 1 -> {
                manualPlacement(player, playerBoard);
            }
            case 2 -> {
                randomPlacement(player, playerBoard);
            }
        }
    }

    public void manualPlacement(Player player, Board playerBoard) {
        DISPLAY.printBlueMessages("\nYou chose manual ship placement. Please place your ships.\n");
        DISPLAY.showBoard(playerBoard.getOcean(), false);
        for (Ship currentShip : player.getShipList()) {
            boolean isFirstTry = true;
            DISPLAY.showShips();
            DISPLAY.shipSizeVisualisation();
            do {
                if (!isFirstTry) {
                    DISPLAY.printRedMessages("\nYou can not place your ship on the place you chose. Please select other option.\n");
                }
                DISPLAY.printBlueMessages("\nPlease provide ship's starting place: \n");
                Integer[] shipPlace = INPUT.convertedCoordinates();
                currentShip.setShipStartY(shipPlace[0]);
                currentShip.setShipStartX(shipPlace[1]);

                DISPLAY.printBlueMessages("\nPlease insert orientation, where H means Horizontal and V means Vertical\n");
                int orientation = INPUT.getOrientation();
                currentShip.setShipOrientation(orientation == 0 ? Ship.ShipOrientation.HORIZONTAL : Ship.ShipOrientation.VERTICAL);
                currentShip.setSquaresList();
                isFirstTry = false;
            } while (!(playerBoard.isPlacementOk(currentShip)));
            currentShip.placeShip(playerBoard.getOcean());
            DISPLAY.showBoard(playerBoard.getOcean(), false);
        }
    }

    public void randomPlacement(Player player, Board playerBoard) {

        DISPLAY.printBlueMessages("\nYou chose random ship placement.\n");
        for (Ship currentShip : player.getShipList()) {
            do {
                currentShip.setShipStartY(new Random().nextInt(playerBoard.getSideLength()));
                currentShip.setShipStartX(new Random().nextInt(playerBoard.getSideLength()));

                String[] directions = {"H", "V"};
                String direction = directions[new Random().nextInt(2)];
                int orientationNumber = (Arrays.asList(directions)).indexOf(direction.toUpperCase());
                currentShip.setShipOrientation(orientationNumber == 0 ? Ship.ShipOrientation.HORIZONTAL : Ship.ShipOrientation.VERTICAL);
                currentShip.setSquaresList();
            } while (!(playerBoard.isPlacementOk(currentShip)));
            currentShip.placeShip(playerBoard.getOcean());
            INPUT_CONTROLLER.pause(1000);
            DISPLAY.showBoard(playerBoard.getOcean(), false);
            DISPLAY.showShips();
            DISPLAY.shipSizeVisualisation();
        }
    }
}
