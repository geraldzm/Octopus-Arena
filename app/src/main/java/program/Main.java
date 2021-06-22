package program;

import model.ContextNode;
import model.GameSession;
import views.WindowBuilder;
import views.WindowID;

public class Main {

    public static void main(String[] args) {

        WindowBuilder.buildWindowAndShow(null, WindowID.LOGIN);

     //   WindowBuilder.buildWindowAndShow(null, WindowID.GAME);
     //   ------------- This will be made by the Home controller ---------

        ContextNode contextNode0 = new ContextNode();
        contextNode0.gameSession = new GameSession(2);

        for (int i = 0; i < 2; i++) {
            WindowBuilder.buildWindowAndShow(contextNode0, WindowID.GAME);
        }

        ContextNode contextNode1 = new ContextNode();
        contextNode1.gameSession = new GameSession(3);

        for (int i = 0; i < 3; i++) {
            WindowBuilder.buildWindowAndShow(contextNode1, WindowID.GAME);
        }

        //------------- This will be made by the Home controller ---------
    }

}
