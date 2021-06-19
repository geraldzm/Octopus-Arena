package game;

import game.model.Action;
import game.model.Helmet;

public class GuardAction extends Action {

    private final Helmet helmet;

    public GuardAction(Helmet helmet){
        this.helmet = helmet;
    }

    @Override
    public void execute(Octopus octopus) {
        octopus.setOctopusAction(new OctopusHelmet(helmet));
    }

}
