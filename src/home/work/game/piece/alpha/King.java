package home.work.game.piece.alpha;

import home.work.game.piece.base.BaseKing;

public class King extends BaseKing {
    public King(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return "K";
    }
}
