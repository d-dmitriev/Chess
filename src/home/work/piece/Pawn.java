package home.work.piece;

import home.work.game.Game;

import static home.work.game.Constants.*;

public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    /*
     * Реализуйте метод canMoveToPosition() так, чтобы пешка не могла выйти за доску и могла ходить только вперед.
     * Помните, что первый ход пешка может сдвинуться на 2 поля вперед, сделать это можно, например, сравнив координаты.
     * То есть, если пешка белая (color.equals("White")) и находится в line == 1, то она может пойти на 2 поля вперед,
     * иначе — нет, аналогично с черными пешками.
     * Также фигура не может сходить в точку, в которой она сейчас находится.
     * Если пешка может пройти от точки (line, column) до точки (toLine, toColumn) по всем правилам (указанным выше),
     * то функция вернет true, иначе — false.
     */
    @Override
    public boolean canMoveToPosition(Game game, int line, int column, int toLine, int toColumn) {
        if (!game.checkPos(toLine) || !game.checkPos(toColumn)) return false; // Не выходить за пределы
        return isPawnMove(line, column, toLine, toColumn) //Как ходит Пешка?
                || isPawnEat(game, line, column, toLine, toColumn);
    }

    @Override
    public String getSymbol() {
        return PAWN_SYMBOL;
    }

    @Override
    public String getSymbolForBoard() {
        return getColor().equals(BOTTOM_PLAYER_COLOR) ? "\u001B[37m♟" : "\u001B[30m♟";
    }

    private boolean isPawnEat(Game game, int line, int column, int toLine, int toColumn) {
        return game.isOpponentPieceOnCell(toLine, toColumn) //Едим только соперника
                && !game.isKingOnCell(toLine, toColumn) //Не едим Короля
                && (Math.abs(column - toColumn) == 1 && (color.equals(TOP_PLAYER_COLOR) && line - toLine == 1 || color.equals(BOTTOM_PLAYER_COLOR) && line - toLine == -1)); //Едим только вперед
    }

    private boolean isPawnMove(int line, int column, int toLine, int toColumn) {
        return column == toColumn //Шагаем прямо
                && (
                (color.equals(TOP_PLAYER_COLOR) && line == 6 && line - toLine == 2) // Черные с начальной позиции могут идти вниз на 2 клетки
                        || (color.equals(BOTTOM_PLAYER_COLOR) && line == 1 && line - toLine == -2) // Белые с начальной позиции могут идти вверх на 2 клетки
                        || (color.equals(TOP_PLAYER_COLOR) && line - toLine == 1) // Черные могут идти вниз по одной клетке
                        || (color.equals(BOTTOM_PLAYER_COLOR) && line - toLine == -1) // Белый могут идти вверх по одной клетке
        );
    }
}
