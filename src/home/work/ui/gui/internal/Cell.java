package home.work.ui.gui.internal;

import javax.swing.*;
import java.awt.*;

import static home.work.ui.gui.internal.Constants.*;

public class Cell extends JButton {
    private final Color baseColor;
    public Cell(ChessMove move, Color baseColor) {
        super(move);
        this.setMinimumSize(new Dimension(64, 64));
        this.setBorderPainted(false);
        this.setOpaque(true);
        this.setBackground(baseColor);
        this.baseColor = baseColor;
    }
    public void mark() {
        this.setBackground(this.baseColor.equals(WHITE) ? MARKED_WHITE_DRAG : MARKED_BLACK_DRAG);
    }
    public void unmark() {
        this.setBackground(this.baseColor);
    }
}
