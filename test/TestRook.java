import home.work.board.ChessBoard;
import home.work.piece.Pawn;
import home.work.piece.Rook;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static home.work.game.Constants.BOTTOM_PLAYER_COLOR;
import static home.work.game.Constants.TOP_PLAYER_COLOR;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestRook {
    private static final ChessBoard boardWhite = new ChessBoard(BOTTOM_PLAYER_COLOR);
    private static final ChessBoard boardBlack = new ChessBoard(TOP_PLAYER_COLOR);
    private final Rook rookWhite = new Rook(BOTTOM_PLAYER_COLOR);
    private final Rook rookBlack = new Rook(TOP_PLAYER_COLOR);
    @BeforeAll
    static void init() {
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 P 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        boardWhite.board[6][2] = new Pawn(TOP_PLAYER_COLOR);
        boardBlack.board[6][2] = new Pawn(TOP_PLAYER_COLOR);
    }
    @Test
    void allowedMove() {
        //
        assertTrue(rookWhite.canMoveToPosition(boardWhite, 2, 2, 2, 4)); // "-"
        assertTrue(rookWhite.canMoveToPosition(boardWhite, 2, 2, 2, 0)); // "-"
        //
        assertTrue(rookWhite.canMoveToPosition(boardWhite, 2, 2, 4, 2)); // "|"
        assertTrue(rookWhite.canMoveToPosition(boardWhite, 2, 2, 0, 2)); // "|"
    }
    @Test
    void notAllowedMove() {
        Utils.notMovingLikeHorse(boardWhite, rookWhite);
        Utils.notMovingLikeBishop(boardWhite, rookWhite);
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
        assertFalse(rookWhite.canMoveToPosition(boardWhite, 2, 2, 7, 2));
    }

    @Test
    void canEat() {
        /*
         * 7 | 0 0 0 0 0 0 0 0
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
        assertTrue(rookWhite.canMoveToPosition(boardWhite, 2, 2, 6, 2));
    }

    @Test
    void canNotEat() {
        /*
         * 7 | 0 0 0 0 0 0 0 0
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
        assertFalse(rookBlack.canMoveToPosition(boardBlack, 2, 2, 6, 2));
    }
}
