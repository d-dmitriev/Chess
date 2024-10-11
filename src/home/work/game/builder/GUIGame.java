package home.work.game.builder;

import home.work.UI;
import home.work.game.builder.base.BaseGame;
import home.work.game.piece.alpha.*;
import home.work.ui.gui.ChessGUI;

import javax.swing.*;

import static home.work.game.Colors.BOTTOM_PLAYER_COLOR;
import static home.work.game.Colors.TOP_PLAYER_COLOR;

public class GUIGame extends BaseGame {
    UI userInterface = new ChessGUI(this);
    JFrame f;

    public GUIGame(String player) {
        super(player);
    }

    @Override
    public void buildBoard() {
//        mateTwoRooks();
//        mateQueenAndRook();
//        testKings1();
//        testKings();
//        castling7Attack();
//        castling0Attack();
//        test2();
//        cellBeforeKingUnderAttack();
        basePosition();
    }

    private void mateTwoRooks() {
        this.setPieceOnCell(new Rook(BOTTOM_PLAYER_COLOR), 1, 6);
        this.setPieceOnCell(new Rook(BOTTOM_PLAYER_COLOR), 0, 6);
        this.setPieceOnCell(new King(BOTTOM_PLAYER_COLOR), 0, 7);

        this.setPieceOnCell(new King(TOP_PLAYER_COLOR), 2, 4);
    }

    private void mateQueenAndRook() {
        this.setPieceOnCell(new Rook(BOTTOM_PLAYER_COLOR), 0, 5);
        this.setPieceOnCell(new Queen(BOTTOM_PLAYER_COLOR), 0, 6);
        this.setPieceOnCell(new King(BOTTOM_PLAYER_COLOR), 0, 7);

        this.setPieceOnCell(new King(TOP_PLAYER_COLOR), 4, 3);
    }

    private void testKings() {
        this.setPieceOnCell(new King(BOTTOM_PLAYER_COLOR), 2, 4);
        this.setPieceOnCell(new King(TOP_PLAYER_COLOR), 5, 4);
    }

