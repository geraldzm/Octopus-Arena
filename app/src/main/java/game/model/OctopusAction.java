package game.model;

import game.Octopus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class OctopusAction extends GameObject{

    private boolean isRunning, isInFrontOfOctopus;
    private Octopus octopus;

    public OctopusAction(int width, int height, Octopus octopus) {
        super(width, height);
        isRunning = true;
        this.octopus = octopus;
    }

    public abstract void startAction();

}
