package GA.model;

import game.model.PVector;

@FunctionalInterface
public interface Fitness {

    double fitOf(GAContext c
                 );

}
