package game;

import game.model.Helmet;
import game.model.OctopusAction;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class OctopusHelmet extends OctopusAction {

    private Helmet helmet;

    public OctopusHelmet(Helmet helmet) {
        super(50, 50);
        this.helmet = helmet;
    }

    @Override
    public void render(Graphics g) {
        helmet.render(g);
    }

    @Override
    public void tick() {

    }

    @Override
    public void startAction() {
        setRunning(true);

        // set a timer to stop the action
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                setRunning(false);
            }
        }, 5000);  // 5s

    }

    @Override
    public void setOctopus(Octopus octopus) {
        super.setOctopus(octopus);
        helmet.setOctopusPosition(getOctopus().getPosition());
    }
}
