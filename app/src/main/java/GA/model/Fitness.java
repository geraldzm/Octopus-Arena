package GA.model;

import game.model.PVector;

@FunctionalInterface
public interface Fitness {

    double fitOf(double energy,
                 double energyNE,
                 PVector position,
                 PVector positionNE,
                 PVector center,
                 double radium,
                 int genotype
                 );

}
