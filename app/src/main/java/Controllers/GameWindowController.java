package Controllers;

import model.ContextNode;
import Logic.GameSession;
import model.Session;
import views.GameWindow;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindowController extends WindowAdapter {

    public final GameWindow gameWindow;
    private final GameSession gameSession;
    private final Session session;

    public GameWindowController(GameWindow gameWindow) {

        this.gameWindow = gameWindow;
        this.gameWindow.addWindowListener(this);

        ContextNode ctx = gameWindow.getContextNode();
        gameSession = ctx.gameSession;
        session = ctx.session;

        session.setGameWindow(gameWindow);

        gameSession.registerSession(session);

    }

    @Override
    public void windowClosed(WindowEvent e) {
        session.disconnect();
    }

}
