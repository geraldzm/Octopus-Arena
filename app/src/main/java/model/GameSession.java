package model;

import game.Game;

public class GameSession {

    private final Game game;
    private final int maxPlayers;

    public GameSession(int maxPlayers) {
        this.maxPlayers = maxPlayers;

        game = new Game();

    }

    public void registerPlayer(Updatable player) {

        if(maxPlayers > game.observers.size()) {
            game.register(player);

            if(maxPlayers == game.observers.size()) game.start();

        }

    }



}
