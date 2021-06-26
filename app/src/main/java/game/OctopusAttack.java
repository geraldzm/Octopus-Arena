package game;

import game.model.Arm;
import game.model.OctopusAction;
import game.model.PApplet;
import game.model.PVector;

import java.awt.*;
import java.util.ArrayList;

public class OctopusAttack extends OctopusAction {

    private int counter;
    private final Arm[] arms;
    private Double damage;

    public OctopusAttack(Octopus octopus, ArrayList<Octopus> enemies) {
        super(-1, -1, octopus);

        setInFrontOfOctopus(false);

        arms = new Arm[8];
        damage = 10d;

        for (int i = 0; i < arms.length; i++) {
            PVector acceleration = PVector.fromAngle(PApplet.radians(45 * i));
            acceleration.mult(0.3f);
            arms[i] = new Arm(octopus.getPosition(), acceleration, enemies, damage);
        }

    }

    @Override
    public void render(Graphics g) {

        for (int i = 0; i < arms.length; i++) {
            arms[i].render(g);
        }

    }

    @Override
    public void tick() {

        for (int i = 0; i < arms.length; i++) {
            arms[i].tick();
        }

        counter++;
        if(counter == 40) setRunning(false);
    }

    @Override
    public void startAction() {
        setRunning(true);
        counter = 0;

        damage = getOctopus().getHealthBar().getHealth() * (-5d / 99d) + 15.0505050505;

    }

}
