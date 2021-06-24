package model;

import game.AttackAction;
import game.GuardAction;
import game.MoveAction;
import game.Octopus;
import game.model.ActionGenerator;
import game.model.Helmet;
import game.model.HelmetEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import views.GameWindow;

import java.awt.*;
import java.util.ArrayList;

import static Util.Utility.*;

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
        Helmet helmet = new Helmet(choiceRandom(HelmetEnum.values()));

        ActionGenerator actionGenerator = oct -> {
            int random = random(0, 300);
            if (random < 10) {
                return new AttackAction(octopusEnemies);
            } else if (random < 20) {
                return new GuardAction(helmet);
            }
            return new MoveAction();
        };



        if(a) {
            octopus = new Octopus(actionGenerator, health,100, 500);
            a = false;
        } else {
            octopus = new Octopus(actionGenerator, health,500, 500);
            octopus.getAcceleration().x = -0.01f;
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
