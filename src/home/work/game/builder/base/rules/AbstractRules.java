package home.work.game.builder.base.rules;

import home.work.game.records.CastlingResult;

public abstract class AbstractRules {
    RulesClient game;

    public AbstractRules(RulesClient game) {
        this.game = game;
    }

    public abstract CastlingResult longCastling();

    public abstract CastlingResult shortCastling();

    public abstract boolean canMovePieceToPosition(int startLine, int startColumn, int endLine, int endColumn);

    public abstract CellPosition[] getPossibleMoves(int startLine, int startColumn);

    public abstract boolean isCurrentPlayerKingUnderAttack();

    public abstract boolean isKingOnCell(int line, int column);

    public abstract boolean isGameOver();
}
