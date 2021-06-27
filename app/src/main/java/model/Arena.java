package model;

import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

@Getter
@Setter
public class Arena extends Observable<Observer<ArenaInformation>> {

    private Integer arenaNumber;
    private Double fee;
    private Integer octopusAmount;
    private Timer timer;
    private String startTime;
    private boolean isStarted;
    private Chronometer chronometer;


    private static SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss.SSS");

    public Arena(int arenaNumber) {

        this.arenaNumber = arenaNumber;
        isStarted = false;
        timer = new Timer();
        setUpTimer();

    }

    private void setUpTimer() {

        System.out.println("setting up timer");

        long startTime = (Constants.DAY / 6) + new Date().getTime();

        chronometer = new Chronometer();
        chronometer.start(startTime);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                long time = new Date().getTime();
                long l = startTime - time;

                if(l < 0) {
                    System.out.println("Cancel");
                    timer.cancel();
                    timer.purge();
                    isStarted = true;
                    setMessage();
                    return;
                }

                Arena.this.startTime = fmt.format(l);
                chronometer.tickChronometer(time);
                setMessage();
            }
        }, 10, 1000);

    }

    @Override
    public void register(Observer<ArenaInformation> observable) {
        super.register(observable);
        setMessage();
    }

    private void setMessage() {
        Arena.super.notifyAll(o -> o.update(new ArenaInformation(arenaNumber, fee, octopusAmount, chronometer.getLastTime(), isStarted)));
    }


}
