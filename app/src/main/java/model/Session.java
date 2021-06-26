package model;

import GA.GAAlgorithm;
import game.Octopus;
import game.model.ActionGenerator;
import game.model.BorderHandler;
import game.model.PVector;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import views.GameWindow;

import java.awt.*;
import java.util.ArrayList;

@Setter
@Getter
@AllArgsConstructor
public class Session extends Observable<Observer<Session>> implements Updatable {

    private GameWindow gameWindow;
    private User user;
    private Double toBet;
    private Integer health;
    private Octopus octopus;
    private ArrayList<Octopus> octopusEnemies;

    public Session(GameWindow gameWindow, User user, Double toBet, Integer health) {
        this.gameWindow = gameWindow;
        this.user = user;
        this.toBet = toBet;
        this.health = health;

        octopusEnemies = new ArrayList<>();

        ActionGenerator actionGenerator = new GAAlgorithm(octopusEnemies);
        BorderHandler borderHandler = new BorderHandler(new PVector(500, 500), 420);

        if(a) {
            octopus = new Octopus(actionGenerator, borderHandler, health,600, 500);
            a = false;
        } else {
            octopus = new Octopus(actionGenerator, borderHandler, health,200, 500);
        }

    }

    public static boolean a = true;

    @Override
    public Graphics getUpdatableGraphics() {
        return gameWindow.getCanvas().getGraphics();
    }

    @Override
    public void update() {
        gameWindow.repaint();
    }

    public void disconnect() {
        notifyAll(sessionObserver -> sessionObserver.update(this));
    }

    public void initGame(ArrayList<Octopus> octopusArrayList) {

        this.octopusEnemies.addAll(octopusArrayList);
        this.octopusEnemies.remove(this.octopus);

    }

}
