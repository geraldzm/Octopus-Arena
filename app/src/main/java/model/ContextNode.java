package model;

import Logic.GameSession;

import java.util.ArrayList;

public class ContextNode {

    public User user;
    public Double toBet;
    public Integer health;

    public Arena arena;
    public GameSession gameSession;
    public Session session;
    public Integer arenaIndex;

    public ArenaBuilder arenaBuilder;

    public ArrayList<UserPlayer> scoreUsers; // in order

}
