package game;

import game.model.Helmet;
import game.model.OctopusAction;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class OctopusHelmet extends OctopusAction {

    private final Helmet helmet;

    public OctopusHelmet(Helmet helmet, Octopus octopus) {
        super(50, 50, octopus);

        this.helmet = helmet;
        this.helmet.setOctopusPosition(getOctopus().getPosition());

        setInFrontOfOctopus(true);
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

        //
        double resistence = getOctopus().getHealthBar().getHealth();
        resistence = resistence *  (-10d/33d) + 80.303030303030d; //

        getOctopus().setResistance(resistence / 100);

        // set a timer to stop the action
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                setRunning(false);
            }
        }, 1000);  // 5s

    }

}
