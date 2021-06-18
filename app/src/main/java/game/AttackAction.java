package game;

import game.model.Action;

public class AttackAction extends Action {
    @Override
    public void execute(Octopus octopus) {
        octopus.setOctopusAction(new OctopusAttack());
    }
}