    private void testKings1() {
        this.setPieceOnCell(new Rook(BOTTOM_PLAYER_COLOR), 0, 0);
        this.setPieceOnCell(new Horse(BOTTOM_PLAYER_COLOR), 0, 1);
        this.setPieceOnCell(new Bishop(BOTTOM_PLAYER_COLOR), 0, 2);
        this.setPieceOnCell(new Queen(BOTTOM_PLAYER_COLOR), 0, 3);
        this.setPieceOnCell(new King(BOTTOM_PLAYER_COLOR), 3, 3);
        this.setPieceOnCell(new Bishop(BOTTOM_PLAYER_COLOR), 0, 5);
        this.setPieceOnCell(new Horse(BOTTOM_PLAYER_COLOR), 0, 6);
        this.setPieceOnCell(new Rook(BOTTOM_PLAYER_COLOR), 0, 7);
        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 1, 0);
        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 1, 1);
        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 1, 2);
        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 1, 3);
        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 3, 4);
        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 1, 5);
        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 1, 6);
        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 1, 7);

        this.setPieceOnCell(new Rook(TOP_PLAYER_COLOR), 7, 0);
        this.setPieceOnCell(new Horse(TOP_PLAYER_COLOR), 7, 1);
        this.setPieceOnCell(new Bishop(TOP_PLAYER_COLOR), 7, 2);
        this.setPieceOnCell(new Queen(TOP_PLAYER_COLOR), 7, 3);
        this.setPieceOnCell(new King(TOP_PLAYER_COLOR), 5, 2);
        this.setPieceOnCell(new Bishop(TOP_PLAYER_COLOR), 7, 5);
        this.setPieceOnCell(new Horse(TOP_PLAYER_COLOR), 7, 6);
        this.setPieceOnCell(new Rook(TOP_PLAYER_COLOR), 7, 7);
        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 6, 0);
        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 6, 1);
        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 6, 2);
        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 6, 3);
        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 4, 4);
        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 6, 5);
        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 6, 6);
        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 6, 7);
    }

    private void castling0Attack() {
        this.setPieceOnCell(new Rook(BOTTOM_PLAYER_COLOR), 0, 0);
        this.setPieceOnCell(new Horse(BOTTOM_PLAYER_COLOR), 2, 0);
        this.setPieceOnCell(new Bishop(BOTTOM_PLAYER_COLOR), 1, 1);
        this.setPieceOnCell(new Queen(BOTTOM_PLAYER_COLOR), 5, 2);
        this.setPieceOnCell(new King(BOTTOM_PLAYER_COLOR), 0, 4);
        this.setPieceOnCell(new Bishop(BOTTOM_PLAYER_COLOR), 0, 5);
        this.setPieceOnCell(new Horse(BOTTOM_PLAYER_COLOR), 0, 6);
        this.setPieceOnCell(new Rook(BOTTOM_PLAYER_COLOR), 0, 7);
        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 1, 0);
        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 3, 1);
        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 3, 2);
        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 1, 3);
        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 1, 4);
        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 1, 5);
        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 1, 6);
        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 1, 7);

        this.setPieceOnCell(new Rook(TOP_PLAYER_COLOR), 7, 0);
        this.setPieceOnCell(new Horse(TOP_PLAYER_COLOR), 5, 0);
        this.setPieceOnCell(new Bishop(TOP_PLAYER_COLOR), 6, 1);
        this.setPieceOnCell(new Queen(TOP_PLAYER_COLOR), 2, 2);
        this.setPieceOnCell(new King(TOP_PLAYER_COLOR), 7, 4);
        this.setPieceOnCell(new Bishop(TOP_PLAYER_COLOR), 7, 5);
        this.setPieceOnCell(new Horse(TOP_PLAYER_COLOR), 7, 6);
        this.setPieceOnCell(new Rook(TOP_PLAYER_COLOR), 7, 7);
        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 6, 0);
        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 4, 1);
        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 4, 2);
        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 6, 3);
        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 6, 4);
        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 6, 5);
        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 6, 6);
        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 6, 7);
    }

    private void castling7Attack() {
        this.setPieceOnCell(new Rook(BOTTOM_PLAYER_COLOR), 0, 0);
        this.setPieceOnCell(new Horse(BOTTOM_PLAYER_COLOR), 0, 1);
        this.setPieceOnCell(new Bishop(BOTTOM_PLAYER_COLOR), 0, 2);
        this.setPieceOnCell(new Queen(BOTTOM_PLAYER_COLOR), 0, 3);
        this.setPieceOnCell(new King(BOTTOM_PLAYER_COLOR), 0, 4);
        this.setPieceOnCell(new Bishop(BOTTOM_PLAYER_COLOR), 4, 3);
        this.setPieceOnCell(new Horse(BOTTOM_PLAYER_COLOR), 2, 7);
        this.setPieceOnCell(new Rook(BOTTOM_PLAYER_COLOR), 0, 7);
        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 1, 0);
        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 1, 1);
        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 1, 2);
        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 1, 3);
        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 1, 4);
        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 2, 5);
        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 3, 6);
        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 1, 7);

        this.setPieceOnCell(new Rook(TOP_PLAYER_COLOR), 7, 0);
        this.setPieceOnCell(new Horse(TOP_PLAYER_COLOR), 7, 1);
        this.setPieceOnCell(new Bishop(TOP_PLAYER_COLOR), 7, 2);
        this.setPieceOnCell(new Queen(TOP_PLAYER_COLOR), 7, 3);
        this.setPieceOnCell(new King(TOP_PLAYER_COLOR), 7, 4);
        this.setPieceOnCell(new Bishop(TOP_PLAYER_COLOR), 3, 3);
        this.setPieceOnCell(new Horse(TOP_PLAYER_COLOR), 5, 7);
        this.setPieceOnCell(new Rook(TOP_PLAYER_COLOR), 7, 7);
        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 6, 0);
        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 6, 1);
        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 6, 2);
        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 6, 3);
        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 6, 4);
        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 5, 5);
        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 4, 6);
        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 6, 7);
    }

    private void test2() {
        this.setPieceOnCell(new Rook(BOTTOM_PLAYER_COLOR), 0, 0);
        this.setPieceOnCell(new Horse(BOTTOM_PLAYER_COLOR), 0, 1);
        this.setPieceOnCell(new Bishop(BOTTOM_PLAYER_COLOR), 0, 2);
        this.setPieceOnCell(new Queen(BOTTOM_PLAYER_COLOR), 0, 3);
        this.setPieceOnCell(new King(BOTTOM_PLAYER_COLOR), 0, 4);
        this.setPieceOnCell(new Bishop(BOTTOM_PLAYER_COLOR), 4, 5);
        this.setPieceOnCell(new Horse(BOTTOM_PLAYER_COLOR), 0, 6);
        this.setPieceOnCell(new Rook(BOTTOM_PLAYER_COLOR), 0, 7);
        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 1, 0);
        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 1, 1);
        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 1, 2);
        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 1, 3);
        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 1, 4);
