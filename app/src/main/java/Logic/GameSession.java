package Logic;

import game.Game;
import game.MoneyDistributor;
import game.Octopus;
import game.model.UserFinalPosition;
import model.ContextNode;
import model.Session;
import model.User;
import model.UserPlayer;
import views.WindowBuilder;
import views.WindowID;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static Util.Utility.random;

public class GameSession {

    private Game game;
    private ArrayList<Session> allSessions;

    private ArrayList<Octopus> deadOrder;

    public GameSession(int maxPlayers) {

        allSessions = new ArrayList<>(maxPlayers);
        deadOrder = new ArrayList<>(maxPlayers);
        game = new Game(this);

    }

    public void registerSession(Session session) {

        allSessions.add(session);
        game.register(session);
        session.register(this::onSessionDisconnected);

    }

    public void onSessionDisconnected (Session session) {

        game.unRegister(session); // player disconnected
        allSessions.remove(session);

    }

    public boolean isReady() {
        System.out.println("Is ready: " + allSessions.size());
        return allSessions.size() >= 2;
    }

    public void cancel() {
        allSessions.clear();
        allSessions = null;
        game.stop();
        game = null;
    }

    public void initGame() {
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

    public void onGameFinished() {

        game.stop();

        List<UserFinalPosition> finalPositions = allSessions.stream()
                .map(s -> new UserFinalPosition(s.getUser(), s.getToBet(), s.getOctopus().getRankingPosition()))
                .collect(Collectors.toList());

        MoneyDistributor moneyMachine = new MoneyDistributor(new ArrayList<>(finalPositions), 0);
        ArrayList<UserFinalPosition> arrayPositions = moneyMachine.distributeMoney();


        for (int i = 0; i < allSessions.size(); i++) {
            Session s = allSessions.get(i);
            s.cleanObservers();

            ContextNode node = new ContextNode();
            node.user = s.getUser();
            node.finalPositions = new ArrayList<>(arrayPositions);

            s.getGameWindow().dispose();
            WindowBuilder.buildWindowAndShow(node, WindowID.SCORE_BOARD);
        }

    }

    public int getAmountOfCurrentPlayers () {
        return allSessions.size();
    }

}
