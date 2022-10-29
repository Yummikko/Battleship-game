import board.BoardFactory;
import controller.Battleship;
import util.Input;
import util.InputController;
import view.Display;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        InputController inputController = new InputController();
        Input input = new Input(inputController);
        Display display = new Display(input);
        Random random = new Random();
        BoardFactory boardFactory = new BoardFactory(display, input, random, inputController);
        Battleship battleship = new Battleship(display, input, boardFactory);
        battleship.gameMenu();
    }
}
