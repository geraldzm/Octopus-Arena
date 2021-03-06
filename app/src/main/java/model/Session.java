package model;

import GA.GAAlgorithm;
import Logic.GameSession;
import Util.Utility;
import game.Octopus;
import game.model.ActionGenerator;
import game.model.BorderHandler;
import game.model.PVector;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import views.GameWindow;
import views.WindowBuilder;
import views.WindowID;

import java.awt.*;
import java.security.PublicKey;
import java.util.ArrayList;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Session extends Observable<Observer<Session>> implements Updatable {

    private GameWindow gameWindow;
    private User user;
    private Double toBet;
    private Integer health;
    private Octopus octopus;
    private ArrayList<Octopus> octopusEnemies;
    private PublicKey publicKey;

    public Session(User user, Double toBet, Integer health) {
        initSession(user, toBet, health);
    }

    public void initSession(User user, Double toBet, Integer health) {
        this.user = user;
        this.toBet = toBet;
        this.health = health;

        octopusEnemies = new ArrayList<>();

        ActionGenerator actionGenerator = new GAAlgorithm(octopusEnemies);
        BorderHandler borderHandler = new BorderHandler(new PVector(500, 500), 420);

        int x = Utility.random(100, 700);
        int y = Utility.random(100, 700);
        octopus = new Octopus(actionGenerator, borderHandler, health,x, y);
    }

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

        ContextNode context = new ContextNode();
        context.session = this;


        WindowBuilder.buildWindowAndShow(context, WindowID.GAME);
        try{
            Thread.sleep(100);
        } catch (Exception e){
            e.printStackTrace();
        }

     //   this.gameWindow = gameWindow;

    }

    public void setUserColor(Color color) {
        octopus.setColor(color);
    }

}
