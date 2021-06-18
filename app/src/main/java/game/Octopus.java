package game;

import game.model.Action;
import game.model.ActionGenerator;
import game.model.GameObject;
import game.model.OctopusAction;

import java.awt.*;

public class Octopus extends GameObject {

    private ActionGenerator actionGenerator;
    private OctopusAction octopusAction;
    private double health;

    public Octopus(ActionGenerator actionGenerator, double health) {
        super(99, 90);
        setImage("/images/octopusImageSmoll.png");

        position.x = 100;
        position.y = 500;
        acceleration.x = 0.1f;
        this.health = health;

        this.actionGenerator = actionGenerator;
    }

    @Override
    public void render(Graphics g) {
        super.render(g);

        if(octopusAction != null)
            octopusAction.render(g);

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
        this.octopusAction.setOctopus(this);
        this.octopusAction.startAction();
    }

}
