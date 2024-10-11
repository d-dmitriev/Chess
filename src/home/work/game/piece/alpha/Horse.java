package home.work.game.piece.alpha;

import home.work.game.piece.base.BaseHorse;

public class Horse extends BaseHorse {
    public Horse(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
