import home.work.game.builder.AlphaGame;
import home.work.game.builder.ClassicGame;
import home.work.game.builder.GUIGame;
import home.work.game.client.GameClient;
import home.work.ui.console.ChessConsole;

import static home.work.game.Colors.BOTTOM_PLAYER_COLOR;

public class Main {
    private static final String SELECT_GAME = """
            Выбор варианта игры:
            '1' - текстовый
            '2' - классический
            '3' - графический""";
    private static final String BAD_INPUT = "Вы что-то ввели не так, попробуйте ещё раз";
    private static final String EXIT_COMMAND = "exit";
    private static final String REPLAY_COMMAND = "replay";

    public static void main(String[] args) {
//        GameClient game = switch (ChessConsole.readOperand(SELECT_GAME)) {
//            case 2 -> new ClassicGame(BOTTOM_PLAYER_COLOR);
//            case 3 -> new GUIGame(BOTTOM_PLAYER_COLOR);
//            default -> new AlphaGame(BOTTOM_PLAYER_COLOR);
//        };
        GameClient game = new GUIGame(BOTTOM_PLAYER_COLOR);

        game.gameLoop();
    }
}