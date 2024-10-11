package home.work.game.builder.base.rules;

import home.work.game.piece.ChessPiece;
import home.work.game.piece.base.*;
import home.work.game.records.CastlingPosition;
import home.work.game.records.CastlingResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static home.work.game.builder.base.GameConstants.*;

public class ClassicGameRules extends AbstractRules {

    public ClassicGameRules(RulesClient game) {
        super(game);
    }

    @Override
    public CastlingResult longCastling() {
        // Перемещение короля в сторону дальней Ладьи
        final int LINE = game.getCurrentPlayerKingLine();
        final int KING_POSITION_NEW = KING_INIT_POSITION - 2;
        final int ROOK_POSITION_NEW = KING_INIT_POSITION - 1;
        if (this.castling(LINE, KING_INIT_POSITION, LEFT_ROOK_INIT_POSITION, KING_POSITION_NEW, ROOK_POSITION_NEW)) {
            return new CastlingResult(true, new CastlingPosition(LINE, KING_INIT_POSITION, KING_POSITION_NEW), new CastlingPosition(LINE, LEFT_ROOK_INIT_POSITION, ROOK_POSITION_NEW));
        }
        return new CastlingResult(false, null, null);
    }

    @Override
    public CastlingResult shortCastling() {
        // Перемещение короля в сторону ближней Ладьи
        final int LINE = game.getCurrentPlayerKingLine();
        final int KING_POSITION_NEW = KING_INIT_POSITION + 2;
        final int ROOK_POSITION_NEW = KING_INIT_POSITION + 1;
        if (this.castling(LINE, KING_INIT_POSITION, RIGHT_ROOK_INIT_POSITION, KING_POSITION_NEW, ROOK_POSITION_NEW)) {
            return new CastlingResult(true, new CastlingPosition(LINE, KING_INIT_POSITION, KING_POSITION_NEW), new CastlingPosition(LINE, RIGHT_ROOK_INIT_POSITION, ROOK_POSITION_NEW));
        }
        return new CastlingResult(false, null, null);
    }

    public boolean canMovePieceToPosition(int startLine, int startColumn, CellPosition pos) {
        return canMovePieceToPosition(startLine, startColumn, pos.line(), pos.column());
    }

    @Override
    public boolean canMovePieceToPosition(int startLine, int startColumn, int endLine, int endColumn) {
        if (!game.isCurrentPlayerPieceOnCell(startLine, startColumn)) return false;
        ChessPiece piece = game.getPieceOnCell(startLine, startColumn);
        if (!(piece instanceof BaseHorse) && this.isLineBetweenCellNotEmpty(startLine, startColumn, endLine, endColumn))
            return false; // Перепрыгивать через другие фигуры запрещено
        if (this.isKingOnCell(endLine, endColumn)) return false; //Не едим Короля
        if (!game.isEmptyCell(endLine, endColumn) && !game.isOpponentPieceOnCell(endLine, endColumn))
            return false;
        if (piece instanceof BasePawn && !game.isEmptyCell(endLine, endColumn) && piece.canMoveToPosition(startLine, startColumn, endLine, endColumn))
            return false;
        if (piece instanceof BasePawn && piece.canSpecialMoveToPosition(startLine, startColumn, endLine, endColumn) && game.isOpponentPieceOnCell(endLine, endColumn))
            return true;
        if (piece instanceof BaseKing && this.isUnderAttack(endLine, endColumn)) return false;
        return piece.canMoveToPosition(startLine, startColumn, endLine, endColumn);
    }

