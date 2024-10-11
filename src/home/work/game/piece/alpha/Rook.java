package home.work.game.piece.alpha;

import home.work.game.piece.base.BaseRook;

public class Rook extends BaseRook {
    public Rook(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
