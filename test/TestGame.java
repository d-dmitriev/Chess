import home.work.board.ChessBoard;
import home.work.piece.Pawn;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static home.work.game.Constants.BOTTOM_PLAYER_COLOR;
import static home.work.game.Constants.TOP_PLAYER_COLOR;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestGame {
    private static final ChessBoard boardWhite = new ChessBoard(BOTTOM_PLAYER_COLOR);
    private static final ChessBoard boardBlack = new ChessBoard(TOP_PLAYER_COLOR);
    @BeforeAll
    static void init() {
        boardBlack.board[7][1] = new Pawn(TOP_PLAYER_COLOR);
        boardBlack.board[7][6] = new Pawn(TOP_PLAYER_COLOR);
        boardBlack.board[3][3] = new Pawn(TOP_PLAYER_COLOR);
    }
    @Test
    void testSpace0077() {
        /*
         * 7 | 0 0 0 0 0 0 0 7
         * 6 | 0 0 0 0 0 0 6 0
         * 5 | 0 0 0 0 0 5 0 0
         * 4 | 0 0 0 0 4 0 0 0
         * 3 | 0 0 0 3 0 0 0 0
         * 2 | 0 0 2 0 0 0 0 0
         * 1 | 0 1 0 0 0 0 0 0
         * 0 | X 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertTrue(boardWhite.isLineBetweenCellEmpty(0, 0, 1, 1));
        assertTrue(boardWhite.isLineBetweenCellEmpty(0, 0, 2, 2));
        assertTrue(boardWhite.isLineBetweenCellEmpty(0, 0, 3, 3));
        assertTrue(boardWhite.isLineBetweenCellEmpty(0, 0, 4, 4));
        assertTrue(boardWhite.isLineBetweenCellEmpty(0, 0, 5, 5));
        assertTrue(boardWhite.isLineBetweenCellEmpty(0, 0, 6, 6));
        assertTrue(boardWhite.isLineBetweenCellEmpty(0, 0, 7, 7));
    }
    @Test
    void testSpace7007() {
        /*
         * 7 | X 0 0 0 0 0 0 0
         * 6 | 0 1 0 0 0 0 0 0
         * 5 | 0 0 2 0 0 0 0 0
         * 4 | 0 0 0 3 0 0 0 0
         * 3 | 0 0 0 0 4 0 0 0
         * 2 | 0 0 0 0 0 5 0 0
         * 1 | 0 0 0 0 0 0 6 0
         * 0 | 0 0 0 0 0 0 0 7
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertTrue(boardWhite.isLineBetweenCellEmpty(7, 0, 6, 1));
        assertTrue(boardWhite.isLineBetweenCellEmpty(7, 0, 5, 2));
        assertTrue(boardWhite.isLineBetweenCellEmpty(7, 0, 4, 3));
        assertTrue(boardWhite.isLineBetweenCellEmpty(7, 0, 3, 4));
        assertTrue(boardWhite.isLineBetweenCellEmpty(7, 0, 2, 5));
        assertTrue(boardWhite.isLineBetweenCellEmpty(7, 0, 1, 6));
        assertTrue(boardWhite.isLineBetweenCellEmpty(7, 0, 0, 7));
    }
    @Test
    void testSpace0770() {
        /*
         * 7 | 7 0 0 0 0 0 0 0
         * 6 | 0 6 0 0 0 0 0 0
         * 5 | 0 0 5 0 0 0 0 0
         * 4 | 0 0 0 4 0 0 0 0
         * 3 | 0 0 0 0 3 0 0 0
         * 2 | 0 0 0 0 0 2 0 0
         * 1 | 0 0 0 0 0 0 1 0
         * 0 | 0 0 0 0 0 0 0 X
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertTrue(boardWhite.isLineBetweenCellEmpty(0, 7, 1, 6));
        assertTrue(boardWhite.isLineBetweenCellEmpty(0, 7, 2, 5));
        assertTrue(boardWhite.isLineBetweenCellEmpty(0, 7, 3, 4));
        assertTrue(boardWhite.isLineBetweenCellEmpty(0, 7, 4, 3));
        assertTrue(boardWhite.isLineBetweenCellEmpty(0, 7, 5, 2));
        assertTrue(boardWhite.isLineBetweenCellEmpty(0, 7, 6, 1));
        assertTrue(boardWhite.isLineBetweenCellEmpty(0, 7, 7, 0));
    }
    @Test
    void testSpace7700() {
        /*
         * 7 | 0 0 0 0 0 0 0 X
         * 6 | 0 0 0 0 0 0 1 0
         * 5 | 0 0 0 0 0 2 0 0
         * 4 | 0 0 0 0 3 0 0 0
         * 3 | 0 0 0 4 0 0 0 0
         * 2 | 0 0 5 0 0 0 0 0
         * 1 | 0 6 0 0 0 0 0 0
         * 0 | 7 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertTrue(boardWhite.isLineBetweenCellEmpty(7, 7, 6, 6));
        assertTrue(boardWhite.isLineBetweenCellEmpty(7, 7, 5, 5));
        assertTrue(boardWhite.isLineBetweenCellEmpty(7, 7, 4, 4));
        assertTrue(boardWhite.isLineBetweenCellEmpty(7, 7, 3, 3));
        assertTrue(boardWhite.isLineBetweenCellEmpty(7, 7, 2, 2));
        assertTrue(boardWhite.isLineBetweenCellEmpty(7, 7, 1, 1));
        assertTrue(boardWhite.isLineBetweenCellEmpty(7, 7, 0, 0));
    }
    @Test
    void testSpace0007() {
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | X 1 2 3 4 5 6 7
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertTrue(boardWhite.isLineBetweenCellEmpty(0, 0, 0, 1));
        assertTrue(boardWhite.isLineBetweenCellEmpty(0, 0, 0, 2));
        assertTrue(boardWhite.isLineBetweenCellEmpty(0, 0, 0, 3));
        assertTrue(boardWhite.isLineBetweenCellEmpty(0, 0, 0, 4));
        assertTrue(boardWhite.isLineBetweenCellEmpty(0, 0, 0, 5));
        assertTrue(boardWhite.isLineBetweenCellEmpty(0, 0, 0, 6));
        assertTrue(boardWhite.isLineBetweenCellEmpty(0, 0, 0, 7));
    }
    @Test
    void testSpace0070() {
        /*
         * 7 | 7 0 0 0 0 0 0 0
         * 6 | 6 0 0 0 0 0 0 0
         * 5 | 5 0 0 0 0 0 0 0
         * 4 | 4 0 0 0 0 0 0 0
         * 3 | 3 0 0 0 0 0 0 0
         * 2 | 2 0 0 0 0 0 0 0
         * 1 | 1 0 0 0 0 0 0 0
         * 0 | X 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertTrue(boardWhite.isLineBetweenCellEmpty(0, 0, 1, 0));
        assertTrue(boardWhite.isLineBetweenCellEmpty(0, 0, 2, 0));
        assertTrue(boardWhite.isLineBetweenCellEmpty(0, 0, 3, 0));
        assertTrue(boardWhite.isLineBetweenCellEmpty(0, 0, 4, 0));
        assertTrue(boardWhite.isLineBetweenCellEmpty(0, 0, 5, 0));
        assertTrue(boardWhite.isLineBetweenCellEmpty(0, 0, 6, 0));
        assertTrue(boardWhite.isLineBetweenCellEmpty(0, 0, 7, 0));
    }
    @Test
    void testSpace7077() {
        /*
         * 7 | X 1 2 3 4 5 6 7
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
        assertTrue(boardWhite.isLineBetweenCellEmpty(7, 0, 7, 1));
        assertTrue(boardWhite.isLineBetweenCellEmpty(7, 0, 7, 2));
        assertTrue(boardWhite.isLineBetweenCellEmpty(7, 0, 7, 3));
        assertTrue(boardWhite.isLineBetweenCellEmpty(7, 0, 7, 4));
        assertTrue(boardWhite.isLineBetweenCellEmpty(7, 0, 7, 5));
        assertTrue(boardWhite.isLineBetweenCellEmpty(7, 0, 7, 6));
        assertTrue(boardWhite.isLineBetweenCellEmpty(7, 0, 7, 7));
    }
    @Test
    void testSpace7000() {
        /*
         * 7 | X 0 0 0 0 0 0 0
         * 6 | 1 0 0 0 0 0 0 0
         * 5 | 2 0 0 0 0 0 0 0
         * 4 | 3 0 0 0 0 0 0 0
         * 3 | 4 0 0 0 0 0 0 0
         * 2 | 5 0 0 0 0 0 0 0
         * 1 | 6 0 0 0 0 0 0 0
         * 0 | 7 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertTrue(boardWhite.isLineBetweenCellEmpty(7, 0, 6, 0));
        assertTrue(boardWhite.isLineBetweenCellEmpty(7, 0, 5, 0));
        assertTrue(boardWhite.isLineBetweenCellEmpty(7, 0, 4, 0));
        assertTrue(boardWhite.isLineBetweenCellEmpty(7, 0, 3, 0));
        assertTrue(boardWhite.isLineBetweenCellEmpty(7, 0, 2, 0));
        assertTrue(boardWhite.isLineBetweenCellEmpty(7, 0, 1, 0));
        assertTrue(boardWhite.isLineBetweenCellEmpty(7, 0, 0, 0));
    }
    @Test
    void testSpace0700() {
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 7 6 5 4 3 2 1 X
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertTrue(boardWhite.isLineBetweenCellEmpty(0, 7, 0, 6));
        assertTrue(boardWhite.isLineBetweenCellEmpty(0, 7, 0, 5));
        assertTrue(boardWhite.isLineBetweenCellEmpty(0, 7, 0, 4));
        assertTrue(boardWhite.isLineBetweenCellEmpty(0, 7, 0, 3));
        assertTrue(boardWhite.isLineBetweenCellEmpty(0, 7, 0, 2));
        assertTrue(boardWhite.isLineBetweenCellEmpty(0, 7, 0, 1));
        assertTrue(boardWhite.isLineBetweenCellEmpty(0, 7, 0, 0));
    }
    @Test
    void testSpace0777() {
        /*
         * 7 | 0 0 0 0 0 0 0 7
         * 6 | 0 0 0 0 0 0 0 6
         * 5 | 0 0 0 0 0 0 0 5
         * 4 | 0 0 0 0 0 0 0 4
         * 3 | 0 0 0 0 0 0 0 3
         * 2 | 0 0 0 0 0 0 0 2
         * 1 | 0 0 0 0 0 0 0 1
         * 0 | 0 0 0 0 0 0 0 X
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertTrue(boardWhite.isLineBetweenCellEmpty(0, 7, 1, 7));
        assertTrue(boardWhite.isLineBetweenCellEmpty(0, 7, 2, 7));
        assertTrue(boardWhite.isLineBetweenCellEmpty(0, 7, 3, 7));
        assertTrue(boardWhite.isLineBetweenCellEmpty(0, 7, 4, 7));
        assertTrue(boardWhite.isLineBetweenCellEmpty(0, 7, 5, 7));
        assertTrue(boardWhite.isLineBetweenCellEmpty(0, 7, 6, 7));
        assertTrue(boardWhite.isLineBetweenCellEmpty(0, 7, 7, 7));
    }
    @Test
    void testSpace7770() {
        /*
         * 7 | 7 6 5 4 3 2 1 X
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
        assertTrue(boardWhite.isLineBetweenCellEmpty(7, 7, 7, 6));
        assertTrue(boardWhite.isLineBetweenCellEmpty(7, 7, 7, 5));
        assertTrue(boardWhite.isLineBetweenCellEmpty(7, 7, 7, 4));
        assertTrue(boardWhite.isLineBetweenCellEmpty(7, 7, 7, 3));
        assertTrue(boardWhite.isLineBetweenCellEmpty(7, 7, 7, 2));
        assertTrue(boardWhite.isLineBetweenCellEmpty(7, 7, 7, 1));
        assertTrue(boardWhite.isLineBetweenCellEmpty(7, 7, 7, 0));
    }
    @Test
    void testSpace7707() {
        /*
         * 7 | 0 0 0 0 0 0 0 X
         * 6 | 0 0 0 0 0 0 0 1
         * 5 | 0 0 0 0 0 0 0 2
         * 4 | 0 0 0 0 0 0 0 3
         * 3 | 0 0 0 0 0 0 0 4
         * 2 | 0 0 0 0 0 0 0 5
         * 1 | 0 0 0 0 0 0 0 6
         * 0 | 0 0 0 0 0 0 0 7
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertTrue(boardWhite.isLineBetweenCellEmpty(7, 7, 7, 7));
        assertTrue(boardWhite.isLineBetweenCellEmpty(7, 7, 6, 7));
        assertTrue(boardWhite.isLineBetweenCellEmpty(7, 7, 5, 7));
        assertTrue(boardWhite.isLineBetweenCellEmpty(7, 7, 4, 7));
        assertTrue(boardWhite.isLineBetweenCellEmpty(7, 7, 3, 7));
        assertTrue(boardWhite.isLineBetweenCellEmpty(7, 7, 2, 7));
        assertTrue(boardWhite.isLineBetweenCellEmpty(7, 7, 1, 7));
        assertTrue(boardWhite.isLineBetweenCellEmpty(7, 7, 0, 7));
    }
    @Test
    void testSpace0407() {
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 X 0 0 1
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertTrue(boardWhite.isLineBetweenCellEmpty(0, 4, 0, 7));
    }
    @Test
    void testSpace0400() {
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 1 0 0 0 X 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertTrue(boardWhite.isLineBetweenCellEmpty(0, 4, 0, 0));
    }
    @Test
    void testSpace7477Fail() {
        /*
         * 7 | 0 P 0 0 X 0 P 1
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
        assertFalse(boardBlack.isLineBetweenCellEmpty(7, 4, 7, 7));
    }
    @Test
    void testSpace7470Fail() {
        /*
         * 7 | 1 P 0 0 X 0 P 0
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
        assertFalse(boardBlack.isLineBetweenCellEmpty(7, 4, 7, 0));
    }
    @Test
    void testSpace0077Fail() {
        /*
         * 7 | 0 0 0 0 0 0 0 1
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 P 0 0 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | X 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(boardBlack.isLineBetweenCellEmpty(0, 0, 7, 7));
    }
    @Test
    void testSpace2244Fail() {
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 1 0 0 0
         * 3 | 0 0 0 P 0 0 0 0
         * 2 | 0 0 X 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(boardBlack.isLineBetweenCellEmpty(2, 2, 4, 4));
    }
    @Test
    void testSpace3037Fail() {
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | X 0 0 P 0 0 0 1
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(boardBlack.isLineBetweenCellEmpty(3, 0, 3, 7));
    }
    @Test
    void testSpace0373Fail() {
        /*
         * 7 | 0 0 0 1 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 P 0 0 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 X 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(boardBlack.isLineBetweenCellEmpty(0, 3, 7, 3));
    }
}
