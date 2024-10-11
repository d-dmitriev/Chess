package home.work.ui.gui.internal;

import home.work.game.builder.base.rules.CellPosition;
import home.work.game.client.GameClient;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ChessMove extends AbstractAction {
    int fromI = -1;
    int fromJ = -1;
    int toI = -1;
    int toJ = -1;
    Cell first;
    final GameClient game;
    Cell[][] cells;

    public ChessMove(GameClient game, Cell[][] cells) {
        this.game = game;
        this.cells = cells;
    }

    public void reset() {
        fromJ = -1;
        fromI = -1;
        toJ = -1;
        toI = -1;
        first = null;
        unmark();
    }

    private void unmark() {
        for(Cell[] p : cells) {
            for (Cell c : p) {
                c.unmark();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] action = e.getActionCommand().split(":");
        int i = Integer.parseInt(action[0]), j = Integer.parseInt(action[1]);
        CellPosition[] pos = game.getPossibleMovesFromCell(j, i);
        if (first == null && pos.length > 0) {
            first = (Cell) e.getSource();
            first.mark();
            fromI = i;
            fromJ = j;
            for(CellPosition p: pos) cells[p.line()][p.column()].mark();
        } else if(first != null) {
            toI = i;
            toJ = j;
            try {
                game.runCommand("move " + fromJ + " " + fromI + " " + toJ + " " + toI);
                first = null;
                unmark();
            } catch (Exception ignored) {

            } finally {
                toI = -1;
                toJ = -1;
            }
        }
    }
}
