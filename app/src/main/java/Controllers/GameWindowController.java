package Controllers;

import model.GameSession;
import views.GameWindow;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindowController extends WindowAdapter {

    public final GameWindow gameWindow;
    private final GameSession gameSession;

    public GameWindowController(GameWindow gameWindow) {
        this.gameWindow = gameWindow;

        gameSession = gameWindow.getContextNode().gameSession;
        gameSession.registerPlayer(gameWindow);

        gameWindow.addWindowListener(this);

    }

    @Override
    public void windowClosed(WindowEvent e) {
        super.windowClosed(e);
    }

}
