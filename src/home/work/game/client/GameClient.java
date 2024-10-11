package home.work.game.client;

import home.work.game.builder.base.rules.CellPosition;

public interface GameClient {
    void runCommand(String command);

    void startGame();

    void restartGame();

    void gameLoop();

    CellPosition[] getPossibleMovesFromCell(int line, int column);

    boolean isGameOver();
}
