package home.work.game.piece.alpha;

import home.work.game.piece.base.BaseQueen;

public class Queen extends BaseQueen {
    public Queen(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}
