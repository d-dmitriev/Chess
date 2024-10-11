package home.work.game.builder.base.rules;

import home.work.game.piece.ChessPiece;

public interface RulesClient {
    boolean isEmptyCell(int line, int column);

    boolean isCurrentPlayerPieceOnCell(int line, int column);

    boolean isOpponentPieceOnCell(int line, int column);

    ChessPiece getPieceOnCell(int line, int column);

    void setPieceOnCell(ChessPiece piece, int line, int column);

    int getCurrentPlayerKingLine();
}
