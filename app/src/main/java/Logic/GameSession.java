package Logic;

import game.Game;
import game.Octopus;
import model.Session;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

import static Util.Utility.random;

public class GameSession {

    private final Game game;
    private final int maxPlayers;
    private int currentPlayers;
    private final ArrayList<Session> allSessions;

    public GameSession(int maxPlayers) {

        this.maxPlayers = maxPlayers;
        currentPlayers = 0;
        allSessions = new ArrayList<>(maxPlayers);

        game = new Game(this);
    }

    public void registerPlayer(Session session) {

        if(maxPlayers > currentPlayers) {

            allSessions.add(session);
            game.register(session);
            currentPlayers++;

            // on disconnected
            session.register(this::onSessionDisconnected);

            if(maxPlayers == game.observers.size()) { // esto se va a controlar en el Checkin Controller
                initGame();
            }

        }

    }

    private void initGame() {
        ArrayList<Octopus> octopusList = (ArrayList<Octopus>) allSessions.stream()
                .map(Session::getOctopus)
                .collect(Collectors.toList());

        LinkedHashMap<String, Color> nameTable = new LinkedHashMap<>(allSessions.size());

        allSessions.forEach(s -> {
            s.initGame(octopusList);

            Color color = new Color(random(0, 256), random(0, 256), random(0, 256));
            s.setUserColor(color);
            nameTable.put(s.getUser().getNickname(), color);
        });

        game.setNameTable(nameTable);
        game.setOctopus(octopusList);
        game.start();
    }

    public void onSessionDisconnected (Session session) {

        game.unRegister(session); // player disconnected
        allSessions.remove(session);

        if(game.observers.size() == 0) {
            game.stop(); // stop game if there is no more players
            System.out.println("Game stopped");
        }

    }

    public void onGameFinished() {

        // EL game me da el orden en el que murieron los pulpos
        // ordeno sesiones por el orden en que murieron los pulpos
        // para cada secion en allsesions creo una ventana con los rankings
        // creo un objeto que reparta la plata y le paso las sesiones ne ese orden
        // el va a repartir la plata
        // la lista que le paso al ranking es una copia de allSession
        // cierro todas las vetnanas de todas las sessiones

    }

}
