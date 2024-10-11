package home.work.game.piece.classic;

import home.work.game.piece.base.BasePawn;

import static home.work.game.Colors.BOTTOM_PLAYER_COLOR;

public class Pawn extends BasePawn {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return getColor().equals(BOTTOM_PLAYER_COLOR) ? "\u001B[37m♟" : "\u001B[30m♟";
    }
}
