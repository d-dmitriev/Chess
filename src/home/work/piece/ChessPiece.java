package home.work.piece;

import home.work.game.Game;

public abstract class ChessPiece {
    String color;
    boolean check = true;

    ChessPiece(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void uncheck() {
        check = false;
    }

    public boolean isCheck() {
        return check;
    }

    public boolean hasSymbol(String symbol) {
        return this.getSymbol().equals(symbol);
    }

    public boolean hasColor(String color) {
        return this.color.equals(color);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public abstract boolean canMoveToPosition(Game game, int line, int column, int toLine, int toColumn);

    public abstract String getSymbol();

    public abstract String getSymbolForBoard();
}
