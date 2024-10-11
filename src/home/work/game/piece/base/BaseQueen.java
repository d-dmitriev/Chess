package home.work.game.piece.base;

import home.work.game.piece.ChessPiece;

public abstract class BaseQueen extends ChessPiece {
    public BaseQueen(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(int line, int column, int toLine, int toColumn) {
        return Math.abs(line - toLine) == Math.abs(column - toColumn) || line == toLine || column == toColumn;
    }

    @Override
    public boolean canSpecialMoveToPosition(int line, int column, int toLine, int toColumn) {
        return false;
    }
}
