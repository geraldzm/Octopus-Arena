package GA.model;

import game.model.PConstants;
import game.model.PVector;

public class FitnessWithVectors implements Fitness {

    @Override
    public double fitOf(GAContext c) {

        float distY = c.position.dist(c.positionNE);
        float energyX = (float) (c.energy - c.energyNE);

        PVector vector = new PVector(energyX, distY);
        float bestAngle = vector.heading();

        return 1 - (Math.abs(bestAngle - c.phenotype) / PConstants.TWO_PI); // 0 - 1
    }

}
