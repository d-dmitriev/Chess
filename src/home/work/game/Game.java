package home.work.game;

import home.work.piece.ChessPiece;

import static home.work.game.Constants.*;

public interface Game {
    boolean isOpponentOrEmpty(int line, int column);
    boolean isCurrentPlayerPieceOnCell(int line, int column);
    boolean isOpponentPieceOnCell(int line, int column);
    boolean isEmptyCell(int line, int column);
    boolean checkPos(int pos);
    boolean isLineBetweenCellEmpty(int fromLine, int fromColumn, int toLine, int toColumn);
    ChessPiece getPieceOnCell(int line, int column);
    boolean isPieceOnCellMoved(int line, int column);
    String nowPlayerColor();
    void movePieceToPosition(int fromLine, int fromColumn, int toLine, int toColumn);

    boolean isKingOnCell(int line, int column);
    boolean isRookOnCell(int line, int column);
    boolean isQueenOnCell(int line, int column);
    boolean isBishopOnCell(int line, int column);

    boolean isNotUnderAttack(int line, int column);
}
