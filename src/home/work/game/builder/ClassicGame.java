package home.work.game.builder;

import home.work.UI;
import home.work.game.builder.base.BaseGame;
import home.work.game.piece.classic.*;
import home.work.ui.console.ChessConsole;

import static home.work.game.Colors.BOTTOM_PLAYER_COLOR;
import static home.work.game.Colors.TOP_PLAYER_COLOR;

public final class ClassicGame extends BaseGame {
    UI console = new ChessConsole();

    public ClassicGame(String player) {
        super(player);
    }

    @Override
    public void processCommand(String s) {
        if (s.equals("long castling")) {
            if (this.castling0()) {
                console.printMessage("Рокировка удалась");
                printBoard();
            } else {
                console.printMessage("Рокировка не удалась");
            }
        } else if (s.equals("short castling")) {
            if (this.castling7()) {
                console.printMessage("Рокировка удалась");
                printBoard();
            } else {
                console.printMessage("Рокировка не удалась");
            }
        } else if (s.contains("move")) {
            String[] a = s.split(" ");

            int line = Integer.parseInt(a[1].substring(1, 2)) - 1;
            int column = a[1].substring(0, 1).charAt(0) >= 97 ? a[1].substring(0, 1).charAt(0) - 97 : a[1].substring(0, 1).charAt(0) - 65;
            int toLine = Integer.parseInt(a[2].substring(1, 2)) - 1;
            int toColumn = a[2].substring(0, 1).charAt(0) >= 97 ? a[2].substring(0, 1).charAt(0) - 97 : a[2].substring(0, 1).charAt(0) - 65;
            if (this.moveToPosition(line, column, toLine, toColumn)) {
                console.printMessage("Успешно передвинулись");
                printBoard();
            } else console.printMessage("Передвижение не удалось");
        }
    }

    @Override
    public void buildBoard() {
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
    public void printBoard() {
        console.printMessage("Ходят - " + (nowPlayerColor().equals(BOTTOM_PLAYER_COLOR) ? "Белые" : "Черные"));

        console.setRow("");
        for (int i = 7; i > -1; i--) {
            console.setLabel((i + 1) + " ", i);
            for (int j = 0; j < 8; j++) {
                String s = (Math.floorMod(i, 2) == 0 && Math.floorMod(j, 2) == 0) || (Math.floorMod(i, 2) == 1 && Math.floorMod(j, 2) == 1) ? "\u001b[48;5;88m " : "\u001b[48;5;180m ";
                if (this.isEmptyCell(i, j)) {
                    console.setCell(s + "  ", i, j);
                } else {
                    console.setCell(s + this.getPieceOnCell(i, j).getSymbol() + " ", i, j);
                }
            }
            console.setRow("\u001B[0m");
        }
        console.setRow("   A  B  C  D  E  F  G  H");
    }

    @Override
    public void printHelp() {
        console.printMessage("""
                Чтобы проверить игру надо вводить команды:
                'exit' - для выхода
                'replay' - для перезапуска игры
                'long castling' или 'short castling' - для рокировки по соответствующей линии
                'move A1 A3' - для передвижения фигуры с позиции A 1 на A 3
                Проверьте могут ли фигуры ходить друг сквозь друга, корректно ли съедают друг друга, можно ли поставить шах и сделать рокировку?
                """);
    }

    @Override
    public void gameLoop() {
        this.startGame();
        while (true) {
            String s = ChessConsole.readLine();
            if (s.equals("exit")) break;
            else if (s.equals("replay")) {
                this.restartGame();
            } else {
                try {
                    this.runCommand(s);
                } catch (Exception e) {
                    System.out.println("Вы что-то ввели не так, попробуйте ещё раз");
                }
            }
        }
    }
}
