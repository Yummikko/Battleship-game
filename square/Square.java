package square;

public class Square {
    private final int X;
    private final int Y;
    private SquareStatus squareStatus;

    public Square(int x, int y, SquareStatus squareStatus) {
        X = x;
        Y = y;
        this.squareStatus = squareStatus;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public SquareStatus getSquareStatus() {
        return squareStatus;
    }


}


