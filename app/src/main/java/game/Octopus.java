package game;

import game.model.*;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

@Getter
@Setter
public class Octopus extends GameObject {

    private ActionGenerator actionGenerator;
    private OctopusAction octopusAction;
    private HealthBar health;
    private ArrayList<Octopus> enemies;
    private double resistance;
    private BorderHandler borderHandler;

    public Octopus(ActionGenerator actionGenerator, BorderHandler borderHandler, double health, int x, int y) {
        super(99, 90);
        setImage("/images/octopusImageSmoll.png");
        position.x = x;
        position.y = y;
        acceleration.x = 0.1f;
        this.health = new HealthBar(health, position);
        this.actionGenerator = actionGenerator;
        this.resistance = 1;
        this.borderHandler = borderHandler;
    }

    @Override
    public void render(Graphics g) {


        health.render(g);

        if(octopusAction != null)
            if(octopusAction.isInFrontOfOctopus()) {
                super.render(g);
                octopusAction.render(g);
            } else {
                octopusAction.render(g);
                super.render(g);
            }
        else
            super.render(g);

    }

    @Override
    public void tick() {

        if(health.getHealth() == 0) return;

        if(octopusAction == null) {

            // Create a new action and start it
            Action action = actionGenerator.getAction(this);
            action.execute(this);

        } else {

            // execute the existent action
            octopusAction.tick();
            if(!octopusAction.isRunning()) // if it's finished
                octopusAction = null;
        }

    }

    public void setOctopusAction(OctopusAction octopusAction) {
        this.octopusAction = octopusAction;
        this.octopusAction.startAction();
    }

    public void takeDamage(double damage) {
        damage *= resistance;
        health.reduceHealth(damage);

        if(health.getHealth() == 0) {
            setImage("/images/skeleton.png");
        }
    }

    public boolean isDead() {
        return health.getHealth() == 0;
    }

    public double getEnergy() {
        return health.getHealth();
    }

    @Override
    public void move() {
        super.move();
        hitBox = new Rectangle2D.Double((int)position.x, (int)position.y, hitBox.getWidth(), hitBox.getHeight());
        borderHandler.clampMovement(position, hitBox);
    }

}
