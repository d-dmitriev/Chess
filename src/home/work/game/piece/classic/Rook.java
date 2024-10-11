package home.work.game.piece.classic;

import home.work.game.piece.base.BaseRook;

import static home.work.game.Colors.BOTTOM_PLAYER_COLOR;

public class Rook extends BaseRook {
    public Rook(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return getColor().equals(BOTTOM_PLAYER_COLOR) ? "\u001B[37m♜" : "\u001B[30m♜";
    }
}