    @Override
    public CellPosition[] getPossibleMoves(int startLine, int startColumn) {
        List<CellPosition> list = new ArrayList<>();

        for (RookDirection dir : RookDirection.values()) {
            for (CellPosition pos : this.getPossibleRookMovies(startLine, startColumn, dir)) {
                if (this.canMovePieceToPosition(startLine, startColumn, pos)) list.add(pos);
            }
        }

        for (BishopDirection dir : BishopDirection.values()) {
            for (CellPosition pos : this.getPossibleBishopMoves(startLine, startColumn, dir)) {
                if (this.canMovePieceToPosition(startLine, startColumn, pos)) list.add(pos);
            }
        }

        for (CellPosition pos : this.getPossibleHorseMoves(startLine, startColumn)) {
            if (this.canMovePieceToPosition(startLine, startColumn, pos)) list.add(pos);
        }

        if (startLine == game.getCurrentPlayerKingLine() && startColumn == KING_INIT_POSITION) {
            if (castling(startLine, startColumn, LEFT_ROOK_INIT_POSITION, KING_INIT_POSITION - 2, KING_INIT_POSITION - 1))
                list.add(new CellPosition(startLine, 0));
            if (castling(startLine, startColumn, RIGHT_ROOK_INIT_POSITION, KING_INIT_POSITION + 2, KING_INIT_POSITION + 1))
                list.add(new CellPosition(startLine, 7));
        }

        return list.toArray(new CellPosition[0]);
    }

    @Override
    public boolean isCurrentPlayerKingUnderAttack() {
        for (int start = game.getCurrentPlayerKingLine(), line = start; Math.abs(start - line) <= 7; line += start == 0 ? 1 : -1) {
            for (int column = 4; this.checkPos(line, column); column++) {
                if (!isKingOnCell(line, column)) continue;
                return game.isCurrentPlayerPieceOnCell(line, column) && isUnderAttack(line, column);
            }
            for (int column = 3; this.checkPos(line, column); column--) {
                if (!isKingOnCell(line, column)) continue;
                return isUnderAttack(line, column);
            }
        }
        return false;
    }

    @Override
    public boolean isKingOnCell(int line, int column) {
        ChessPiece piece = game.getPieceOnCell(line, column);
        return piece instanceof BaseKing;
    }

