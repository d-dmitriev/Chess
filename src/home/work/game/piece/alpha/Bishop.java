package home.work.game.piece.alpha;

import home.work.game.piece.base.BaseBishop;

public class Bishop extends BaseBishop {
    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
