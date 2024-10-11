package home.work.piece;

import home.work.game.Game;

import static home.work.game.Constants.QUEEN_SYMBOL;

public class Queen extends ChessPiece {
    public Queen(String color) {
        super(color);
    }

    /*
     * Реализуйте метод canMoveToPosition() так, чтобы фигуры не могли выйти за доску
     * (доска в нашем случае — это двумерный массив размером 8 на 8, напоминаем, что индексы начинаются с 0) и
     * могли ходить так, как ходят в шахматах (Королева ходит и по диагонали и по прямой, Король — в любое поле вокруг себя),
     * также фигура не может сходить в точку, в которой она сейчас находится.
     * Если фигура может пройти от точки (line, column) до точки (toLine, toColumn) по всем правилам (указанным выше),
     * то функция вернет true, иначе — false.
     */
    @Override
    public boolean canMoveToPosition(Game game, int line, int column, int toLine, int toColumn) {
        if (!game.checkPos(toLine) || !game.checkPos(toColumn)) return false;
        if (Math.abs(line - toLine) != Math.abs(column - toColumn) && line != toLine && column != toColumn) return false;
        if (!game.isLineBetweenCellEmpty(line, column, toLine, toColumn)) return false;
        return game.isOpponentPieceOnCell(toLine, toColumn) || game.isEmptyCell(toLine, toColumn);
    }

    @Override
    public String getSymbol() {
        return QUEEN_SYMBOL;
    }
}
