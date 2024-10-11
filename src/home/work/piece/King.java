package home.work.piece;

import home.work.game.Game;

import static home.work.game.Constants.*;

public class King extends ChessPiece {
    public King(String color) {
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
        if (Math.abs(line - toLine) > 1 || Math.abs(column - toColumn) > 1) return false;
        return !isUnderAttack(game, toLine, toColumn);
    }

    @Override
    public String getSymbol() {
        return KING_SYMBOL;
    }

    public boolean isUnderAttack(Game game, int line, int column) {
        /*
         * 7 | 0 0 0 0 K 0 0 0
         * 6 | 0 0 0 0 1 0 0 0
         * 5 | 0 0 0 0 2 0 0 0
         * 4 | 0 0 0 0 3 0 0 0
         * 3 | 0 0 0 0 4 0 0 0
         * 2 | 0 0 0 0 5 0 0 0
         * 1 | 0 0 0 0 6 0 0 0
         * 0 | 0 0 0 0 7 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        for (int bottomLine = line - 1; bottomLine >= BOTTOM_PLAYER_KING_LINE; bottomLine--) {
            if (!game.isEmptyCell(bottomLine, column) && game.isCurrentPlayerPieceOnCell(bottomLine, column)) break;
            if (game.isOpponentPieceOnCell(bottomLine, column) && (game.isRookOnCell(bottomLine, column) || game.isQueenOnCell(bottomLine, column) || (line - bottomLine == 1 && game.isKingOnCell(bottomLine, column)))) return true;
        }
        /*
         * 7 | 0 0 0 0 7 0 0 0
         * 6 | 0 0 0 0 6 0 0 0
         * 5 | 0 0 0 0 5 0 0 0
         * 4 | 0 0 0 0 4 0 0 0
         * 3 | 0 0 0 0 3 0 0 0
         * 2 | 0 0 0 0 2 0 0 0
         * 1 | 0 0 0 0 1 0 0 0
         * 0 | 0 0 0 0 K 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        for (int topLine = line + 1; topLine <= TOP_PLAYER_KING_LINE; topLine++) {
            if (!game.isEmptyCell(topLine, column) && game.isCurrentPlayerPieceOnCell(topLine, column)) break;
            if (game.isOpponentPieceOnCell(topLine, column) && (game.isRookOnCell(topLine, column) || game.isQueenOnCell(topLine, column) || (topLine - line == 1 && game.isKingOnCell(topLine, column)))) return true;
        }
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | K 1 2 3 4 5 6 7
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        for (int rightColumn = column + 1; rightColumn <= RIGHT_ROOK_INIT_POSITION; rightColumn++) {
            if (!game.isEmptyCell(line, rightColumn) && game.isCurrentPlayerPieceOnCell(line, rightColumn)) break;
            if (game.isOpponentPieceOnCell(line, rightColumn) && (game.isRookOnCell(line, rightColumn) || game.isQueenOnCell(line, rightColumn) || (rightColumn - column == 1 && game.isKingOnCell(line, rightColumn)))) return true;
        }
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 7 6 5 4 3 2 1 K
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        for (int leftColumn = column - 1; leftColumn >= LEFT_ROOK_INIT_POSITION; leftColumn--) {
            if (!game.isEmptyCell(line, leftColumn) && game.isCurrentPlayerPieceOnCell(line, leftColumn)) break;
            if (game.isOpponentPieceOnCell(line, leftColumn) && (game.isRookOnCell(line, leftColumn) || game.isQueenOnCell(line, leftColumn) || (column - leftColumn == 1 && game.isKingOnCell(line, leftColumn)))) return true;
        }
        /*
         * 7 | 0 0 0 0 0 0 0 4
         * 6 | 0 0 0 0 0 0 3 0
         * 5 | 0 0 0 0 0 2 0 0
         * 4 | 0 0 0 0 1 0 0 0
         * 3 | 0 0 0 K 0 0 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        for (int topLine = line + 1, rightColumn = column + 1; topLine <= TOP_PLAYER_KING_LINE && rightColumn <= RIGHT_ROOK_INIT_POSITION; topLine++, rightColumn++) {
            if (!game.isEmptyCell(topLine, rightColumn) && game.isCurrentPlayerPieceOnCell(topLine, rightColumn)) break;
            if (game.isOpponentPieceOnCell(topLine, rightColumn) && (game.isBishopOnCell(topLine, rightColumn) || game.isQueenOnCell(topLine, rightColumn) || (topLine - line == 1 && rightColumn - column == 1 && game.isKingOnCell(topLine, rightColumn)))) return true;
        }
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 3 0 0 0 0 0 0 0
         * 5 | 0 2 0 0 0 0 0 0
         * 4 | 0 0 1 0 0 0 0 0
         * 3 | 0 0 0 K 0 0 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        for (int topLine = line + 1, leftColumn = column - 1; topLine <= TOP_PLAYER_KING_LINE && leftColumn >= LEFT_ROOK_INIT_POSITION; topLine++, leftColumn--) {
            if (!game.isEmptyCell(topLine, leftColumn) && game.isCurrentPlayerPieceOnCell(topLine, leftColumn)) break;
            if (game.isOpponentPieceOnCell(topLine, leftColumn) && (game.isBishopOnCell(topLine, leftColumn) || game.isQueenOnCell(topLine, leftColumn) || (topLine - line == 1 && column - leftColumn == 1 && game.isKingOnCell(topLine, leftColumn)))) return true;
        }
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 K 0 0 0 0
         * 2 | 0 0 0 0 1 0 0 0
         * 1 | 0 0 0 0 0 2 0 0
         * 0 | 0 0 0 0 0 0 3 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        for (int bottomLine = line - 1, rightColumn = column + 1; bottomLine >= BOTTOM_PLAYER_KING_LINE && rightColumn <= RIGHT_ROOK_INIT_POSITION; bottomLine--, rightColumn++) {
            if (!game.isEmptyCell(bottomLine, rightColumn) && game.isCurrentPlayerPieceOnCell(bottomLine, rightColumn)) break;
            if (game.isOpponentPieceOnCell(bottomLine, rightColumn) && (game.isBishopOnCell(bottomLine, rightColumn) || game.isQueenOnCell(bottomLine, rightColumn) || (line - bottomLine == 1 && rightColumn - column == 1 && game.isKingOnCell(bottomLine, rightColumn)))) return true;
        }
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 K 0 0 0 0
         * 2 | 0 0 1 0 0 0 0 0
         * 1 | 0 2 0 0 0 0 0 0
         * 0 | 3 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        for (int bottomLine = line - 1, leftColumn = column - 1; bottomLine >= BOTTOM_PLAYER_KING_LINE && leftColumn >= LEFT_ROOK_INIT_POSITION; bottomLine--, leftColumn--) {
            if (!game.isEmptyCell(bottomLine, leftColumn) && game.isCurrentPlayerPieceOnCell(bottomLine, leftColumn)) break;
            if (game.isOpponentPieceOnCell(bottomLine, leftColumn) && (game.isBishopOnCell(bottomLine, leftColumn) || game.isQueenOnCell(bottomLine, leftColumn) || (line - bottomLine == 1 && column - leftColumn == 1 && game.isKingOnCell(bottomLine, leftColumn)))) return true;
        }
        return false;
    }
}
