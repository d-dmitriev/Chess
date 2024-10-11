package home.work;

import home.work.board.ChessBoard;
import home.work.piece.*;

import java.util.Scanner;

import static home.work.game.Constants.*;

public class Main {

    public static ChessBoard buildBoard() {
        ChessBoard board = new ChessBoard(BOTTOM_PLAYER_COLOR);

        board.board[BOTTOM_PLAYER_KING_LINE][LEFT_ROOK_INIT_POSITION] = new Rook(BOTTOM_PLAYER_COLOR);
        board.board[BOTTOM_PLAYER_KING_LINE][LEFT_HORSE_INIT_POSITION] = new Horse(BOTTOM_PLAYER_COLOR);
        board.board[BOTTOM_PLAYER_KING_LINE][LEFT_BISHOP_INIT_POSITION] = new Bishop(BOTTOM_PLAYER_COLOR);
        board.board[BOTTOM_PLAYER_KING_LINE][QUEEN_INIT_POSITION] = new Queen(BOTTOM_PLAYER_COLOR);
        board.board[BOTTOM_PLAYER_KING_LINE][KING_INIT_POSITION] = new King(BOTTOM_PLAYER_COLOR);
        board.board[BOTTOM_PLAYER_KING_LINE][RIGHT_BISHOP_INIT_POSITION] = new Bishop(BOTTOM_PLAYER_COLOR);
        board.board[BOTTOM_PLAYER_KING_LINE][RIGHT_HORSE_INIT_POSITION] = new Horse(BOTTOM_PLAYER_COLOR);
        board.board[BOTTOM_PLAYER_KING_LINE][RIGHT_ROOK_INIT_POSITION] = new Rook(BOTTOM_PLAYER_COLOR);
        board.board[BOTTOM_PLAYER_PAWN_LINE][0] = new Pawn(BOTTOM_PLAYER_COLOR);
        board.board[BOTTOM_PLAYER_PAWN_LINE][1] = new Pawn(BOTTOM_PLAYER_COLOR);
        board.board[BOTTOM_PLAYER_PAWN_LINE][2] = new Pawn(BOTTOM_PLAYER_COLOR);
        board.board[BOTTOM_PLAYER_PAWN_LINE][3] = new Pawn(BOTTOM_PLAYER_COLOR);
        board.board[BOTTOM_PLAYER_PAWN_LINE][4] = new Pawn(BOTTOM_PLAYER_COLOR);
        board.board[BOTTOM_PLAYER_PAWN_LINE][5] = new Pawn(BOTTOM_PLAYER_COLOR);
        board.board[BOTTOM_PLAYER_PAWN_LINE][6] = new Pawn(BOTTOM_PLAYER_COLOR);
        board.board[BOTTOM_PLAYER_PAWN_LINE][7] = new Pawn(BOTTOM_PLAYER_COLOR);

        board.board[TOP_PLAYER_KING_LINE][LEFT_ROOK_INIT_POSITION] = new Rook(TOP_PLAYER_COLOR);
        board.board[TOP_PLAYER_KING_LINE][LEFT_HORSE_INIT_POSITION] = new Horse(TOP_PLAYER_COLOR);
        board.board[TOP_PLAYER_KING_LINE][LEFT_BISHOP_INIT_POSITION] = new Bishop(TOP_PLAYER_COLOR);
        board.board[TOP_PLAYER_KING_LINE][QUEEN_INIT_POSITION] = new Queen(TOP_PLAYER_COLOR);
        board.board[TOP_PLAYER_KING_LINE][KING_INIT_POSITION] = new King(TOP_PLAYER_COLOR);
        board.board[TOP_PLAYER_KING_LINE][RIGHT_BISHOP_INIT_POSITION] = new Bishop(TOP_PLAYER_COLOR);
        board.board[TOP_PLAYER_KING_LINE][RIGHT_HORSE_INIT_POSITION] = new Horse(TOP_PLAYER_COLOR);
        board.board[TOP_PLAYER_KING_LINE][RIGHT_ROOK_INIT_POSITION] = new Rook(TOP_PLAYER_COLOR);
        board.board[TOP_PLAYER_PAWN_LINE][0] = new Pawn(TOP_PLAYER_COLOR);
        board.board[TOP_PLAYER_PAWN_LINE][1] = new Pawn(TOP_PLAYER_COLOR);
        board.board[TOP_PLAYER_PAWN_LINE][2] = new Pawn(TOP_PLAYER_COLOR);
        board.board[TOP_PLAYER_PAWN_LINE][3] = new Pawn(TOP_PLAYER_COLOR);
        board.board[TOP_PLAYER_PAWN_LINE][4] = new Pawn(TOP_PLAYER_COLOR);
        board.board[TOP_PLAYER_PAWN_LINE][5] = new Pawn(TOP_PLAYER_COLOR);
        board.board[TOP_PLAYER_PAWN_LINE][6] = new Pawn(TOP_PLAYER_COLOR);
        board.board[TOP_PLAYER_PAWN_LINE][7] = new Pawn(TOP_PLAYER_COLOR);

        return board;
    }

    public static void main(String[] args) {

        ChessBoard board = buildBoard();
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Чтобы проверить игру надо вводить команды:
                'exit' - для выхода
                'replay' - для перезапуска игры
                'castling0' или 'castling7' - для рокировки по соответствующей линии
                'move 1 1 2 3' - для передвижения фигуры с позиции 1 1 на 2 3(поле это двумерный массив от 0 до 7)
                Проверьте могут ли фигуры ходить друг сквозь друга, корректно ли съедают друг друга, можно ли поставить шах и сделать рокировку?""");
        System.out.println();
        board.printBoard();
        while (true) {
            String s = scanner.nextLine();
            if (s.equals("exit")) break;
            else if (s.equals("replay")) {
                System.out.println("Заново");
                board = buildBoard();
                board.printBoard();
            } else {
                if (s.equals("castling0")) {
                    if (board.castling0()) {
                        System.out.println("Рокировка удалась");
                        board.printBoard();
                    } else {
                        System.out.println("Рокировка не удалась");
                    }
                } else if (s.equals("castling7")) {
                    if (board.castling7()) {
                        System.out.println("Рокировка удалась");
                        board.printBoard();
                    } else {
                        System.out.println("Рокировка не удалась");
                    }
                } else if (s.contains("move")) {
                    String[] a = s.split(" ");
                    try {
                        int line = Integer.parseInt(a[1]);
                        int column = Integer.parseInt(a[2]);
                        int toLine = Integer.parseInt(a[3]);
                        int toColumn = Integer.parseInt(a[4]);
                        if (board.moveToPosition(line, column, toLine, toColumn)) {
                            System.out.println("Успешно передвинулись");
                            board.printBoard();
                        } else System.out.println("Передвижение не удалось");
                    } catch (Exception e) {
                        System.out.println("Вы что-то ввели не так, попробуйте ещё раз");
                    }

                }
            }
        }
    }
}