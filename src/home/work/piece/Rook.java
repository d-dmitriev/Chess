package home.work.piece;

import home.work.game.Game;

import static home.work.game.Constants.ROOK_SYMBOL;

public class Rook extends ChessPiece {
    public Rook(String color) {
        super(color);
    }

    /*
     * Реализуйте метод canMoveToPosition() так, чтобы ладья не могла выйти за доску
     * (доска в нашем случае — это двумерный массив размером 8 на 8, напоминаем, что индексы начинаются с 0) и
     * мог ходить только по прямой, также фигура не может сходить в точку, в которой она сейчас находится.
     * Если ладья может пройти от точки (line, column) до точки (toLine, toColumn) по всем правилам (указанным выше),
     * то функция вернет true, иначе — false.
     */
    @Override
    public boolean canMoveToPosition(Game game, int line, int column, int toLine, int toColumn) {
        if (!game.checkPos(toLine) || !game.checkPos(toColumn)) return false;
        if (line != toLine && column != toColumn) return false;
        if (!game.isLineBetweenCellEmpty(line, column, toLine, toColumn)) return false;
        return game.isOpponentPieceOnCell(toLine, toColumn) || game.isEmptyCell(toLine, toColumn);
    }

    @Override
    public String getSymbol() {
        return ROOK_SYMBOL;
    }
}
