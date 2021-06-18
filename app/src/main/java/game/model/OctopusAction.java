package game.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class OctopusAction extends GameObject{

    private boolean isRunning;

    public OctopusAction(int width, int height) {
        super(width, height);
        isRunning = true;
    }

}
