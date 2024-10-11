package home.work.game.piece;

import home.work.game.piece.classic.Horse;
import org.junit.jupiter.api.Test;

import static home.work.game.Colors.BOTTOM_PLAYER_COLOR;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestHorse {
    private final Horse horseWhite = new Horse(BOTTOM_PLAYER_COLOR);
    @Test
    void allowedMove() {
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 X 0 0 0
         * 2 | 0 0 H 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 P 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertTrue(horseWhite.canMoveToPosition(2, 2, 3, 4));
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | X 0 0 0 0 0 0 0
         * 2 | 0 0 H 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 P 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertTrue(horseWhite.canMoveToPosition(2, 2, 3, 0));
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 X 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 H 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 P 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertTrue(horseWhite.canMoveToPosition(2, 2, 4, 3));
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 X 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 H 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 P 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertTrue(horseWhite.canMoveToPosition(2, 2, 4, 1));
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 H 0 0 0 0 0
         * 1 | 0 0 0 0 X 0 0 0
         * 0 | 0 P 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertTrue(horseWhite.canMoveToPosition(2, 2, 1, 4));
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 H 0 0 0 0 0
         * 1 | X 0 0 0 0 0 0 0
         * 0 | 0 P 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertTrue(horseWhite.canMoveToPosition(2, 2, 1, 0));
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 H 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 P 0 X 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertTrue(horseWhite.canMoveToPosition(2, 2, 0, 3));
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 H 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 X 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertTrue(horseWhite.canMoveToPosition(2, 2, 0, 1));
    }
    @Test
    void notAllowedMove() {
        Utils.notMovingLikeQueen(horseWhite);
    }
}
