package model;

import lombok.Getter;

@Getter
public class Chronometer {

    private long finishTime;
    private String lastTime;

    public void start(long startTime) {
        finishTime = startTime;
        lastTime = "00:00:01";
    }

    public String tickChronometer (long currentTime) {
        long time = finishTime - currentTime;
        int h   = (int)(time /3600000);
        int m = (int)(time - h*3600000)/60000;
        int s= (int)(time - h*3600000- m*60000)/1000 ;
        lastTime =  (h < 10 ? "0"+h: h)+":"+(m < 10 ? "0"+m: m)+":"+ (s < 10 ? "0"+s: s);
        return lastTime;
    }

}
