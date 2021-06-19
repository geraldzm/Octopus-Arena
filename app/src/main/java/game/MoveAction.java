package game;

import game.model.Action;

public class MoveAction extends Action {

    @Override
    public void execute(Octopus octopus) {

        octopus.move();

    }

}
