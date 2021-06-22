package game.model;

import game.Octopus;

@FunctionalInterface
public interface ActionGenerator {

    Action getAction(Octopus octopus);

}
