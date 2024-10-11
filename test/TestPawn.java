import home.work.board.ChessBoard;
import home.work.piece.King;
import home.work.piece.Pawn;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static home.work.game.Constants.BOTTOM_PLAYER_COLOR;
import static home.work.game.Constants.TOP_PLAYER_COLOR;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPawn {
    private static final ChessBoard boardWhite = new ChessBoard(BOTTOM_PLAYER_COLOR);
    private static final ChessBoard boardBlack = new ChessBoard(TOP_PLAYER_COLOR);
    private final Pawn pawnWhite = new Pawn(BOTTOM_PLAYER_COLOR);
    private final Pawn pawnBlack = new Pawn(TOP_PLAYER_COLOR);
    @BeforeAll
    static void init() {
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 P 0 K 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 P 0 P 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        boardWhite.board[5][3] = new Pawn(BOTTOM_PLAYER_COLOR);
        boardWhite.board[5][5] = new King(TOP_PLAYER_COLOR);
        boardWhite.board[3][3] = new Pawn(TOP_PLAYER_COLOR);
        boardWhite.board[3][5] = new Pawn(TOP_PLAYER_COLOR);
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 P 0 P 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        boardBlack.board[3][3] = new Pawn(TOP_PLAYER_COLOR);
        boardBlack.board[3][5] = new Pawn(TOP_PLAYER_COLOR);
    }
    @Test
    void allowedMove() {
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 P 0 K 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 X 0 P 0 P 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 P 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertTrue(pawnWhite.canMoveToPosition(boardWhite, 1, 1, 3, 1));
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 P 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 X 0 0 0 0 0 0
         * 3 | 0 0 0 P 0 P 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertTrue(pawnBlack.canMoveToPosition(boardBlack, 6, 1, 4, 1));
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 P 0 K 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 P 0 P 0 0
         * 2 | 0 X 0 0 0 0 0 0
         * 1 | 0 P 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertTrue(pawnWhite.canMoveToPosition(boardWhite, 1, 1, 2, 1));
    }
    @Test
    void notAllowedMove() {
        Utils.notMovingLikeHorse(boardWhite, pawnWhite);
        Utils.notMovingLikeQueen(boardWhite, pawnWhite);
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 P 0 K 0 0
         * 4 | 0 X 0 0 0 0 0 0
         * 3 | 0 0 0 P 0 P 0 0
         * 2 | 0 P 0 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(pawnWhite.canMoveToPosition(boardWhite, 2, 1, 4, 1));
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 P 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 X 0 P 0 P 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(pawnBlack.canMoveToPosition(boardBlack, 5, 1, 3, 1));
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 P 0 K 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 X P 0 P 0 0
         * 2 | 0 P 0 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(pawnWhite.canMoveToPosition(boardWhite, 2, 1, 3, 2));
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 P 0 K 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | X 0 0 P 0 P 0 0
         * 2 | 0 P 0 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(pawnWhite.canMoveToPosition(boardWhite, 2, 1, 3, 0));
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 P 0 K 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 P 0 P 0 0
         * 2 | 0 P 0 0 0 0 0 0
         * 1 | 0 X 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(pawnWhite.canMoveToPosition(boardWhite, 2, 1, 1, 1));
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 X 0 0 0 0 0 0
         * 5 | 0 P 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 P 0 P 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(pawnBlack.canMoveToPosition(boardBlack, 5, 1, 6, 1));
    }
    @Test
    void canEat() {
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 P 0 K 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 P 0 X 0 0
         * 2 | 0 0 0 0 P 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertTrue(pawnWhite.canMoveToPosition(boardWhite, 2, 4, 3, 5));
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 P 0 K 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 X 0 P 0 0
         * 2 | 0 0 0 0 P 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertTrue(pawnWhite.canMoveToPosition(boardWhite, 2, 4, 3, 3));
    }
    @Test
    void canNotEat() {
        /*
         * Не может есть свою Пешку (Чёрные)
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 P 0 0 0
         * 3 | 0 0 0 P 0 P 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(pawnBlack.canMoveToPosition(boardBlack, 4, 4, 3, 5));
        /*
         * Не может есть свою Пешку (Чёрные)
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 P 0 0 0
         * 3 | 0 0 0 P 0 P 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(pawnBlack.canMoveToPosition(boardBlack, 4, 4, 3, 3));
        /*
         * Не может есть Короля
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 P 0 K 0 0
         * 4 | 0 0 0 0 P 0 0 0
         * 3 | 0 0 0 P 0 P 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(pawnWhite.canMoveToPosition(boardWhite, 4, 4, 5, 5));
        /*
         * Не может есть свою Пешку (Белые)
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 P 0 K 0 0
         * 4 | 0 0 0 0 P 0 0 0
         * 3 | 0 0 0 P 0 P 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(pawnWhite.canMoveToPosition(boardWhite, 4, 4, 5, 3));
    }
}