    @Override
    public boolean isGameOver() {
        for (int start = game.getCurrentPlayerKingLine(), line = start; Math.abs(start - line) <= 7; line += start == 0 ? 1 : -1) {
            for (int column = 4; this.checkPos(line, column); column++) {
                if (!isKingOnCell(line, column)) continue;
                return isUnderAttack(line, column) && getPossibleMoves(line, column).length == 0;
            }
            for (int column = 3; this.checkPos(line, column); column--) {
                if (!isKingOnCell(line, column)) continue;
                return isUnderAttack(line, column) && getPossibleMoves(line, column).length == 0;
            }
        }
        return false;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    protected boolean isLineBetweenCellNotEmpty(int fromLine, int fromColumn, int toLine, int toColumn) {
        for (int lineDiff = fromLine - toLine, columnDiff = fromColumn - toColumn; lineDiff != 0 || columnDiff != 0; lineDiff += Integer.compare(0, lineDiff), columnDiff += Integer.compare(0, columnDiff)) {
            int tmpLine = toLine + lineDiff, tmpColumn = toColumn + columnDiff;
            if (tmpLine == fromLine && tmpColumn == fromColumn) continue;
            if (!game.isEmptyCell(tmpLine, tmpColumn) && !this.isKingOnCell(tmpLine, tmpColumn)) return true;
        }
        return false;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private boolean isPawnOnCell(int line, int column) {
        ChessPiece piece = game.getPieceOnCell(line, column);
        return piece instanceof BasePawn;
    }

    private boolean isRookOnCell(int line, int column) {
        ChessPiece piece = game.getPieceOnCell(line, column);
        return piece instanceof BaseRook;
    }

    private boolean isQueenOnCell(int line, int column) {
        ChessPiece piece = game.getPieceOnCell(line, column);
        return piece instanceof BaseQueen;
    }

    private boolean isHorseOnCell(int line, int column) {
        ChessPiece piece = game.getPieceOnCell(line, column);
        return piece instanceof BaseHorse;
    }

    private boolean isBishopOnCell(int line, int column) {
        ChessPiece piece = game.getPieceOnCell(line, column);
        return piece instanceof BaseBishop;
    }

    private boolean isUnderAttack(int line, int column) {
        for (RookDirection dir : RookDirection.values()) {
            for (CellPosition pos : this.getPossibleRookMovies(line, column, dir)) {
                if (!game.isEmptyCell(pos.line(), pos.column()) &&
                        game.isCurrentPlayerPieceOnCell(pos.line(), pos.column()) &&
                        !this.isKingOnCell(pos.line(), pos.column())
                )
                    break;
                if (!this.isLineBetweenCellNotEmpty(line, column, pos.line(), pos.column()) &&
                        game.isOpponentPieceOnCell(pos.line(), pos.column()) &&
                        (this.isRookOnCell(pos.line(), pos.column()) ||
                                this.isQueenOnCell(pos.line(), pos.column()) ||
                                (Math.abs(line - pos.line() + column - pos.column()) == 1 &&
                                        this.isKingOnCell(pos.line(), pos.column())
                                )
                        )
                )
                    return true;
            }
        }
        for (BishopDirection dir : BishopDirection.values()) {
            for (CellPosition pos : this.getPossibleBishopMoves(line, column, dir)) {
                if (!game.isEmptyCell(pos.line(), pos.column()) &&
                        game.isCurrentPlayerPieceOnCell(pos.line(), pos.column()) &&
                        !this.isKingOnCell(pos.line(), pos.column())
                )
                    break;
                if (!this.isLineBetweenCellNotEmpty(line, column, pos.line(), pos.column()) &&
                        game.isOpponentPieceOnCell(pos.line(), pos.column()) &&
                        (this.isBishopOnCell(pos.line(), pos.column()) ||
                                this.isQueenOnCell(pos.line(), pos.column()) ||
                                (Math.abs(pos.line() - line) == 1 &&
                                        Math.abs(pos.column() - column) == 1 &&
                                        this.isKingOnCell(pos.line(), pos.column())
                                )
                        )
                )
                    return true;
            }
        }
        for (CellPosition pos : getPossibleHorseMoves(line, column)) {
            if (this.checkPos(pos) &&
                    game.isOpponentPieceOnCell(pos.line(), pos.column()) &&
                    this.isHorseOnCell(pos.line(), pos.column())
            )
                return true;
        }

        return false;
    }

    private CellPosition[] getPossibleRookMovies(int line, int column, RookDirection dir) {
        List<CellPosition> list = new ArrayList<>();
        /*
         * 7 | 0 0 0 X 0 0 0 0
         * 6 | 0 0 0 X 0 0 0 0
         * 5 | 0 0 0 X 0 0 0 0
         * 4 | 0 0 0 X 0 0 0 0
         * 3 | X X X R X X X X
         * 2 | 0 0 0 X 0 0 0 0
         * 1 | 0 0 0 X 0 0 0 0
         * 0 | 0 0 0 X 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        for (int endLine = line + dir.line, endColumn = column + dir.column; this.checkPos(endLine, endColumn); endLine += dir.line, endColumn += dir.column) {
            list.add(new CellPosition(endLine, endColumn));
        }
        return list.toArray(new CellPosition[0]);
    }

    private CellPosition[] getPossibleBishopMoves(int line, int column, BishopDirection dir) {
        List<CellPosition> list = new ArrayList<>();
        /*
         * 7 | 0 0 0 0 0 0 0 X
         * 6 | X 0 0 0 0 0 X 0
         * 5 | 0 X 0 0 0 X 0 0
         * 4 | 0 0 X 0 X 0 0 0
         * 3 | 0 0 0 B 0 0 0 0
         * 2 | 0 0 X 0 X 0 0 0
         * 1 | 0 X 0 0 0 X 0 0
         * 0 | X 0 0 0 0 0 X 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        for (int endLine = line + dir.line, endColumn = column + dir.column; this.checkPos(endLine, endColumn); endLine += dir.line, endColumn += dir.column) {
            list.add(new CellPosition(endLine, endColumn));
        }
        return list.toArray(new CellPosition[0]);
    }

    private CellPosition[] getPossibleHorseMoves(int line, int column) {
        return Arrays.stream(new CellPosition[]{
                /*
                 * 7 | 0 0 0 0 0 0 0 0
                 * 6 | 0 0 0 0 0 0 0 0
                 * 5 | 0 0 0 0 0 0 0 0
                 * 4 | 0 0 0 0 0 X 0 0
                 * 3 | 0 0 0 H 0 0 0 0
                 * 2 | 0 0 0 0 0 0 0 0
                 * 1 | 0 0 0 0 0 0 0 0
                 * 0 | 0 0 0 0 0 0 0 0
                 *   - - - - - - - - -
                 *     0 1 2 3 4 5 6 7
                 */
                new CellPosition(line + 1, column + 2),
                /*
                 * 7 | 0 0 0 0 0 0 0 0
                 * 6 | 0 0 0 0 0 0 0 0
                 * 5 | 0 0 0 0 0 0 0 0
                 * 4 | 0 X 0 0 0 0 0 0
                 * 3 | 0 0 0 H 0 0 0 0
                 * 2 | 0 0 0 0 0 0 0 0
                 * 1 | 0 0 0 0 0 0 0 0
                 * 0 | 0 0 0 0 0 0 0 0
                 *   - - - - - - - - -
                 *     0 1 2 3 4 5 6 7
                 */
                new CellPosition(line + 1, column - 2),
                /*
                 * 7 | 0 0 0 0 0 0 0 0
                 * 6 | 0 0 0 0 0 0 0 0
                 * 5 | 0 0 0 0 X 0 0 0
                 * 4 | 0 0 0 0 0 0 0 0
                 * 3 | 0 0 0 H 0 0 0 0
                 * 2 | 0 0 0 0 0 0 0 0
                 * 1 | 0 0 0 0 0 0 0 0
                 * 0 | 0 0 0 0 0 0 0 0
                 *   - - - - - - - - -
                 *     0 1 2 3 4 5 6 7
                 */
                new CellPosition(line + 2, column + 1),
                /*
                 * 7 | 0 0 0 0 0 0 0 0
                 * 6 | 0 0 0 0 0 0 0 0
                 * 5 | 0 0 X 0 0 0 0 0
                 * 4 | 0 0 0 0 0 0 0 0
                 * 3 | 0 0 0 H 0 0 0 0
                 * 2 | 0 0 0 0 0 0 0 0
                 * 1 | 0 0 0 0 0 0 0 0
                 * 0 | 0 0 0 0 0 0 0 0
                 *   - - - - - - - - -
                 *     0 1 2 3 4 5 6 7
                 */
                new CellPosition(line + 2, column - 1),
                /*
                 * 7 | 0 0 0 0 0 0 0 0
                 * 6 | 0 0 0 0 0 0 0 0
                 * 5 | 0 0 0 0 0 0 0 0
                 * 4 | 0 0 0 0 0 0 0 0
                 * 3 | 0 0 0 H 0 0 0 0
                 * 2 | 0 0 0 0 0 X 0 0
                 * 1 | 0 0 0 0 0 0 0 0
                 * 0 | 0 0 0 0 0 0 0 0
                 *   - - - - - - - - -
                 *     0 1 2 3 4 5 6 7
                 */
                new CellPosition(line - 1, column + 2),
                /*
                 * 7 | 0 0 0 0 0 0 0 0
                 * 6 | 0 0 0 0 0 0 0 0
                 * 5 | 0 0 0 0 0 0 0 0
                 * 4 | 0 0 0 0 0 0 0 0
                 * 3 | 0 0 0 H 0 0 0 0
                 * 2 | 0 X 0 0 0 0 0 0
                 * 1 | 0 0 0 0 0 0 0 0
                 * 0 | 0 0 0 0 0 0 0 0
                 *   - - - - - - - - -
                 *     0 1 2 3 4 5 6 7
                 */
                new CellPosition(line - 1, column - 2),
                /*
                 * 7 | 0 0 0 0 0 0 0 0
                 * 6 | 0 0 0 0 0 0 0 0
                 * 5 | 0 0 0 0 0 0 0 0
                 * 4 | 0 0 0 0 0 0 0 0
                 * 3 | 0 0 0 H 0 0 0 0
                 * 2 | 0 0 0 0 0 0 0 0
                 * 1 | 0 0 0 0 X 0 0 0
                 * 0 | 0 0 0 0 0 0 0 0
                 *   - - - - - - - - -
                 *     0 1 2 3 4 5 6 7
                 */
                new CellPosition(line - 2, column + 1),
                /*
                 * 7 | 0 0 0 0 0 0 0 0
                 * 6 | 0 0 0 0 0 0 0 0
                 * 5 | 0 0 0 0 0 0 0 0
                 * 4 | 0 0 0 0 0 0 0 0
                 * 3 | 0 0 0 H 0 0 0 0
                 * 2 | 0 0 0 0 0 0 0 0
                 * 1 | 0 0 X 0 0 0 0 0
                 * 0 | 0 0 0 0 0 0 0 0
                 *   - - - - - - - - -
                 *     0 1 2 3 4 5 6 7
                 */
                new CellPosition(line - 2, column - 1)
        }).filter(this::checkPos).toList().toArray(new CellPosition[0]);
    }

