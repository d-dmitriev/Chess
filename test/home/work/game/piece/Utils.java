package home.work.game.piece;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class Utils {
    static void notMovingLikeHorse(ChessPiece piece) {
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 X 0 0 0
         * 2 | 0 0 H 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(piece.canMoveToPosition(2, 2, 3, 4));
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | X 0 0 0 0 0 0 0
         * 2 | 0 0 H 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(piece.canMoveToPosition(2, 2, 3, 0));
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 X 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 H 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(piece.canMoveToPosition(2, 2, 4, 3));
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 X 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 H 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(piece.canMoveToPosition(2, 2, 4, 1));
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 H 0 0 0 0 0
         * 1 | 0 0 0 0 X 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(piece.canMoveToPosition(2, 2, 1, 4));
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 H 0 0 0 0 0
         * 1 | X 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(piece.canMoveToPosition(2, 2, 1, 0));
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 H 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 X 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(piece.canMoveToPosition(2, 2, 0, 3));
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
        assertFalse(piece.canMoveToPosition(2, 2, 0, 1));
    }
    static void notMovingLikeQueen(ChessPiece piece) {
        notMovingLikeRook(piece);
        notMovingLikeBishop(piece);
    }
    static void notMovingLikeRook(ChessPiece piece) {
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 R 0 X 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(piece.canMoveToPosition(2, 2, 2, 4));
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | X 0 R 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(piece.canMoveToPosition(2, 2, 2, 0));
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 X 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 R 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(piece.canMoveToPosition(2, 2, 4, 2));
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 R 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 X 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(piece.canMoveToPosition(2, 2, 0, 2));
    }
    static void notMovingLikeBishop(ChessPiece piece) {
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 X 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 B 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(piece.canMoveToPosition(2, 2, 4, 4));
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | X 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 B 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(piece.canMoveToPosition(2, 2, 4, 0));
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 B 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 X 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(piece.canMoveToPosition(2, 2, 0, 4));
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 B 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | X 0 0 0 0 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertFalse(piece.canMoveToPosition(2, 2, 0, 0));
    }
}
