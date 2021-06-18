package game.model;

import game.Octopus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class OctopusAction extends GameObject{

    private boolean isRunning;
    private Octopus octopus;

    public OctopusAction(int width, int height) {
        super(width, height);
        isRunning = true;
    }

    public abstract void startAction();

}
