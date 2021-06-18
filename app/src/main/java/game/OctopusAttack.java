package game;

import game.model.OctopusAction;

import java.awt.*;

public class OctopusAttack extends OctopusAction {

    public OctopusAttack() {
        super(-1, -1);
    }

    @Override
    public void render(Graphics g) {

    }

    @Override
    public void tick() {

    }

    @Override
    public void startAction() {
        setRunning(true);
    }

}
