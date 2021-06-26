package game;

import game.model.OctopusAction;
import game.model.PVector;

public class OctopusEscape extends OctopusAction {

    private int counter;
    private Octopus enemy;

    public OctopusEscape(Octopus octopus, Octopus enemy) {
        super(0, 0, octopus);
        counter = 0;
        this.enemy = enemy;
    }

    @Override
    public void tick() {

        PVector copy = enemy.getPosition().copy();
        copy.sub(getOctopus().getPosition());
        copy.normalize();
        copy.mult(-0.3f);

        getOctopus().getAcceleration().set(copy);

        getOctopus().move();

        counter++;
        if(counter == 40) setRunning(false);
    }

    @Override
    public void startAction() {
        setRunning(true);
        counter = 0;

        float velocity = (float) (getOctopus().getHealthBar().getHealth() * (0.5 / -99) + 149d/99d);

        getOctopus().getMaxVelocity().x = velocity;
        getOctopus().getMaxVelocity().y = velocity;
    }

}
