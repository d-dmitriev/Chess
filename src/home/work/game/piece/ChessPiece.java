package home.work.game.piece;

public abstract class ChessPiece {
    public String color;
    boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void uncheck() {
        check = false;
    }

    public boolean isNotMove() {
        return !check;
    }

    public boolean hasColor(String color) {
        return this.color.equals(color);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public abstract boolean canMoveToPosition(int line, int column, int toLine, int toColumn);

    public abstract String getSymbol();

    public abstract boolean canSpecialMoveToPosition(int line, int column, int toLine, int toColumn);
}
