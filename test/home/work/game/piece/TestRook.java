package home.work.game.piece;

import home.work.game.piece.classic.Rook;
import org.junit.jupiter.api.Test;

import static home.work.game.Colors.BOTTOM_PLAYER_COLOR;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestRook {
    private final Rook rookWhite = new Rook(BOTTOM_PLAYER_COLOR);
    @Test
    void allowedMove() {
        //
        assertTrue(rookWhite.canMoveToPosition(2, 2, 2, 4)); // "-"
        assertTrue(rookWhite.canMoveToPosition(2, 2, 2, 0)); // "-"
        //
        assertTrue(rookWhite.canMoveToPosition(2, 2, 4, 2)); // "|"
        assertTrue(rookWhite.canMoveToPosition(2, 2, 0, 2)); // "|"
    }
    @Test
    void notAllowedMove() {
        Utils.notMovingLikeHorse(rookWhite);
        Utils.notMovingLikeBishop(rookWhite);
        /*
         * 7 | 0 0 X 0 0 0 0 0
         * 6 | 0 0 P 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 R 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
//        assertFalse(rookWhite.canMoveToPosition(2, 2, 7, 2));
    }
}
