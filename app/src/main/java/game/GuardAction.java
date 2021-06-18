package game;

import game.model.Action;

public class GuardAction extends Action {
    @Override
    public void execute(Octopus octopus) {
        octopus.setOctopusAction(new OctopusHelmet());
    }
}
