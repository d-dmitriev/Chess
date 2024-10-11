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
        if (!game.checkPos(toLine) || !game.checkPos(toColumn)) return false;
        return (column == toColumn && (
                (color.equals(TOP_PLAYER_COLOR) && line == 6 && Math.abs(line - toLine) == 2) ||
                        (color.equals(BOTTOM_PLAYER_COLOR) && line == 1 && Math.abs(line - toLine) == 2) ||
                        (color.equals(TOP_PLAYER_COLOR) && line - toLine == 1) ||
                        (color.equals(BOTTOM_PLAYER_COLOR) && line - toLine == -1)
        )) || (game.isOpponentPieceOnCell(toLine, toColumn) && !game.isKingOnCell(toLine, toColumn) && (
                (color.equals(TOP_PLAYER_COLOR) && line - toLine == 1 || color.equals(BOTTOM_PLAYER_COLOR) && line - toLine == -1)
                        && Math.abs(column - toColumn) == 1)
        );
    }

    @Override
    public String getSymbol() {
        return PAWN_SYMBOL;
    }
}
