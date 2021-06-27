package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;

@Getter
@AllArgsConstructor
public class User {

    private String nickname;
    private Integer experience;
    private Double money;

    private ArrayList<Arena> arenas;

    public User(String nickname, Integer experience, Double money) {
        this.nickname = nickname;
        this.experience = experience;
        this.money = money;
        arenas = new ArrayList<>();
    }


}