//        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 1, 5);
        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 3, 6);
        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 1, 7);

        this.setPieceOnCell(new Rook(TOP_PLAYER_COLOR), 7, 0);
        this.setPieceOnCell(new Horse(TOP_PLAYER_COLOR), 7, 1);
        this.setPieceOnCell(new Bishop(TOP_PLAYER_COLOR), 7, 2);
        this.setPieceOnCell(new Queen(TOP_PLAYER_COLOR), 7, 3);
        this.setPieceOnCell(new King(TOP_PLAYER_COLOR), 7, 4);
        this.setPieceOnCell(new Bishop(TOP_PLAYER_COLOR), 3, 5);
        this.setPieceOnCell(new Horse(TOP_PLAYER_COLOR), 7, 6);
        this.setPieceOnCell(new Rook(TOP_PLAYER_COLOR), 7, 7);
        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 6, 0);
        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 6, 1);
        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 6, 2);
        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 6, 3);
        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 6, 4);
//        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 6, 5);
        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 4, 6);
        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 6, 7);
    }

    private void cellBeforeKingUnderAttack() {
        this.setPieceOnCell(new King(BOTTOM_PLAYER_COLOR), 2, 3);
        this.setPieceOnCell(new Bishop(TOP_PLAYER_COLOR), 4, 5);
        this.setPieceOnCell(new Rook(TOP_PLAYER_COLOR), 5, 3);
        this.setPieceOnCell(new Rook(BOTTOM_PLAYER_COLOR), 0, 0);
        this.setPieceOnCell(new Horse(BOTTOM_PLAYER_COLOR), 2, 0);
        this.setPieceOnCell(new Bishop(BOTTOM_PLAYER_COLOR), 4, 6);
        this.setPieceOnCell(new Queen(BOTTOM_PLAYER_COLOR), 2, 3);
        this.setPieceOnCell(new King(BOTTOM_PLAYER_COLOR), 0, 4);
        this.setPieceOnCell(new Bishop(BOTTOM_PLAYER_COLOR), 0, 5);
        this.setPieceOnCell(new Horse(BOTTOM_PLAYER_COLOR), 0, 6);
        this.setPieceOnCell(new Rook(BOTTOM_PLAYER_COLOR), 0, 7);
        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 1, 0);
        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 1, 1);
        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 1, 2);
        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 3, 3);
        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 3, 4);
        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 1, 5);
        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 1, 6);
        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 1, 7);

        this.setPieceOnCell(new Rook(TOP_PLAYER_COLOR), 7, 0);
        this.setPieceOnCell(new Horse(TOP_PLAYER_COLOR), 5, 0);
        this.setPieceOnCell(new Bishop(TOP_PLAYER_COLOR), 3, 6);
        this.setPieceOnCell(new Queen(TOP_PLAYER_COLOR), 5, 3);
        this.setPieceOnCell(new King(TOP_PLAYER_COLOR), 7, 4);
        this.setPieceOnCell(new Bishop(TOP_PLAYER_COLOR), 7, 5);
        this.setPieceOnCell(new Horse(TOP_PLAYER_COLOR), 7, 6);
        this.setPieceOnCell(new Rook(TOP_PLAYER_COLOR), 7, 7);
        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 6, 0);
        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 6, 1);
        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 6, 2);
        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 4, 3);
        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 4, 4);
        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 6, 5);
        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 6, 6);
        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 6, 7);
    }

    private void basePosition() {
        this.setPieceOnCell(new Rook(BOTTOM_PLAYER_COLOR), 0, 0);
        this.setPieceOnCell(new Horse(BOTTOM_PLAYER_COLOR), 0, 1);
        this.setPieceOnCell(new Bishop(BOTTOM_PLAYER_COLOR), 0, 2);
        this.setPieceOnCell(new Queen(BOTTOM_PLAYER_COLOR), 0, 3);
        this.setPieceOnCell(new King(BOTTOM_PLAYER_COLOR), 0, 4);
        this.setPieceOnCell(new Bishop(BOTTOM_PLAYER_COLOR), 0, 5);
        this.setPieceOnCell(new Horse(BOTTOM_PLAYER_COLOR), 0, 6);
        this.setPieceOnCell(new Rook(BOTTOM_PLAYER_COLOR), 0, 7);
        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 1, 0);
        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 1, 1);
        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 1, 2);
        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 1, 3);
        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 1, 4);
        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 1, 5);
        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 1, 6);
        this.setPieceOnCell(new Pawn(BOTTOM_PLAYER_COLOR), 1, 7);

        this.setPieceOnCell(new Rook(TOP_PLAYER_COLOR), 7, 0);
        this.setPieceOnCell(new Horse(TOP_PLAYER_COLOR), 7, 1);
        this.setPieceOnCell(new Bishop(TOP_PLAYER_COLOR), 7, 2);
        this.setPieceOnCell(new Queen(TOP_PLAYER_COLOR), 7, 3);
        this.setPieceOnCell(new King(TOP_PLAYER_COLOR), 7, 4);
        this.setPieceOnCell(new Bishop(TOP_PLAYER_COLOR), 7, 5);
        this.setPieceOnCell(new Horse(TOP_PLAYER_COLOR), 7, 6);
        this.setPieceOnCell(new Rook(TOP_PLAYER_COLOR), 7, 7);
        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 6, 0);
        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 6, 1);
        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 6, 2);
        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 6, 3);
        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 6, 4);
        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 6, 5);
        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 6, 6);
        this.setPieceOnCell(new Pawn(TOP_PLAYER_COLOR), 6, 7);
    }

    @Override
    public void printHelp() {

    }

    @Override
    public void printBoard() {
        userInterface.printMessage("Ходят - " + (nowPlayerColor().equals(BOTTOM_PLAYER_COLOR) ? "Белые" : "Черные"));

        for (int i = 7; i > -1; i--) {
            userInterface.setLabel((i + 1) + " ", i);
            for (int j = 0; j < 8; j++) {
                if (this.isEmptyCell(i, j)) {
                    userInterface.setCell(null, i, j);
                } else {
                    userInterface.setCell(this.getPieceOnCell(i, j).getSymbol() + this.getPieceOnCell(i, j).getColor().substring(0, 1).toLowerCase(), i, j);
                }
            }
        }
        userInterface.setRow(" A B C D E F G H");
        f.pack();
    }

    @Override
    public void processCommand(String s) {
        if (s.contains("move")) {
            String[] a = s.split(" ");

            int line = Integer.parseInt(a[1]);
            int column = Integer.parseInt(a[2]);
            int toLine = Integer.parseInt(a[3]);
            int toColumn = Integer.parseInt(a[4]);
            if (line == 0 && column == 4 && toLine == 0 && toColumn == 0 && this.castling0()) {
                printBoard();
            } else if (line == 7 && column == 4 && toLine == 7 && toColumn == 0 && this.castling0()) {
                printBoard();
            } else if (line == 0 && column == 4 && toLine == 0 && toColumn == 7 && this.castling7()) {
                printBoard();
            } else if (line == 7 && column == 4 && toLine == 7 && toColumn == 7 && this.castling7()) {
                printBoard();
            } else if (this.moveToPosition(line, column, toLine, toColumn)) {
                printBoard();
                if(this.isGameOver()) userInterface.printMessage("Игра окончена!");
            } else {
                throw new RuntimeException("Ошибка!");

            }
        }
    }

    @Override
    public void gameLoop() {
        f = new JFrame("ChessChamp");
        f.add(((ChessGUI) userInterface).getGui());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationByPlatform(true);
        f.setMinimumSize(f.getSize());
        f.setVisible(true);

        this.startGame();
    }
}
