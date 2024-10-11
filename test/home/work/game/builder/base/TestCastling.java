package home.work.game.builder.base;

import home.work.game.builder.ClassicGame;
import home.work.game.builder.base.rules.AbstractRules;
import home.work.game.piece.classic.*;
import home.work.game.records.CastlingPosition;
import home.work.game.records.CastlingResult;
import home.work.game.builder.base.rules.ClassicGameRules;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static home.work.game.Colors.BOTTOM_PLAYER_COLOR;
import static home.work.game.Colors.TOP_PLAYER_COLOR;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCastling {
    private static final ClassicGame gameWhite = new ClassicGame(BOTTOM_PLAYER_COLOR);
    private static final ClassicGame gameBlack = new ClassicGame(TOP_PLAYER_COLOR);
    private static final ClassicGame gameFull = new ClassicGame(BOTTOM_PLAYER_COLOR);
    private static final ClassicGame gameAttack = new ClassicGame(BOTTOM_PLAYER_COLOR);
    private static final AbstractRules rulesWhite = new ClassicGameRules(gameWhite);
    private static final AbstractRules rulesBlack = new ClassicGameRules(gameBlack);
    private static final AbstractRules rulesEmptyBoard = new ClassicGameRules(new ClassicGame(BOTTOM_PLAYER_COLOR));
    private static final AbstractRules rulesFull = new ClassicGameRules(gameFull);
    private static final AbstractRules rulesAttack = new ClassicGameRules(gameAttack);
    @BeforeEach
    void init() {
        gameWhite.setPieceOnCell(new Rook(BOTTOM_PLAYER_COLOR), 0, 0);
        gameWhite.setPieceOnCell(new Rook(BOTTOM_PLAYER_COLOR), 0, 7);
        gameWhite.setPieceOnCell(new King(BOTTOM_PLAYER_COLOR), 0, 4);

        gameBlack.setPieceOnCell(new Rook(TOP_PLAYER_COLOR), 7, 0);
        gameBlack.setPieceOnCell(new Rook(TOP_PLAYER_COLOR), 7, 7);
        gameBlack.setPieceOnCell(new King(TOP_PLAYER_COLOR), 7, 4);

        gameFull.setPieceOnCell(new Rook(BOTTOM_PLAYER_COLOR), 0, 0);
        gameFull.setPieceOnCell(new Horse(BOTTOM_PLAYER_COLOR), 0, 1);
        gameFull.setPieceOnCell(new Bishop(BOTTOM_PLAYER_COLOR), 0, 2);
        gameFull.setPieceOnCell(new Queen(BOTTOM_PLAYER_COLOR), 0, 3);
        gameFull.setPieceOnCell(new King(BOTTOM_PLAYER_COLOR), 0, 4);
        gameFull.setPieceOnCell(new Bishop(BOTTOM_PLAYER_COLOR), 0, 5);
        gameFull.setPieceOnCell(new Horse(BOTTOM_PLAYER_COLOR), 0, 6);
        gameFull.setPieceOnCell(new Rook(BOTTOM_PLAYER_COLOR), 0, 7);

        gameAttack.setPieceOnCell(new Rook(BOTTOM_PLAYER_COLOR), 0, 0);
        gameAttack.setPieceOnCell(new Rook(BOTTOM_PLAYER_COLOR), 0, 7);
        gameAttack.setPieceOnCell(new King(BOTTOM_PLAYER_COLOR), 0, 4);
        gameAttack.setPieceOnCell(new Bishop(TOP_PLAYER_COLOR), 2, 4);
    }
    @Test
    void testCastling0White() {
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | R 0 0 0 K 0 0 0
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertEquals(rulesWhite.longCastling(), new CastlingResult(true, new CastlingPosition(0, 4, 2), new CastlingPosition(0, 0, 3)));
    }
    @Test
    void testCastling0Black() {
        /*
         * 7 | R 0 0 0 K 0 0 0
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
        assertEquals(rulesBlack.longCastling(), new CastlingResult(true, new CastlingPosition(7, 4, 2), new CastlingPosition(7, 0, 3)));
    }
    @Test
    void testCastling7White() {
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | 0 0 0 0 K 0 0 R
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertEquals(rulesWhite.shortCastling(), new CastlingResult(true, new CastlingPosition(0, 4, 6), new CastlingPosition(0, 7, 5)));
    }
    @Test
    void testCastling7Black() {
        /*
         * 7 | 0 0 0 0 K 0 0 R
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
        assertEquals(rulesBlack.shortCastling(), new CastlingResult(true, new CastlingPosition(7, 4, 6), new CastlingPosition(7, 7, 5)));
    }
    @Test
    void testEmptyBoard0() {
        /*
         * 7 | 0 0 0 0 0 0 0 0
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
        assertEquals(rulesEmptyBoard.longCastling(), new CastlingResult(false, null, null));
    }
    @Test
    void testEmptyBoard7() {
        /*
         * 7 | 0 0 0 0 0 0 0 0
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
        assertEquals(rulesEmptyBoard.shortCastling(), new CastlingResult(false, null, null));
    }
    @Test
    void testFullBoard0() {
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | R H B Q K B H R
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertEquals(rulesFull.longCastling(), new CastlingResult(false, null, null));
    }
    @Test
    void testFullBoard7() {
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 0 0 0 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | R H B Q K B H R
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertEquals(rulesFull.shortCastling(), new CastlingResult(false, null, null));
    }
    @Test
    void testUnderAttack0() {
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 0 0 B 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | R 0 0 0 K 0 0 R
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertEquals(rulesAttack.longCastling(), new CastlingResult(false, null, null));
    }
    @Test
    void testUnderAttack7() {
        /*
         * 7 | 0 0 0 0 0 0 0 0
         * 6 | 0 0 0 0 0 0 0 0
         * 5 | 0 0 0 0 0 0 0 0
         * 4 | 0 0 0 0 0 0 0 0
         * 3 | 0 0 0 0 0 0 0 0
         * 2 | 0 0 0 0 B 0 0 0
         * 1 | 0 0 0 0 0 0 0 0
         * 0 | R 0 0 0 K 0 0 R
         *   - - - - - - - - -
         *     0 1 2 3 4 5 6 7
         */
        assertEquals(rulesAttack.shortCastling(), new CastlingResult(false, null, null));
    }
}
