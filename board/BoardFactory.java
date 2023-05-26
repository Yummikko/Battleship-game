package board;

import model.Player;
import model.Ship;
import util.Input;
import util.InputController;
import view.Display;
import java.util.Arrays;
import java.util.Random;


public class BoardFactory {
    private final Display display;
    private final Input INPUT;
    private final InputController INPUT_CONTROLLER;

    public BoardFactory(Display display, Input input, InputController inputController) {
        this.display = display;
        this.INPUT = input;
        this.INPUT_CONTROLLER = inputController;
    }

    public void choosePlacementMode(Player player, Board playerBoard) {
        display.printPlacementMode();
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
        display.printBlueMessages("\nYou chose manual ship placement. Please place your ships.\n");
        display.showBoard(playerBoard.getOcean(), false);
        for (Ship currentShip : player.getShipList()) {
            boolean isFirstTry = true;
            display.showShips();
            display.shipSizeVisualisation();
            do {
                if (!isFirstTry) {
                    display.printRedMessages("\nYou can not place your ship on the place you chose. Please select other option.\n");
                }
                display.printBlueMessages("\nPlease provide ship's starting place: \n");
                Integer[] shipPlace = INPUT.convertedCoordinates();
                currentShip.setShipStartY(shipPlace[0]);
                currentShip.setShipStartX(shipPlace[1]);

                display.printBlueMessages("\nPlease insert orientation, where H means Horizontal and V means Vertical\n");
                int orientation = INPUT.getOrientation();
                currentShip.setShipOrientation(orientation == 0 ? Ship.ShipOrientation.HORIZONTAL : Ship.ShipOrientation.VERTICAL);
                currentShip.setSquaresList();
                isFirstTry = false;
            } while (!(playerBoard.isPlacementOk(currentShip)));
            currentShip.placeShip(playerBoard.getOcean());
            display.showBoard(playerBoard.getOcean(), false);
        }
    }

    public void randomPlacement(Player player, Board playerBoard) {

        display.printBlueMessages("\nYou chose random ship placement.\n");
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
            display.showBoard(playerBoard.getOcean(), false);
            display.showShips();
            display.shipSizeVisualisation();
        }
    }
}