    private CellPosition[] getPossibleKingMovies() {
        return new CellPosition[]{
                /*
                 * 7 | 0 0 0 0 0 0 0 0
                 * 6 | 0 0 0 0 0 0 0 0
                 * 5 | 0 0 0 0 0 0 0 0
                 * 4 | 0 0 0 0 0 0 0 0
                 * 3 | 0 0 0 0 0 0 0 0
                 * 2 | 0 0 0 0 0 0 0 0
                 * 1 | 0 0 0 0 0 0 0 0
                 * 0 | 1 0 0 0 K 0 0 2
                 *   - - - - - - - - -
                 *     0 1 2 3 4 5 6 7
                 */
                new CellPosition(0, 0),
                new CellPosition(0, 7),
                /*
                 * 7 | 1 0 0 0 K 0 0 2
                 * 6 | 0 0 0 0 0 0 0 0
                 * 5 | 0 0 0 0 0 0 0 0
                 * 4 | 0 0 0 0 0 0 0 0
                 * 3 | 0 0 0 0 0 0 0 0
                 * 2 | 0 0 0 0 0 0 0 0
                 * 1 | 0 0 0 0 0 0 0 0
                 * 0 | 0 0 0 0 K 0 0 0
                 *   - - - - - - - - -
                 *     0 1 2 3 4 5 6 7
                 */
                new CellPosition(7, 0),
                new CellPosition(7, 7),
        };
    }

