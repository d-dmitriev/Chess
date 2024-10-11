package home.work.game.piece.base;

import home.work.game.piece.ChessPiece;

public abstract class BaseBishop extends ChessPiece {
    public BaseBishop(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(int line, int column, int toLine, int toColumn) {
        return Math.abs(line - toLine) == Math.abs(column - toColumn); // Диагональные перемещения
    }

    @Override
    public boolean canSpecialMoveToPosition(int line, int column, int toLine, int toColumn) {
        return false;
    }
}
