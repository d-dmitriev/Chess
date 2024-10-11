import home.work.board.ChessBoard;
import home.work.game.Castling;
import home.work.piece.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static home.work.game.Constants.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCastling {
    private static final ChessBoard boardEmpty = new ChessBoard(BOTTOM_PLAYER_COLOR);
    private static final ChessBoard boardFull = new ChessBoard(BOTTOM_PLAYER_COLOR);
    private static final ChessBoard boardWhite = new ChessBoard(BOTTOM_PLAYER_COLOR);
    private static final ChessBoard boardBlack = new ChessBoard(TOP_PLAYER_COLOR);
    private static final ChessBoard boardAttack = new ChessBoard(BOTTOM_PLAYER_COLOR);
    private static final Castling castlingEmpty = new Castling(boardEmpty);
    private static final Castling castlingFull = new Castling(boardFull);
    private static final Castling castlingWhite = new Castling(boardWhite);
    private static final Castling castlingBlack = new Castling(boardBlack);
    private static final Castling castlingAttack = new Castling(boardAttack);
    @BeforeEach
    void init() {
        boardWhite.board[BOTTOM_PLAYER_KING_LINE][LEFT_ROOK_INIT_POSITION] = new Rook(BOTTOM_PLAYER_COLOR);
        boardWhite.board[BOTTOM_PLAYER_KING_LINE][RIGHT_ROOK_INIT_POSITION] = new Rook(BOTTOM_PLAYER_COLOR);
        boardWhite.board[BOTTOM_PLAYER_KING_LINE][KING_INIT_POSITION] = new King(BOTTOM_PLAYER_COLOR);
        boardBlack.board[TOP_PLAYER_KING_LINE][LEFT_ROOK_INIT_POSITION] = new Rook(TOP_PLAYER_COLOR);
        boardBlack.board[TOP_PLAYER_KING_LINE][RIGHT_ROOK_INIT_POSITION] = new Rook(TOP_PLAYER_COLOR);
        boardBlack.board[TOP_PLAYER_KING_LINE][KING_INIT_POSITION] = new King(TOP_PLAYER_COLOR);

        boardFull.board[BOTTOM_PLAYER_KING_LINE][LEFT_ROOK_INIT_POSITION] = new Rook(BOTTOM_PLAYER_COLOR);
        boardFull.board[BOTTOM_PLAYER_KING_LINE][LEFT_HORSE_INIT_POSITION] = new Horse(BOTTOM_PLAYER_COLOR);
        boardFull.board[BOTTOM_PLAYER_KING_LINE][LEFT_BISHOP_INIT_POSITION] = new Bishop(BOTTOM_PLAYER_COLOR);
        boardFull.board[BOTTOM_PLAYER_KING_LINE][QUEEN_INIT_POSITION] = new Queen(BOTTOM_PLAYER_COLOR);
        boardFull.board[BOTTOM_PLAYER_KING_LINE][KING_INIT_POSITION] = new Queen(BOTTOM_PLAYER_COLOR);
        boardFull.board[BOTTOM_PLAYER_KING_LINE][RIGHT_BISHOP_INIT_POSITION] = new Bishop(BOTTOM_PLAYER_COLOR);
        boardFull.board[BOTTOM_PLAYER_KING_LINE][RIGHT_HORSE_INIT_POSITION] = new Horse(BOTTOM_PLAYER_COLOR);
        boardFull.board[BOTTOM_PLAYER_KING_LINE][RIGHT_ROOK_INIT_POSITION] = new Rook(BOTTOM_PLAYER_COLOR);

        boardAttack.board[BOTTOM_PLAYER_KING_LINE][LEFT_ROOK_INIT_POSITION] = new Rook(BOTTOM_PLAYER_COLOR);
        boardAttack.board[BOTTOM_PLAYER_KING_LINE][KING_INIT_POSITION] = new King(BOTTOM_PLAYER_COLOR);
        boardAttack.board[2][4] = new Bishop(TOP_PLAYER_COLOR);
    }
    @Test
    void testCastling0White() {
        final int KING_POSITION_NEW = KING_INIT_POSITION - 2;
        final int ROOK_POSITION_NEW = KING_INIT_POSITION - 1;
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | R 0 0 0 K 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertTrue(castlingWhite.run(BOTTOM_PLAYER_KING_LINE, KING_INIT_POSITION, LEFT_ROOK_INIT_POSITION, KING_POSITION_NEW, ROOK_POSITION_NEW));
    }
    @Test
    void testCastling0Black() {
        final int KING_POSITION_NEW = KING_INIT_POSITION - 2;
        final int ROOK_POSITION_NEW = KING_INIT_POSITION - 1;
        /*
         * 7 | R 0 0 0 K 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertTrue(castlingBlack.run(TOP_PLAYER_KING_LINE, KING_INIT_POSITION, LEFT_ROOK_INIT_POSITION, KING_POSITION_NEW, ROOK_POSITION_NEW));
    }
    @Test
    void testCastling7White() {
        final int KING_POSITION_NEW = KING_INIT_POSITION + 2;
        final int ROOK_POSITION_NEW = KING_INIT_POSITION + 1;
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 K 0 0 R
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertTrue(castlingWhite.run(BOTTOM_PLAYER_KING_LINE, KING_INIT_POSITION, RIGHT_ROOK_INIT_POSITION, KING_POSITION_NEW, ROOK_POSITION_NEW));
    }
    @Test
    void testCastling7Black() {
        final int KING_POSITION_NEW = KING_INIT_POSITION + 2;
        final int ROOK_POSITION_NEW = KING_INIT_POSITION + 1;
        /*
         * 7 | 0 0 0 0 K 0 0 R
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertTrue(castlingBlack.run(TOP_PLAYER_KING_LINE, KING_INIT_POSITION, RIGHT_ROOK_INIT_POSITION, KING_POSITION_NEW, ROOK_POSITION_NEW));
    }
    @Test
    void testEmptyBoard0() {
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(castlingEmpty.run(TOP_PLAYER_KING_LINE, KING_INIT_POSITION, RIGHT_ROOK_INIT_POSITION, KING_INIT_POSITION - 2, KING_INIT_POSITION - 1));
    }
    @Test
    void testEmptyBoard7() {
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(castlingEmpty.run(TOP_PLAYER_KING_LINE, KING_INIT_POSITION, RIGHT_ROOK_INIT_POSITION, KING_INIT_POSITION + 2, KING_INIT_POSITION + 1));
    }
    @Test
    void testFullBoard0() {
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | R H B Q K B H R
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(castlingFull.run(TOP_PLAYER_KING_LINE, KING_INIT_POSITION, RIGHT_ROOK_INIT_POSITION, KING_INIT_POSITION - 2, KING_INIT_POSITION - 1));
    }
    @Test
    void testFullBoard7() {
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | R H B Q K B H R
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(castlingFull.run(TOP_PLAYER_KING_LINE, KING_INIT_POSITION, RIGHT_ROOK_INIT_POSITION, KING_INIT_POSITION + 2, KING_INIT_POSITION + 1));
    }
    @Test
    void testUnderAttack() {
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 0 0 B 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | R 0 0 0 K 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(castlingAttack.run(BOTTOM_PLAYER_KING_LINE, KING_INIT_POSITION, LEFT_ROOK_INIT_POSITION, KING_INIT_POSITION - 2, KING_INIT_POSITION - 1));
    }
}