    private boolean checkPos(int line, int column) {
        return line >= BOTTOM_PLAYER_KING_LINE && line <= TOP_PLAYER_KING_LINE && column >= LEFT_ROOK_INIT_POSITION && column <= RIGHT_ROOK_INIT_POSITION;
    }

    private boolean checkPos(CellPosition pos) {
        return checkPos(pos.line(), pos.column());
    }

    private boolean castling(int line, int kingPosition, int rookPosition, int newKingPosition, int newRookPosition) {
        if (game.isEmptyCell(line, rookPosition) || game.isEmptyCell(line, kingPosition))
            return false; // Не выполнять если клетки пустые
        if (!game.isCurrentPlayerPieceOnCell(line, rookPosition) || !game.isCurrentPlayerPieceOnCell(line, kingPosition))
            return false; // Не выполнять если не свои фигуры
        if (!this.isRookOnCell(line, rookPosition) || !this.isKingOnCell(line, kingPosition))
            return false; // Не выполнять если не Король или не Ладья на клетках
        if (this.isLineBetweenCellNotEmpty(line, kingPosition, line, rookPosition))
            return false; // Не выполнять если есть фигуры между Королем и Ладьей
        if (game.getPieceOnCell(line, rookPosition).isNotMove() || game.getPieceOnCell(line, kingPosition).isNotMove())
            return false; // Не выполнять если Король или Ладья двигались
        // Проверка не под атакой ли клетка через которую Король проходит
        return !this.isUnderAttack(line, kingPosition) // Проверка не под атакой ли клетка Короля
                && !this.isUnderAttack(line, newKingPosition) // Проверка не под атакой ли клетка в которую идет Король
                && !this.isUnderAttack(line, newRookPosition);
    }
}
