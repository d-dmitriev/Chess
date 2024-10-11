import home.work.board.ChessBoard;
import home.work.piece.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static home.work.game.Constants.BOTTOM_PLAYER_COLOR;
import static home.work.game.Constants.TOP_PLAYER_COLOR;
import static org.junit.jupiter.api.Assertions.*;


public class TestKing {
    private static final ChessBoard boardEmpty = new ChessBoard(BOTTOM_PLAYER_COLOR);
    private static final ChessBoard boardNotEmpty = new ChessBoard(BOTTOM_PLAYER_COLOR);
    private static final ChessBoard boardKings = new ChessBoard(BOTTOM_PLAYER_COLOR);
    private final King king = new King(BOTTOM_PLAYER_COLOR);
    @BeforeAll
    static void init() {
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 R 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 Q
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 0 0 0 0 B 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 P 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        boardNotEmpty.board[2][6] = new Bishop(TOP_PLAYER_COLOR);
        boardNotEmpty.board[6][3] = new Rook(TOP_PLAYER_COLOR);
        boardNotEmpty.board[4][7] = new Queen(TOP_PLAYER_COLOR);
        boardNotEmpty.board[0][5] = new Queen(BOTTOM_PLAYER_COLOR);

        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 K 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 0 0 0 K 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
//        boardKings.board[5][2] = new King(TOP_PLAYER_COLOR);
        boardKings.board[5][4] = new King(TOP_PLAYER_COLOR);
//        boardKings.board[5][6] = new King(TOP_PLAYER_COLOR);
//        boardKings.board[3][2] = new King(TOP_PLAYER_COLOR);
//        boardKings.board[3][6] = new King(TOP_PLAYER_COLOR);
//        boardKings.board[1][2] = new King(TOP_PLAYER_COLOR);
        boardKings.board[1][4] = new King(TOP_PLAYER_COLOR);
//        boardKings.board[1][6] = new King(TOP_PLAYER_COLOR);
    }
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
        assertTrue(king.canMoveToPosition(boardEmpty, 1, 1, 1, 2));
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
        assertTrue(king.canMoveToPosition(boardEmpty, 1, 1, 1, 0));
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
        assertTrue(king.canMoveToPosition(boardEmpty, 1, 1, 2, 1));
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
        assertTrue(king.canMoveToPosition(boardEmpty, 1, 1, 0, 1));
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
        assertTrue(king.canMoveToPosition(boardEmpty, 1, 1, 2, 2));
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
        assertTrue(king.canMoveToPosition(boardEmpty, 1, 1, 2, 0));
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
        assertTrue(king.canMoveToPosition(boardEmpty, 1, 1, 0, 2));
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
        assertTrue(king.canMoveToPosition(boardEmpty, 1, 1, 0, 0));
    }
    @Test
    void notAllowedMove() {
        Utils.notMovingLikeHorse(boardEmpty, king);
        Utils.notMovingLikeQueen(boardEmpty, king);
    }
    @Test
    void notAllowMoveUnderAttack() {
        /*
         * Нельзя ходить Королем на клетку под атакой (атака - Слон)
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 R 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 Q
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 0 0 0 0 B 0
         * 1 | 0 0 0 0 0 X 0 0
         * 0 | 0 0 0 0 K P 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(king.canMoveToPosition(boardNotEmpty, 0, 4, 1, 5));
        /*
         * Нельзя ходить Королем на клетку под атакой (атака - Ферзь)
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 R 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 Q
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 0 0 0 0 B 0
         * 1 | 0 0 0 0 X 0 0 0
         * 0 | 0 0 0 0 K P 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(king.canMoveToPosition(boardNotEmpty, 0, 4, 1, 4));
        /*
         * Нельзя ходить Королем на клетку под атакой (атака - Ладья)
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 R 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 Q
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 0 0 0 0 B 0
         * 1 | 0 0 0 X 0 0 0 0
         * 0 | 0 0 0 0 K P 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(king.canMoveToPosition(boardNotEmpty, 0, 4, 1, 3));
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 k 0 0 0
         * 4 | 0 0 0 X 0 0 0 0
         * 3 | 0 0 0 0 K 0 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 0 0 0 k 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(king.canMoveToPosition(boardKings, 3, 4, 4, 3));
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 k 0 0 0
         * 4 | 0 0 0 0 X 0 0 0
         * 3 | 0 0 0 0 K 0 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 0 0 0 k 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(king.canMoveToPosition(boardKings, 3, 4, 4, 4));
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 k 0 0 0
         * 4 | 0 0 0 0 0 X 0 0
         * 3 | 0 0 0 0 K 0 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 0 0 0 k 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(king.canMoveToPosition(boardKings, 3, 4, 4, 5));
//        assertFalse(king.canMoveToPosition(boardKings, 3, 4, 3, 3));
//        assertFalse(king.canMoveToPosition(boardKings, 3, 4, 3, 5));
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 k 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 K 0 0 0
         * 2 | 0 0 0 X 0 0 0 0
         * 1 | 0 0 0 0 k 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(king.canMoveToPosition(boardKings, 3, 4, 2, 3));
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 k 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 K 0 0 0
         * 2 | 0 0 0 0 X 0 0 0
         * 1 | 0 0 0 0 k 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(king.canMoveToPosition(boardKings, 3, 4, 2, 4));
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 k 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 K 0 0 0
         * 2 | 0 0 0 0 0 X 0 0
         * 1 | 0 0 0 0 k 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(king.canMoveToPosition(boardKings, 3, 4, 2, 5));
    }
    @Test
    void canEat() {
        /* Может есть чужую фигуру если клетка не под боем
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 R 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 Q
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 0 0 0 0 B 0
         * 1 | 0 0 0 0 0 0 K 0
         * 0 | 0 0 0 0 0 P 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertTrue(king.canMoveToPosition(boardNotEmpty, 1, 6, 2, 6));
    }
    @Test
    void canNotEat() {
        /* Не может есть свою фигуру
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 R 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 Q
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 0 0 0 0 B 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 P K 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(king.canMoveToPosition(boardNotEmpty, 0, 6, 0, 5));
    }
}
