package home.work.game.builder.base.rules;

import home.work.game.builder.ClassicGame;
import home.work.game.piece.classic.Pawn;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static home.work.game.Colors.BOTTOM_PLAYER_COLOR;
import static home.work.game.Colors.TOP_PLAYER_COLOR;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestGameRules {
    private static final ClassicGame game = new ClassicGame(TOP_PLAYER_COLOR);
    private static final ClassicGameRules boardWhite = new ClassicGameRules(new ClassicGame(BOTTOM_PLAYER_COLOR));
    private static final ClassicGameRules boardBlack = new ClassicGameRules(game);
    @BeforeAll
    static void init() {
        game.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 7, 1);
        game.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 7, 6);
        game.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 3, 3);
    }
    @Test
    void testSpace1333() {
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 3 0 0 0 0
         * 2 | 0 0 0 1 0 0 0 0
         * 1 | 0 0 0 P 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(1, 3, 2, 3));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(1, 3, 3, 3));
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
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(0, 0, 1, 1));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(0, 0, 2, 2));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(0, 0, 3, 3));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(0, 0, 4, 4));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(0, 0, 5, 5));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(0, 0, 6, 6));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(0, 0, 7, 7));
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
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(7, 0, 6, 1));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(7, 0, 5, 2));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(7, 0, 4, 3));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(7, 0, 3, 4));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(7, 0, 2, 5));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(7, 0, 1, 6));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(7, 0, 0, 7));
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
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(0, 7, 1, 6));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(0, 7, 2, 5));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(0, 7, 3, 4));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(0, 7, 4, 3));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(0, 7, 5, 2));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(0, 7, 6, 1));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(0, 7, 7, 0));
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
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(7, 7, 6, 6));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(7, 7, 5, 5));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(7, 7, 4, 4));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(7, 7, 3, 3));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(7, 7, 2, 2));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(7, 7, 1, 1));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(7, 7, 0, 0));
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
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(0, 0, 0, 1));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(0, 0, 0, 2));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(0, 0, 0, 3));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(0, 0, 0, 4));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(0, 0, 0, 5));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(0, 0, 0, 6));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(0, 0, 0, 7));
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
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(0, 0, 1, 0));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(0, 0, 2, 0));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(0, 0, 3, 0));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(0, 0, 4, 0));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(0, 0, 5, 0));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(0, 0, 6, 0));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(0, 0, 7, 0));
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
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(7, 0, 7, 1));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(7, 0, 7, 2));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(7, 0, 7, 3));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(7, 0, 7, 4));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(7, 0, 7, 5));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(7, 0, 7, 6));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(7, 0, 7, 7));
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
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(7, 0, 6, 0));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(7, 0, 5, 0));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(7, 0, 4, 0));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(7, 0, 3, 0));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(7, 0, 2, 0));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(7, 0, 1, 0));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(7, 0, 0, 0));
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
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(0, 7, 0, 6));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(0, 7, 0, 5));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(0, 7, 0, 4));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(0, 7, 0, 3));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(0, 7, 0, 2));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(0, 7, 0, 1));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(0, 7, 0, 0));
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
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(0, 7, 1, 7));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(0, 7, 2, 7));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(0, 7, 3, 7));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(0, 7, 4, 7));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(0, 7, 5, 7));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(0, 7, 6, 7));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(0, 7, 7, 7));
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
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(7, 7, 7, 6));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(7, 7, 7, 5));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(7, 7, 7, 4));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(7, 7, 7, 3));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(7, 7, 7, 2));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(7, 7, 7, 1));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(7, 7, 7, 0));
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
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(7, 7, 7, 7));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(7, 7, 6, 7));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(7, 7, 5, 7));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(7, 7, 4, 7));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(7, 7, 3, 7));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(7, 7, 2, 7));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(7, 7, 1, 7));
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(7, 7, 0, 7));
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
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(0, 4, 0, 7));
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
        assertFalse(boardWhite.isLineBetweenCellNotEmpty(0, 4, 0, 0));
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
        assertTrue(boardBlack.isLineBetweenCellNotEmpty(7, 4, 7, 7));
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
        assertTrue(boardBlack.isLineBetweenCellNotEmpty(7, 4, 7, 0));
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
        assertTrue(boardBlack.isLineBetweenCellNotEmpty(0, 0, 7, 7));
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
        assertTrue(boardBlack.isLineBetweenCellNotEmpty(2, 2, 4, 4));
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
        assertTrue(boardBlack.isLineBetweenCellNotEmpty(3, 0, 3, 7));
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
        assertTrue(boardBlack.isLineBetweenCellNotEmpty(0, 3, 7, 3));
    }
}
