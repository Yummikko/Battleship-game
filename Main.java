import controller.Battleship;
import util.Input;
import view.Display;

public class Main {
    public static void main(String[] args) {
        Display display = new Display();
        Input input = new Input();
        Battleship battleship = new Battleship(display, input);

        battleship.playGame();
    }
}
