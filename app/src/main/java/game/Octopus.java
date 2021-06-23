package game;

import game.model.Action;
import game.model.ActionGenerator;
import game.model.GameObject;
import game.model.OctopusAction;

import java.awt.*;

public class Octopus extends GameObject {

    private ActionGenerator actionGenerator;
    private OctopusAction octopusAction;
    private HealthBar health;

    public Octopus(ActionGenerator actionGenerator, double health, int x, int y) {
        super(99, 90);
        setImage("/images/octopusImageSmoll.png");
        position.x = x;
        position.y = y;
        acceleration.x = 0.1f;
        this.health = new HealthBar(health, position);
        this.actionGenerator = actionGenerator;
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

}
