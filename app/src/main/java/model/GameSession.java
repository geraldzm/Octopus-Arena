package model;

import game.Game;
import views.GameWindow;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameSession {

    private final Game game;
    private final int maxPlayers;
    private int currentPlayers;

    public GameSession(int maxPlayers) {

        this.maxPlayers = maxPlayers;
        currentPlayers = 0;

        game = new Game();

    }

    public void registerPlayer(GameWindow player) {

        if(maxPlayers > currentPlayers) {

            game.register(player);
            currentPlayers++;

            // on disconnected
            player.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {

                    game.unRegister(player); // player disconnected
                    game.remove();

                    if(game.observers.size() == 0) {
                        game.stop(); // stop game if there is no more players
                        System.out.println("Game stopped");
                    }

                }
            });

            if(maxPlayers == game.observers.size()) game.start();

        }

    }


}
