package Logic;

import model.Chronometer;
import model.ChronometerTick;
import model.Constants;

import java.util.Date;
import java.util.TimerTask;

public class TimerManager {


    public static TimerTask getTimerPerTwoHours(Chronometer chronometer, ChronometerTick tick) {

        long startTime = (Constants.DAY / 12) + new Date().getTime(); // every 2h
        chronometer.start(startTime);

        return new TimerTask() {

            @Override
            public void run() {

                long time = new Date().getTime();
                long l = startTime - time;

                if(l > 0) {
                    chronometer.tickChronometer(time);
                    tick.chronometerTick(l);
                } else {
                    tick.chronometerTick(-1L);
                }

            }

        };

    }


}
