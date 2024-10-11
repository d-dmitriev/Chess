import home.work.board.ChessBoard;
import home.work.piece.Horse;
import home.work.piece.Pawn;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static home.work.game.Constants.BOTTOM_PLAYER_COLOR;
import static home.work.game.Constants.TOP_PLAYER_COLOR;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestHorse {
    private static final ChessBoard boardWhite = new ChessBoard(BOTTOM_PLAYER_COLOR);
    private static final ChessBoard boardBlack = new ChessBoard(TOP_PLAYER_COLOR);
    private final Horse horseWhite = new Horse(BOTTOM_PLAYER_COLOR);
    private final Horse horseBlack = new Horse(BOTTOM_PLAYER_COLOR);
    @BeforeAll
    static void init() {
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 P 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        boardWhite.board[0][1] = new Pawn(TOP_PLAYER_COLOR);
        boardBlack.board[0][1] = new Pawn(TOP_PLAYER_COLOR);
    }
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
        assertTrue(horseWhite.canMoveToPosition(boardWhite, 2, 2, 3, 4));
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
        assertTrue(horseWhite.canMoveToPosition(boardWhite, 2, 2, 3, 0));
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
        assertTrue(horseWhite.canMoveToPosition(boardWhite, 2, 2, 4, 3));
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
        assertTrue(horseWhite.canMoveToPosition(boardWhite, 2, 2, 4, 1));
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
        assertTrue(horseWhite.canMoveToPosition(boardWhite, 2, 2, 1, 4));
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
        assertTrue(horseWhite.canMoveToPosition(boardWhite, 2, 2, 1, 0));
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
        assertTrue(horseWhite.canMoveToPosition(boardWhite, 2, 2, 0, 3));
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
        assertTrue(horseWhite.canMoveToPosition(boardWhite, 2, 2, 0, 1));
    }
    @Test
    void notAllowedMove() {
        Utils.notMovingLikeQueen(boardWhite, horseWhite);
    }
    @Test
    void canEat() {
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 H 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 P 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertTrue(horseWhite.canMoveToPosition(boardWhite, 2, 2, 0, 1)); // "|-"
    }
    @Test
    void canNotEat() {
        /*
         * Нельзя бить свою фигуру
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 H 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 P 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(horseBlack.canMoveToPosition(boardBlack, 2, 2, 0, 1)); // "|-"
    }
}
