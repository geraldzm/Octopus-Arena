package game;

import game.model.Action;
import game.model.Helmet;

public class GuardAction extends Action {

    private Helmet currentHelmet;
    public GuardAction(Helmet helmet){
        currentHelmet = helmet;
    }

    @Override
    public void execute(Octopus octopus) {
        octopus.setOctopusAction(new OctopusHelmet(currentHelmet));
    }
}
