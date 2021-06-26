package game;

import game.model.Action;
import game.model.PVector;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ChaseAction extends Action {

    private final Octopus enemy;

    @Override
    public void execute(Octopus octopus) {

        PVector copy = enemy.getPosition().copy();
        copy.sub(octopus.getPosition());
        copy.normalize();
        copy.mult(0.3f);

        octopus.getAcceleration().set(copy);

        octopus.move();

    }

}
