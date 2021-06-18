package game;

import game.model.Action;

public class MoveAction extends Action {

    @Override
    public void execute(Octopus octopus) {

        octopus.getVelocity().add(octopus.getAcceleration());
        octopus.getVelocity().limit(octopus.getMaxVelocity().mag());
        octopus.getPosition().add(octopus.getVelocity());

    }

}
