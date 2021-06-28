package model;

import Logic.GameSession;
import game.model.UserFinalPosition;

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

    public ArrayList<UserFinalPosition> finalPositions; // in order

}
