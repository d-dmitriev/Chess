package home.work.game.piece.base;

import home.work.game.piece.ChessPiece;

public abstract class BaseHorse extends ChessPiece {
    public BaseHorse(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(int line, int column, int toLine, int toColumn) {
        return (Math.abs(line - toLine) == 2 && Math.abs(column - toColumn) == 1) || (Math.abs(line - toLine) == 1 && Math.abs(column - toColumn) == 2);
    }

    @Override
    public boolean canSpecialMoveToPosition(int line, int column, int toLine, int toColumn) {
        return false;
    }
}
