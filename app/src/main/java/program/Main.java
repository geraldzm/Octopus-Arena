package program;

import model.ContextNode;
import model.GameSession;
import model.User;
import views.WindowBuilder;
import views.WindowID;

public class Main {

    public static void main(String[] args) {

        WindowBuilder.buildWindowAndShow(null, WindowID.LOGIN);

     //   WindowBuilder.buildWindowAndShow(null, WindowID.GAME);
     //   ------------- This will be made by the Home controller ---------

        GameSession gameSession = new GameSession(2);

        ContextNode contextUser0 = new ContextNode();
        contextUser0.gameSession = gameSession;
        contextUser0.user = new User("Gerald", 100, 1000.0);
        contextUser0.health = 70;
        contextUser0.toBet = 150.0;

        WindowBuilder.buildWindowAndShow(contextUser0, WindowID.GAME);

        ContextNode contextUser1 = new ContextNode();
        contextUser1.gameSession = gameSession;
        contextUser1.user = new User("Ana", 50, 500.0);
        contextUser1.health = 100;
        contextUser1.toBet = 40.0;

        WindowBuilder.buildWindowAndShow(contextUser1, WindowID.GAME);

//
//        ContextNode contextNode1 = new ContextNode();
//        contextNode1.gameSession = new GameSession(8);
//
//        for (int i = 0; i < 8; i++) {
//            WindowBuilder.buildWindowAndShow(contextNode1, WindowID.GAME);
//        }

        //------------- This will be made by the Home controller ---------
    }

}
