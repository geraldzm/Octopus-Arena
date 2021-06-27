package model;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements Serializable {

    private String nickname;
    private Integer experience;
    private Double money;
    private Double minimumBet;
    private Double maximumBet;
    private Integer amountOctopi;
    private TimeZones timeZone;

    private transient ArrayList<Arena> arenas;

    public User(String nickname, Integer experience, Double money) {
        this.nickname = nickname;
        this.experience = experience;
        this.money = money;
        arenas = new ArrayList<>();
    }


}