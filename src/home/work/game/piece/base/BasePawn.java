package home.work.game.piece.base;

import home.work.game.piece.ChessPiece;

import static home.work.game.Colors.BOTTOM_PLAYER_COLOR;
import static home.work.game.Colors.TOP_PLAYER_COLOR;

public abstract class BasePawn extends ChessPiece {
    public BasePawn(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(int line, int column, int toLine, int toColumn) {
        return column == toColumn //Шагаем прямо
//                && Math.abs(line - toLine) >= 1 && Math.abs(line - toLine) <= 2
                && (
                (color.equals(TOP_PLAYER_COLOR) && line == 6 && line - toLine == 2) // Черные с начальной позиции могут идти вниз на 2 клетки
                        || (color.equals(BOTTOM_PLAYER_COLOR) && line == 1 && line - toLine == -2) // Белые с начальной позиции могут идти вверх на 2 клетки
                        || (color.equals(TOP_PLAYER_COLOR) && line - toLine == 1) // Черные могут идти вниз по одной клетке
                        || (color.equals(BOTTOM_PLAYER_COLOR) && line - toLine == -1) // Белый могут идти вверх по одной клетке
        );
    }

    @Override
    public boolean canSpecialMoveToPosition(int line, int column, int toLine, int toColumn) {
        return Math.abs(column - toColumn) == 1 && //Math.abs(line - toLine) == 1;
                (color.equals(TOP_PLAYER_COLOR) && line - toLine == 1 || color.equals(BOTTOM_PLAYER_COLOR) && line - toLine == -1); // Едим только вперед
    }
}
