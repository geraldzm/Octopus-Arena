package model;

import lombok.Getter;
import java.io.Serializable;

@Getter
public enum TimeZones implements Serializable {
    EST(1), PST(2), CST(3), MST(4);
    private int timezoneNumber;

    TimeZones(int i){
        this.timezoneNumber = i;
    }
}
