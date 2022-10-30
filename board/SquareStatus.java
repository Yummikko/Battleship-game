package board;

public enum SquareStatus {
    EMPTY (" "),
    SHIP ("S"),
    HIT ("H"),
    MISSED ("M"),
    SUNK("X");

    private final String CHARACTER;

    SquareStatus (String character) {
        this.CHARACTER = character;
    }

    public String getCharacter() {
        return CHARACTER;
    }


}
