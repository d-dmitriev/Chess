package home.work.piece;

import home.work.game.Game;

import static home.work.game.Constants.BISHOP_SYMBOL;
import static home.work.game.Constants.BOTTOM_PLAYER_COLOR;

public class Bishop extends ChessPiece {
    public Bishop(String color) {
        super(color);
    }

    /*
     * Реализуйте метод canMoveToPosition() так, чтобы слон не мог выйти за доску
     * (доска в нашем случае — это двумерный массив размером 8 на 8, напоминаем, что индексы начинаются с 0) и
     * мог ходить только по диагонали, также фигура не может сходить в точку, в которой она сейчас находится.
     * Если слон может пройти от точки (line, column) до точки (toLine, toColumn) по всем правилам (указанным выше),
     * то функция вернет true, иначе — false.
     */
    @Override
    public boolean canMoveToPosition(Game game, int line, int column, int toLine, int toColumn) {
        if (!game.checkPos(toLine) || !game.checkPos(toColumn)) return false; // Не выходить за пределы
        if (game.isKingOnCell(toLine, toColumn)) return false; //Не едим Короля
        if (!game.isLineBetweenCellEmpty(line, column, toLine, toColumn)) // Перепрыгивать через другие фигуры запрещено
            return false;
        return isBishopMovie(line, column, toLine, toColumn) // Как ходит Ладья?
                && game.isOpponentOrEmpty(toLine, toColumn); // Ходить можно если целевая клетка пуста или на ней фигура противника
    }

    @Override
    public String getSymbol() {
        return BISHOP_SYMBOL;
    }

    @Override
    public String getSymbolForBoard() {
        return getColor().equals(BOTTOM_PLAYER_COLOR) ? "\u001B[37m♝" : "\u001B[30m♝";
    }

    private static boolean isBishopMovie(int line, int column, int toLine, int toColumn) {
        return Math.abs(line - toLine) == Math.abs(column - toColumn); // Диагональные перемещения
    }
}
