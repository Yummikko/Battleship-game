import board.BoardFactory;
import controller.Battleship;
import util.Input;
import util.InputController;
import view.Display;


public class Main {
    public static void main(String[] args) {
        InputController inputController = new InputController();
        Input input = new Input(inputController);
        Display display = new Display(input);
        BoardFactory boardFactory = new BoardFactory(display, input, inputController);
        Battleship battleship = new Battleship(display, input, boardFactory, inputController);

        battleship.gameMenu();
    }
}
