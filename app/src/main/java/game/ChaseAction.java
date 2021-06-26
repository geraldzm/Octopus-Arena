package game;

import game.model.Action;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ChaseAction extends Action {

    private final Octopus enemy;

    @Override
    public void execute(Octopus octopus) {
        octopus.setOctopusAction(new OctopusChase(octopus, enemy));
    }

}
