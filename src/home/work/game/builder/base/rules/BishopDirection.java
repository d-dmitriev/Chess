package home.work.game.builder.base.rules;

public enum BishopDirection {
    NORTH_EAST(1, 1),
    SOUTH_EAST(-1, 1),
    SOUTH_WEST(-1, -1),
    NORTH_WEST(1, -1);

    public final int line;
    public final int column;

    BishopDirection(int line, int column) {
        this.line = line;
        this.column = column;
    }
}
