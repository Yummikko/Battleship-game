package board;

public enum SquareStatus {
    EMPTY (" "),
    SHIP ("S"),
    HIT ("H"),
    MISSED ("M");

    private final String CHARACTER;

    SquareStatus (String character) {
        this.CHARACTER = character;
    }

    public String getCharacter() {
        return CHARACTER;
    }

}
