package home.work.game.piece.classic;

import home.work.game.piece.base.BaseKing;

import static home.work.game.Colors.BOTTOM_PLAYER_COLOR;

public class King extends BaseKing {
    public King(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return getColor().equals(BOTTOM_PLAYER_COLOR) ? "\u001B[37m♚" : "\u001B[30m♚";
    }
}
