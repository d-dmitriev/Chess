package home.work.piece;

import home.work.game.Game;

import static home.work.game.Constants.BOTTOM_PLAYER_COLOR;
import static home.work.game.Constants.HORSE_SYMBOL;

public class Horse extends ChessPiece {
    public Horse(String color) {
        super(color);
    }

    /*
     * Реализуйте метод canMoveToPosition() так, чтобы конь не мог выйти за доску
     * (доска в нашем случае — это двумерный массив размером 8 на 8, напоминаем,
     * что индексы начинаются с 0) и мог ходить только буквой «Г».
     * Также фигура не может сходить в точку, в которой она сейчас находится.
     * Если конь может пройти от точки (line, column) до точки (toLine, toColumn)
     * по всем правилам (указанным выше), то функция вернет true, иначе — false.
     */
    @Override
    public boolean canMoveToPosition(Game game, int line, int column, int toLine, int toColumn) {
        if (!game.checkPos(toLine) || !game.checkPos(toColumn)) return false; // Не выходить за пределы
        if (game.isKingOnCell(toLine, toColumn)) return false; //Не едим Короля
        return isHorseMove(line, column, toLine, toColumn) // Как ходит конь?
                && game.isOpponentOrEmpty(toLine, toColumn); // Ходить можно если целевая клетка пуста или на ней фигура противника
    }

    @Override
    public String getSymbol() {
        return HORSE_SYMBOL;
    }

    @Override
    public String getSymbolForBoard() {
        return getColor().equals(BOTTOM_PLAYER_COLOR) ? "\u001B[37m♞" : "\u001B[30m♞";
    }

    private static boolean isHorseMove(int line, int column, int toLine, int toColumn) {
        return (Math.abs(line - toLine) == 2 && Math.abs(column - toColumn) == 1) || (Math.abs(line - toLine) == 1 && Math.abs(column - toColumn) == 2);
    }
}
