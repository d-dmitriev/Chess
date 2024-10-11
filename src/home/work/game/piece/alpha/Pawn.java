package home.work.game.piece.alpha;

import home.work.game.piece.base.BasePawn;

public class Pawn extends BasePawn {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
