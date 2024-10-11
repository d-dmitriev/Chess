package home.work.ui.gui.internal;

import java.util.Arrays;
import java.util.Optional;

public enum Sprites {
    KING("K"),
    QUEEN("Q"),
    BISHOP("B"),
    KNIGHT("H"),
    ROOK("R"),
    PAWN("P");

    public final String operation;

    Sprites(String operation) {
        this.operation = operation;
    }

    public static Optional<Sprites> fromString(String operation) {
        return Arrays.stream(values()).filter(value -> value.operation.equals(operation)).findFirst();
    }
}
