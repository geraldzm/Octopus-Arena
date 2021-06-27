package model;

import lombok.*;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    private String nickname;
    private Integer experience;
    private Double money;

    private ArrayList<Arena> arenas;

    public User(String nickname, Integer experience, Double money) {
        this.nickname = nickname;
        this.experience = experience;
        this.money = money;
    }


}