package game;

import game.model.Arm;
import game.model.OctopusAction;
import game.model.PApplet;
import game.model.PVector;

import java.awt.*;

public class OctopusAttack extends OctopusAction {

    int counter = 0;
    Arm arms[];

    public OctopusAttack(Octopus octopus) {
        super(-1, -1, octopus);

        setInFrontOfOctopus(false);

        arms = new Arm[]{
                new Arm(octopus.getPosition(), PVector.fromAngle(PApplet.radians(0))),
                new Arm(octopus.getPosition(), PVector.fromAngle(PApplet.radians(45))),
                new Arm(octopus.getPosition(), PVector.fromAngle(PApplet.radians(90))),
                new Arm(octopus.getPosition(), PVector.fromAngle(PApplet.radians(135))),
                new Arm(octopus.getPosition(), PVector.fromAngle(PApplet.radians(180))),
                new Arm(octopus.getPosition(), PVector.fromAngle(PApplet.radians(225))),
                new Arm(octopus.getPosition(), PVector.fromAngle(PApplet.radians(270))),
                new Arm(octopus.getPosition(), PVector.fromAngle(PApplet.radians(315))),
                new Arm(octopus.getPosition(), PVector.fromAngle(PApplet.radians(360)))
        };

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
        if(counter == 50) setRunning(false);
    }

    @Override
    public void startAction() {
        setRunning(true);
    }

}
