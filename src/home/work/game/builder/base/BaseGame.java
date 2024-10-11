package home.work.game.builder.base;

import home.work.game.builder.base.rules.AbstractRules;
import home.work.game.builder.base.rules.CellPosition;
import home.work.game.client.GameClient;
import home.work.game.piece.ChessPiece;
import home.work.game.records.CastlingResult;
import home.work.game.builder.base.rules.ClassicGameRules;
import home.work.game.builder.base.rules.RulesClient;

import static home.work.game.Colors.BOTTOM_PLAYER_COLOR;
import static home.work.game.Colors.TOP_PLAYER_COLOR;
import static home.work.game.builder.base.GameConstants.*;

public abstract class BaseGame implements GameClient, RulesClient {
    private static final int SIZE = 8;
    private ChessPiece[][] board;
    private final AbstractRules rules;
    private String nowPlayer;
    private final String initPlayer;

    public BaseGame(String player) {
        this.rules = new ClassicGameRules(this);
        this.board = new ChessPiece[SIZE][SIZE];
        this.nowPlayer = player;
        this.initPlayer = player;
    }

    @Override
    public final boolean isEmptyCell(int line, int column) {
        return getPieceOnCell(line, column) == null;
    }

    @Override
    public final boolean isCurrentPlayerPieceOnCell(int line, int column) {
        ChessPiece piece = this.getPieceOnCell(line, column);
        return piece != null && piece.hasColor(this.nowPlayerColor());
    }

    @Override
    public final boolean isOpponentPieceOnCell(int line, int column) {
        ChessPiece piece = this.getPieceOnCell(line, column);
        return piece != null && piece.hasColor(this.getOpponentColor());
    }

    @Override
    public final ChessPiece getPieceOnCell(int line, int column) {
        return this.board[line][column];
    }

    // Определение линии короля в зависимости от текущего игрока
    @Override
    public final int getCurrentPlayerKingLine() {
        return this.nowPlayerColor().equals(BOTTOM_PLAYER_COLOR) ? BOTTOM_PLAYER_KING_LINE : TOP_PLAYER_KING_LINE;
    }

    @Override
    public final void setPieceOnCell(ChessPiece piece, int line, int column) {
        this.board[line][column] = piece;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void startGame() {
        buildBoard();
        printHelp();
        printBoard();
    }

    @Override
    public void restartGame() {
        System.out.println("Заново");
        replay();
        buildBoard();
        printBoard();
    }

    @Override
    public void runCommand(String s) {
        this.processCommand(s);
    }

    @Override
    public CellPosition[] getPossibleMovesFromCell(int line, int column) {
        if (this.isCurrentPlayerPieceOnCell(line, column)) return this.getPossibleMoves(line, column);
//        return this.isCurrentPlayerPieceOnCell(line, column) && (!this.isCurrentPlayerKingUnderAttack() || this.isKingOnCell(line, column)) && this.hasPossibleMoves(line, column);
        return new CellPosition[0];
    }

    @Override
    public boolean isGameOver() {
        return this.getRules().isGameOver();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public abstract void buildBoard();

    public abstract void printHelp();

    public abstract void printBoard();

    public abstract void processCommand(String s);

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    protected final String nowPlayerColor() {
        return this.nowPlayer;
    }

    protected final void replay() {
        this.board = new ChessPiece[SIZE][SIZE];
        this.nowPlayer = initPlayer;
    }

    protected final boolean castling0() {
        // Перемещение короля в сторону дальней Ладьи
        final CastlingResult result = this.getRules().longCastling();
        if (result.success()) {
            this.movePieceToPosition(result.kingPosition().line(), result.kingPosition().from(), result.kingPosition().line(), result.kingPosition().to()); // Перемещение Короля
            this.movePieceToPosition(result.rookPosition().line(), result.rookPosition().from(), result.rookPosition().line(), result.rookPosition().to());
            this.playerChange(); // next turn

            return true;
        }
        return false;
    }

    protected final boolean castling7() {
        // Перемещение короля в сторону ближней Ладьи
        final CastlingResult result = this.getRules().shortCastling();
        if (result.success()) {
            this.movePieceToPosition(result.kingPosition().line(), result.kingPosition().from(), result.kingPosition().line(), result.kingPosition().to()); // Перемещение Короля
            this.movePieceToPosition(result.rookPosition().line(), result.rookPosition().from(), result.rookPosition().line(), result.rookPosition().to());
            this.playerChange(); // next turn

            return true;
        }
        return false;
    }

    protected final boolean moveToPosition(int startLine, int startColumn, int endLine, int endColumn) {
        if (this.checkPos(startLine) && this.checkPos(startColumn)) {
            if (this.getRules().canMovePieceToPosition(startLine, startColumn, endLine, endColumn)) {
                this.movePieceToPosition(startLine, startColumn, endLine, endColumn);
                this.playerChange();

                return true;
            }
        }
        return false;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private boolean checkPos(int pos) {
        return pos >= 0 && pos < SIZE;
    }

    private AbstractRules getRules() {
        return rules;
    }

    private void playerChange() {
        this.nowPlayer = this.getOpponentColor();
    }

    private String getOpponentColor() {
        return this.nowPlayerColor().equals(BOTTOM_PLAYER_COLOR) ? TOP_PLAYER_COLOR : BOTTOM_PLAYER_COLOR;
    }

    private void movePieceToPosition(int fromLine, int fromColumn, int toLine, int toColumn) {
        ChessPiece piece = getPieceOnCell(fromLine, fromColumn);
//        if (rules.isPawnOnCell(fromLine, fromColumn) && ((nowPlayerColor().equals(BOTTOM_PLAYER_COLOR) && toLine == TOP_PLAYER_KING_LINE) || (nowPlayerColor().equals(TOP_PLAYER_COLOR) && toLine == BOTTOM_PLAYER_KING_LINE))) {
//            piece = new Queen(nowPlayerColor());
//        }
        this.setPieceOnCell(piece, toLine, toColumn);
        piece.uncheck();
        this.setPieceOnCell(null, fromLine, fromColumn);
    }

    private CellPosition[] getPossibleMoves(int startLine, int startColumn) {
        return getRules().getPossibleMoves(startLine, startColumn);
    }

    private boolean isCurrentPlayerKingUnderAttack() {
        return this.getRules().isCurrentPlayerKingUnderAttack();
    }

    private boolean isKingOnCell(int line, int column) {
        return this.getRules().isKingOnCell(line, column);
    }
}
