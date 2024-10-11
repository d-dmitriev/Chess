package home.work.game.piece.base;

import home.work.game.piece.ChessPiece;

public abstract class BaseRook extends ChessPiece {
    public BaseRook(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(int line, int column, int toLine, int toColumn) {
        return line == toLine || column == toColumn;
    }

    @Override
    public boolean canSpecialMoveToPosition(int line, int column, int toLine, int toColumn) {
        return false;
    }
}
