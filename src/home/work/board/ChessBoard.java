package home.work.board;

import home.work.game.Castling;
import home.work.game.Game;
import home.work.piece.ChessPiece;

import static home.work.game.Constants.*;

public class ChessBoard implements Game {

    public ChessPiece[][] board = new ChessPiece[8][8]; // creating a field for game
    String nowPlayer;
    private final Castling castling = new Castling(this);

    public ChessBoard(String nowPlayer) {
        this.nowPlayer = nowPlayer;
    }

    public String nowPlayerColor() {
        return this.nowPlayer;
    }

    private String getOpponentColor() {
        return this.nowPlayerColor().equals(BOTTOM_PLAYER_COLOR) ? TOP_PLAYER_COLOR : BOTTOM_PLAYER_COLOR;
    }

    public boolean moveToPosition(int startLine, int startColumn, int endLine, int endColumn) {
        if (checkPos(startLine) && checkPos(startColumn)) {
            if (isCurrentPlayerPieceOnCell(startLine, startColumn) && canPieceMoveToPosition(startLine, startColumn, endLine, endColumn)) {
                movePieceToPosition(startLine, startColumn, endLine, endColumn); // if piece can move, we moved a piece
                this.nowPlayer = getOpponentColor();

                return true;
            }
        }
        return false;
    }

    public void printBoard() {  //print board in console
        System.out.println("Turn " + nowPlayerColor());
        System.out.println();
        System.out.println("Player 2(Black)");
//        System.out.println();
        System.out.println("\t 0  1  2  3  4  5  6  7");

        for (int i = 7; i > -1; i--) {
            System.out.print(i + "\t");
            for (int j = 0; j < 8; j++) {
                String s = (Math.floorMod(i, 2) == 0 && Math.floorMod(j, 2) == 0) || (Math.floorMod(i, 2) == 1 && Math.floorMod(j, 2) == 1) ? "\u001b[48;5;88m " : "\u001b[48;5;180m ";
                if (isEmptyCell(i, j)) {
                    System.out.print(s + "  ");
                } else {
                    System.out.print(s + getPieceOnCell(i, j).getSymbolForBoard() + " ");
                }
            }
            System.out.println("\u001B[0m");
        }
        System.out.println("Player 1(White)");
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }

    public boolean isEmptyCell(int line, int column) {
        return getPieceOnCell(line, column) == null;
    }

    public boolean isLineBetweenCellEmpty(int fromLine, int fromColumn, int toLine, int toColumn) {
        for (int lineDiff = fromLine - toLine, columnDiff = fromColumn - toColumn; lineDiff != 0 || columnDiff != 0; lineDiff += Integer.compare(0, lineDiff), columnDiff += Integer.compare(0, columnDiff)) {
            int tmpLine = toLine + lineDiff, tmpColumn = toColumn + columnDiff;
            if (tmpLine == fromLine && tmpColumn == fromColumn) continue;
            if (!isEmptyCell(tmpLine, tmpColumn)) return false;
        }
        return true;
    }

    public boolean isOpponentPieceOnCell(int line, int column) {
        return hasColor(getPieceOnCell(line, column), getOpponentColor());
    }

    public boolean isCurrentPlayerPieceOnCell(int line, int column) {
        return hasColor(getPieceOnCell(line, column), nowPlayerColor());
    }

    public ChessPiece getPieceOnCell(int line, int column) {
        return board[line][column];
    }

    public boolean isPieceOnCellMoved(int line, int column) {
        return !getPieceOnCell(line, column).isCheck();
    }

    public void movePieceToPosition(int fromLine, int fromColumn, int toLine, int toColumn) {
        ChessPiece piece = getPieceOnCell(fromLine, fromColumn);
        setPaceOnCell(piece, toLine, toColumn);
        piece.uncheck();
        setPaceOnCell(null, fromLine, fromColumn);
    }

    public boolean isRookOnCell(int line, int column) {
        return this.getPieceOnCell(line, column).hasSymbol(ROOK_SYMBOL);
    }
    public boolean isQueenOnCell(int line, int column) {
        return this.getPieceOnCell(line, column).hasSymbol(QUEEN_SYMBOL);
    }
    public boolean isBishopOnCell(int line, int column) {
        return this.getPieceOnCell(line, column).hasSymbol(BISHOP_SYMBOL);
    }
    public boolean isKingOnCell(int line, int column) {
        return this.getPieceOnCell(line, column).hasSymbol(KING_SYMBOL);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Определение линии короля в зависимости от текущего игрока
    private int getCurrentPlayerKingLine() {
        return this.nowPlayerColor().equals(BOTTOM_PLAYER_COLOR) ? BOTTOM_PLAYER_KING_LINE : TOP_PLAYER_KING_LINE;
    }

    public boolean castling0() {
        // Перемещение короля в сторону дальней Ладьи
        final int KING_POSITION_NEW = KING_INIT_POSITION - 2;
        final int ROOK_POSITION_NEW = KING_INIT_POSITION - 1;
        if (castling.run(getCurrentPlayerKingLine(), KING_INIT_POSITION, LEFT_ROOK_INIT_POSITION, KING_POSITION_NEW, ROOK_POSITION_NEW)) {
            this.nowPlayer = getOpponentColor(); // next turn
            return true;
        }
        return false;
    }

    public boolean castling7() {
        // Перемещение короля в сторону ближней Ладьи
        final int KING_POSITION_NEW = KING_INIT_POSITION + 2;
        final int ROOK_POSITION_NEW = KING_INIT_POSITION + 1;
        if (castling.run(getCurrentPlayerKingLine(), KING_INIT_POSITION, RIGHT_ROOK_INIT_POSITION, KING_POSITION_NEW, ROOK_POSITION_NEW)) {
            this.nowPlayer = getOpponentColor(); // next turn
            return true;
        }
        return false;
    }

    private boolean hasColor(ChessPiece piece, String color) {
        return piece != null && piece.getColor().equals(color);
    }

    private boolean canPieceMoveToPosition(int startLine, int startColumn, int endLine, int endColumn) {
        return getPieceOnCell(startLine, startColumn).canMoveToPosition(this, startLine, startColumn, endLine, endColumn);
    }

    private void setPaceOnCell(ChessPiece piece, int line, int column) {
        board[line][column] = piece;
    }
}
