package model;

import Logic.GameSession;
import Logic.TimerManager;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

@Getter
@Setter
public class Arena extends Observable<Observer<ArenaInformation>> implements ChronometerTick {

    private Integer arenaNumber;
    private Double fee;
    private Integer octopusAmount;
    private Timer timer;
    private boolean isStarted, isFull;
    private Chronometer chronometer;
    private GameSession gameSession;

    private static SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss.SSS");

    public Arena(int arenaNumber, int octopusAmount) {

        this.arenaNumber = arenaNumber;
        isStarted = false;
        timer = new Timer();
        setUpTimer();

        this.octopusAmount = octopusAmount;
        gameSession = new GameSession(octopusAmount);

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

        if(gameSession.isReady()) {
            System.out.println("arena started");
            gameSession.initGame();
        } else {
            System.out.println("Arena closed");
            gameSession.cancel();
            gameSession = null;
        }

    }

    public boolean registerUserToArina(UserPlayer userPlayer) {

       // gameSession.registerSession();

        return false;
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
        Arena.super.notifyAll(o -> o.update(new ArenaInformation(arenaNumber, fee, octopusAmount, chronometer.getLastTime(), isStarted)));
    }

}
