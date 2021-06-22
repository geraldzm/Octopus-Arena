package Controllers;

import model.GameSession;
import views.GameWindow;

public class GameWindowController {

    public final GameWindow gameWindow;
    private final GameSession gameSession;

    public GameWindowController(GameWindow gameWindow) {
        this.gameWindow = gameWindow;

        gameSession = gameWindow.getContextNode().gameSession;
        gameSession.registerPlayer(gameWindow);

    }

}
