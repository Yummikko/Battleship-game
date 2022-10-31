package board;

import model.Player;
import model.Ship;
import util.Input;
import util.InputController;
import view.Display;
import java.util.Arrays;
import java.util.Random;


public class BoardFactory {
    private Display display;
    private Input input;
    private Random random;
    private Ship ship;
    private InputController inputController;

    public BoardFactory(Display display, Input input, Random random, InputController inputController) {
        this.display = display;
        this.input = input;
        this.random = random;
        this.inputController = inputController;
    }

    public void choosePlacement(Player player, Board playerBoard) {
        display.printPlacementMode();
        int placementMode = input.getValue();
        switch (placementMode){
            case 1: { manualPlacement(player, playerBoard);
                break;
            }
            case 2: { randomPlacement(player, playerBoard);
                break;
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
                Integer[] shipPlace = input.convertedCoordinates();
                currentShip.setShipStartY(shipPlace[0]);
                currentShip.setShipStartX(shipPlace[1]);

                display.printBlueMessages("\nPlease insert orientation, where H means Horizontal and V means Vertical\n");
                int orientation = input.getOrientation();
                currentShip.setShipOrientation(orientation == 0 ? Ship.ShipOrientation.HORIZONTAL : Ship.ShipOrientation.VERTICAL);
                currentShip.setSquaresList();
                isFirstTry = false;
            } while (!(playerBoard.isPlacementOk(currentShip)));
            currentShip.placeShip(playerBoard.getOcean());
            display.showBoard(playerBoard.getOcean(), false);
            //currentShip.placeShipOnPlacementBoard(playerBoard.getOcean());
        }
    }

    public void randomPlacement(Player player, Board playerBoard) {

        display.printBlueMessages("\nYou chose random ship placement.\n");
        for (Ship currentShip : player.getShipList()) {
            boolean isFirstTry = true;
            do {
                currentShip.setShipStartY(new Random().nextInt(playerBoard.getSideLength()));
                currentShip.setShipStartX(new Random().nextInt(playerBoard.getSideLength()));

                String[] directions = {"H", "V"};
                String direction = directions[new Random().nextInt(2)];
                int orientationNumber = (Arrays.asList(directions)).indexOf(direction.toUpperCase());
                currentShip.setShipOrientation(orientationNumber == 0 ? Ship.ShipOrientation.HORIZONTAL : Ship.ShipOrientation.VERTICAL);
                currentShip.setSquaresList();
                isFirstTry = false;
            } while (!(playerBoard.isPlacementOk(currentShip)));
            currentShip.placeShip(playerBoard.getOcean());
            inputController.pause(1000);
            display.showBoard(playerBoard.getOcean(), false);
            display.showShips();
            display.shipSizeVisualisation();
        }
    }
}
