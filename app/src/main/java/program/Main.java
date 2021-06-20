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
        contextNode0.gameSession = new GameSession(18);

        for (int i = 0; i < 18; i++) {
            WindowBuilder.buildWindowAndShow(contextNode0, WindowID.GAME);
        }

        //------------- This will be made by the Home controller ---------

    }

}
