package home.work.game.builder.base.rules;

public enum RookDirection {
    NORTH(1, 0),
    EAST(0, 1),
    SOUTH(-1, 0),
    WEST(0, -1);

    public final int line;
    public final int column;

    RookDirection(int line, int column) {
        this.line = line;
        this.column = column;
    }
}
