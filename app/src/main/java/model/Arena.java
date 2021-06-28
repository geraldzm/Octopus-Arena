package model;

import Logic.GameSession;
import Logic.TimerManager;
import Util.KeyFactory;
import Util.Utility;
import lombok.Getter;
import lombok.Setter;

import java.security.Key;
import java.security.KeyPair;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

@Getter
@Setter
public class Arena extends Observable<Observer<ArenaInformation>> implements ChronometerTick {

    private Integer arenaNumber;
    private Double fee;
    private Integer octopusAmount;
    private Timer timer;
    private boolean isStarted, isFull, closed;
    private Chronometer chronometer;

    private TimeZones timeZone;
    private Integer experience;
    private Double minimumBet;
    private Double maximumBet;

    private GameSession gameSession;

    private static SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss.SSS");

    private HashMap<Session, KeyPair> acceptedSessions;

    public Arena(int arenaNumber, int octopusAmount) {

        this.arenaNumber = arenaNumber;
        isStarted = false;
        closed = false;
        timer = new Timer();
        setUpTimer();

        System.out.println("Setting "  + octopusAmount);
        this.octopusAmount = octopusAmount;
        gameSession = new GameSession(octopusAmount);

        acceptedSessions = new HashMap<>();
    }

    private void setUpTimer() {

        chronometer = new Chronometer();
        TimerTask timerTask = TimerManager.getTimerPerTwoHours(chronometer, this);
        timer.schedule(timerTask, 10, 1000);

    }

    @Override
    public void register(Observer<ArenaInformation> observable) {
        super.register(observable);
        setMessage();
    }

    private void startArena() {

        closed = true;

        if(isReady()) {
            System.out.println("arena started");
            gameSession.initGame();
        } else {
            System.out.println("Arena closed");
            gameSession.cancel();
            gameSession = null;
        }

    }

    public synchronized Session generateSession() {

        if(octopusAmount > gameSession.getAmountOfCurrentPlayers()) {

            Session session = new Session();
            KeyPair keyPair = KeyFactory.getRSAKeys();
            session.setPublicKey(keyPair.getPublic());
            acceptedSessions.put(session, keyPair);

            gameSession.registerSession(session);

            return session;
        }

        return null;
    }

    public synchronized void setUserData(Session session, UserPlayer userPlayer) {

        KeyPair keyPair = acceptedSessions.get(session);
        String bet = KeyFactory.do_RSADecryption(userPlayer.BetEncoded, keyPair.getPrivate());
        String health = KeyFactory.do_RSADecryption(userPlayer.healthEncoded, keyPair.getPrivate());

        session.initSession(session.getUser(), Double.parseDouble(bet), (int) Double.parseDouble(health));

    }

    @Override
    public void chronometerTick(long time) {

        if(time != -1) {

            setMessage();

        } else { // chronometer finished
            isStarted = true;
            timer.cancel();
            timer.purge();
            setMessage();
            startArena();
        }

    }

    private void setMessage() {
        Arena.super.notifyAll(o -> o.update(new ArenaInformation(arenaNumber, fee, octopusAmount, chronometer.getLastTime(), isStarted, minimumBet, maximumBet)));
    }

    public void unRegisterUserToArina(Session session) {
        gameSession.onSessionDisconnected(session);
    }

    public boolean isReady() {
        return gameSession.isReady();
    }
}
