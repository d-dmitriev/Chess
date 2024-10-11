package home.work.game;

import static home.work.game.Constants.*;
import static home.work.game.Constants.LEFT_ROOK_INIT_POSITION;

public class Cell {
    private final Game game;

    public Cell(Game game) {
        this.game = game;
    }

    public boolean isLineBetweenCellEmpty(int fromLine, int fromColumn, int toLine, int toColumn) {
        for (int lineDiff = fromLine - toLine, columnDiff = fromColumn - toColumn; lineDiff != 0 || columnDiff != 0; lineDiff += Integer.compare(0, lineDiff), columnDiff += Integer.compare(0, columnDiff)) {
            int tmpLine = toLine + lineDiff, tmpColumn = toColumn + columnDiff;
            if (tmpLine == fromLine && tmpColumn == fromColumn) continue;
            if (!game.isEmptyCell(tmpLine, tmpColumn)) return false;
        }
        return true;
    }

    public boolean isUnderAttack(int line, int column) {
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
            if (game.isOpponentPieceOnCell(bottomLine, column) && (game.isRookOnCell(bottomLine, column) || game.isQueenOnCell(bottomLine, column) || (line - bottomLine == 1 && game.isKingOnCell(bottomLine, column))))
                return true;
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
            if (game.isOpponentPieceOnCell(topLine, column) && (game.isRookOnCell(topLine, column) || game.isQueenOnCell(topLine, column) || (topLine - line == 1 && game.isKingOnCell(topLine, column))))
                return true;
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
            if (game.isOpponentPieceOnCell(line, rightColumn) && (game.isRookOnCell(line, rightColumn) || game.isQueenOnCell(line, rightColumn) || (rightColumn - column == 1 && game.isKingOnCell(line, rightColumn))))
                return true;
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
            if (game.isOpponentPieceOnCell(line, leftColumn) && (game.isRookOnCell(line, leftColumn) || game.isQueenOnCell(line, leftColumn) || (column - leftColumn == 1 && game.isKingOnCell(line, leftColumn))))
                return true;
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
            if (game.isOpponentPieceOnCell(topLine, rightColumn) && (game.isBishopOnCell(topLine, rightColumn) || game.isQueenOnCell(topLine, rightColumn) || (topLine - line == 1 && rightColumn - column == 1 && game.isKingOnCell(topLine, rightColumn))))
                return true;
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
            if (game.isOpponentPieceOnCell(topLine, leftColumn) && (game.isBishopOnCell(topLine, leftColumn) || game.isQueenOnCell(topLine, leftColumn) || (topLine - line == 1 && column - leftColumn == 1 && game.isKingOnCell(topLine, leftColumn))))
                return true;
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
            if (!game.isEmptyCell(bottomLine, rightColumn) && game.isCurrentPlayerPieceOnCell(bottomLine, rightColumn))
                break;
            if (game.isOpponentPieceOnCell(bottomLine, rightColumn) && (game.isBishopOnCell(bottomLine, rightColumn) || game.isQueenOnCell(bottomLine, rightColumn) || (line - bottomLine == 1 && rightColumn - column == 1 && game.isKingOnCell(bottomLine, rightColumn))))
                return true;
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
            if (!game.isEmptyCell(bottomLine, leftColumn) && game.isCurrentPlayerPieceOnCell(bottomLine, leftColumn))
                break;
            if (game.isOpponentPieceOnCell(bottomLine, leftColumn) && (game.isBishopOnCell(bottomLine, leftColumn) || game.isQueenOnCell(bottomLine, leftColumn) || (line - bottomLine == 1 && column - leftColumn == 1 && game.isKingOnCell(bottomLine, leftColumn))))
                return true;
        }
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 X 0 0
         * 3 | 0 0 0 K 0 0 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        int horseLine = line + 1;
        int horseColumn = column + 2;
        if (game.isOpponentPieceOnCell(horseLine, horseColumn) && (game.isHorseOnCell(horseLine, horseColumn)))
            return true;
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 X 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 K 0 0 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        horseLine = line + 2;
        horseColumn = column + 1;
        if (game.isOpponentPieceOnCell(horseLine, horseColumn) && (game.isHorseOnCell(horseLine, horseColumn)))
            return true;
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 X 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 K 0 0 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        horseLine = line + 2;
        horseColumn = column - 1;
        if (game.isOpponentPieceOnCell(horseLine, horseColumn) && (game.isHorseOnCell(horseLine, horseColumn)))
            return true;
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 X 0 0 0 0 0 0
         * 3 | 0 0 0 K 0 0 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        horseLine = line + 1;
        horseColumn = column - 2;
        if (game.isOpponentPieceOnCell(horseLine, horseColumn) && (game.isHorseOnCell(horseLine, horseColumn)))
            return true;
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 K 0 0 0 0
         * 2 | 0 X 0 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        horseLine = line - 1;
        horseColumn = column - 2;
        if (game.isOpponentPieceOnCell(horseLine, horseColumn) && (game.isHorseOnCell(horseLine, horseColumn)))
            return true;
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 K 0 0 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 0 X 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        horseLine = line - 2;
        horseColumn = column - 1;
        if (game.isOpponentPieceOnCell(horseLine, horseColumn) && (game.isHorseOnCell(horseLine, horseColumn)))
            return true;
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 K 0 0 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 0 0 0 X 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        horseLine = line - 2;
        horseColumn = column + 1;
        if (game.isOpponentPieceOnCell(horseLine, horseColumn) && (game.isHorseOnCell(horseLine, horseColumn)))
            return true;
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 K 0 0 0 0
         * 2 | 0 0 0 0 0 X 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        horseLine = line - 1;
        horseColumn = column + 2;
        if (game.isOpponentPieceOnCell(horseLine, horseColumn) && (game.isHorseOnCell(horseLine, horseColumn)))
            return true;

        return false;
    }
}
