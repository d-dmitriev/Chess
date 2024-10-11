package home.work.game.piece;

import home.work.game.piece.classic.King;
import org.junit.jupiter.api.Test;

import static home.work.game.Colors.BOTTOM_PLAYER_COLOR;
import static org.junit.jupiter.api.Assertions.*;


public class TestKing {
    private final King king = new King(BOTTOM_PLAYER_COLOR);

    @Test
    void allowedMove() {
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 K X 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertTrue(king.canMoveToPosition(1, 1, 1, 2));
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | X K 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertTrue(king.canMoveToPosition(1, 1, 1, 0));
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 X 0 0 0 0 0 0
         * 1 | 0 K 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertTrue(king.canMoveToPosition(1, 1, 2, 1));
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 K 0 0 0 0 0 0
         * 0 | 0 X 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertTrue(king.canMoveToPosition(1, 1, 0, 1));
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 X 0 0 0 0 0
         * 1 | 0 K 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertTrue(king.canMoveToPosition(1, 1, 2, 2));
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | X 0 0 0 0 0 0 0
         * 1 | 0 K 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertTrue(king.canMoveToPosition(1, 1, 2, 0));
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 K 0 0 0 0 0 0
         * 0 | 0 0 X 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertTrue(king.canMoveToPosition(1, 1, 0, 2));
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 K 0 0 0 0 0 0
         * 0 | X 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertTrue(king.canMoveToPosition(1, 1, 0, 0));
    }
    @Test
    void notAllowedMove() {
        Utils.notMovingLikeHorse(king);
        Utils.notMovingLikeQueen(king);
    }
}
