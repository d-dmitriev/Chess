package home.work.game.piece;

import home.work.game.piece.classic.Pawn;
import org.junit.jupiter.api.Test;

import static home.work.game.Colors.BOTTOM_PLAYER_COLOR;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPawn {
    private final Pawn pawnWhite = new Pawn(BOTTOM_PLAYER_COLOR);

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
        assertTrue(pawnWhite.canMoveToPosition(1, 1, 3, 1));
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
        assertTrue(pawnWhite.canMoveToPosition(6, 1, 4, 1));
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
        assertTrue(pawnWhite.canMoveToPosition(1, 1, 2, 1));
    }
    @Test
    void notAllowedMove() {
        Utils.notMovingLikeHorse(pawnWhite);
//        Utils.notMovingLikeQueen(pawnWhite);
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
//        assertFalse(pawnWhite.canMoveToPosition(2, 1, 4, 1));
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
//        assertFalse(pawnWhite.canMoveToPosition(5, 1, 3, 1));
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
        assertFalse(pawnWhite.canMoveToPosition(2, 1, 3, 2));
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
        assertFalse(pawnWhite.canMoveToPosition(2, 1, 3, 0));
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
//        assertFalse(pawnWhite.canMoveToPosition(2, 1, 1, 1));
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
//        assertFalse(pawnWhite.canMoveToPosition(5, 1, 6, 1));
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 P 0 K 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 P 0 P 0 0
         * 2 | 0 0 0 0 0 0 0 P
         * 1 | 0 0 0 0 0 0 0 P
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
//        assertFalse(pawnWhite.canMoveToPosition(1, 7, 3, 7));
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 P
         * 5 | 0 0 0 0 0 0 0 P
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 P 0 P 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
//        assertFalse(pawnWhite.canMoveToPosition(6, 7, 4, 7));
    }
}
