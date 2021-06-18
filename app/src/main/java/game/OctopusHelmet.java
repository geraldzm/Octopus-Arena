package game;

import game.model.OctopusAction;
import game.model.PVector;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class OctopusHelmet extends OctopusAction {


    public OctopusHelmet() {
        super(50, 50);
    }

    @Override
    public void render(Graphics g) {
        super.render(g);

        PVector position = getOctopus().getPosition();
        g.fillRect((int)position.x + 20, (int) position.y, 60,20);

    }

    @Override
    public void tick() {

    }

    @Override
    public void startAction() {
        setRunning(true);
        System.out.println("Guard start bitches");

        // set a timer to stop the action
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                setRunning(false);
                System.out.println("Guard down");
            }
        }, 5000);  // 5s

    }

}
