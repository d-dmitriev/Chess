import home.work.board.ChessBoard;
import home.work.piece.Bishop;
import home.work.piece.Pawn;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static home.work.game.Constants.BOTTOM_PLAYER_COLOR;
import static home.work.game.Constants.TOP_PLAYER_COLOR;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBishop {
    private static final ChessBoard boardWhite = new ChessBoard(BOTTOM_PLAYER_COLOR);
    private static final ChessBoard boardBlack = new ChessBoard(TOP_PLAYER_COLOR);
    private final Bishop bishopWhite = new Bishop(BOTTOM_PLAYER_COLOR);
    private final Bishop bishopBlack = new Bishop(BOTTOM_PLAYER_COLOR);
    @BeforeAll
    static void init() {
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 P 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        boardWhite.board[6][6] = new Pawn(BOTTOM_PLAYER_COLOR);
        boardBlack.board[6][6] = new Pawn(BOTTOM_PLAYER_COLOR);
    }
    @Test
    void allowedMove() {
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 P 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 X 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 B 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertTrue(bishopWhite.canMoveToPosition(boardWhite, 2, 2, 4, 4));
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 P 0
         * 5 | 0 0 0 0 0 X 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 B 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertTrue(bishopWhite.canMoveToPosition(boardWhite, 2, 2, 5, 5));
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 P 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | X 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 B 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertTrue(bishopWhite.canMoveToPosition(boardWhite, 2, 2, 4, 0));
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 P 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 B 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 X 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertTrue(bishopWhite.canMoveToPosition(boardWhite, 2, 2, 0, 4));
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 P 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 B 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | X 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertTrue(bishopWhite.canMoveToPosition(boardWhite, 2, 2, 0, 0));
    }
    @Test
    void notAllowedMove() {
        Utils.notMovingLikeHorse(boardWhite, bishopWhite);
        Utils.notMovingLikeRook(boardWhite, bishopWhite);
        /* Нельзя ходить через фигуры
         * 7 | 0 0 0 0 0 0 0 X
         * 6 | 0 0 0 0 0 0 P 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 B 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(bishopWhite.canMoveToPosition(boardWhite, 2, 2, 7, 7));
        /* Нельзя ходить на занятую своей фигурой клетку
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 P 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 B 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(bishopWhite.canMoveToPosition(boardWhite, 2, 2, 6, 6));
    }
    @Test
    void canEat() {
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 P 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 B 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertTrue(bishopBlack.canMoveToPosition(boardBlack, 7, 7, 6, 6));
    }
    @Test
    void canNotEat() {
        /* Нельзя бить свою фигуру
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 P 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 B 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(bishopWhite.canMoveToPosition(boardWhite, 5, 5, 6, 6));
    }
}
