import controller.Battleship;
import util.Input;
import view.Display;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        Display display = new Display(input);
        Battleship battleship = new Battleship(display, input);
        battleship.gameMenu();
    }
}
