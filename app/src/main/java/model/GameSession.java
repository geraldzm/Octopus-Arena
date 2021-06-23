package model;

import game.*;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class GameSession {

    private final Game game;
    private final int maxPlayers;
    private int currentPlayers;
    private final ArrayList<Session> allSessions;

    public GameSession(int maxPlayers) {

        this.maxPlayers = maxPlayers;
        currentPlayers = 0;
        allSessions = new ArrayList<>(maxPlayers);

        game = new Game();
    }

    public void registerPlayer(Session session) {

        if(maxPlayers > currentPlayers) {

            allSessions.add(session);
            game.register(session);
            currentPlayers++;

            // on disconnected
            session.register(this::onSessionDisconnected);

            if(maxPlayers == game.observers.size()) {
                ArrayList<Octopus> octopusList = (ArrayList<Octopus>) allSessions.stream()
                        .map(Session::getOctopus)
                        .collect(Collectors.toList());

                game.setOctopus(octopusList);
                game.start();
            }

        }

    }

    public void onSessionDisconnected (Session session) {

        game.unRegister(session); // player disconnected
        allSessions.remove(session);

        if(game.observers.size() == 0) {
            game.stop(); // stop game if there is no more players
            System.out.println("Game stopped");
        }

    }

}
