package game;

import game.model.Action;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EscapeAction extends Action {

    private final Octopus enemy;

    @Override
    public void execute(Octopus octopus) {
        octopus.setOctopusAction(new OctopusEscape(octopus, enemy));
    }

}
