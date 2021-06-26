package program;

import model.ContextNode;
import Logic.GameSession;
import model.User;
import views.WindowBuilder;
import views.WindowID;

public class Main {

    public static void main(String[] args) {

        // Nota se va a controlar la cantidad de usuarios que ingrean por dia en el controlador de Login

        WindowBuilder.buildWindowAndShow(null, WindowID.LOGIN);

     //   WindowBuilder.buildWindowAndShow(null, WindowID.GAME);
     //   ------------- This will be made by the Home controller ---------

        GameSession gameSession = new GameSession(4);

        ContextNode contextUser0 = new ContextNode();
        contextUser0.gameSession = gameSession;
        contextUser0.user = new User("Gerald", 100, 1000.0);
        contextUser0.health = 100;
        contextUser0.toBet = 150.0;

        WindowBuilder.buildWindowAndShow(contextUser0, WindowID.GAME);

        ContextNode contextUser1 = new ContextNode();
        contextUser1.gameSession = gameSession;
        contextUser1.user = new User("Ana", 50, 500.0);
        contextUser1.health = 100;
        contextUser1.toBet = 40.0;

        WindowBuilder.buildWindowAndShow(contextUser1, WindowID.GAME);

        ContextNode contextUser3 = new ContextNode();
        contextUser3.gameSession = gameSession;
        contextUser3.user = new User("sdf", 50, 500.0);
        contextUser3.health = 100;
        contextUser3.toBet = 40.0;

        WindowBuilder.buildWindowAndShow(contextUser3, WindowID.GAME);


        ContextNode contextUser4 = new ContextNode();
        contextUser4.gameSession = gameSession;
        contextUser4.user = new User("adsf", 50, 500.0);
        contextUser4.health = 100;
        contextUser4.toBet = 40.0;

        WindowBuilder.buildWindowAndShow(contextUser4, WindowID.GAME);

        //------------- This will be made by the Home controller ---------
    }

}
