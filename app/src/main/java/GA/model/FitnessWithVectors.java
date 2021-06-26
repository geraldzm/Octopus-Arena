package GA.model;

import game.model.PConstants;
import game.model.PVector;

public class FitnessWithVectors implements Fitness {

    @Override
    public double fitOf(GAContext c) {

        float distY = (float) (c.energy - c.energyNE);
        float energyX = c.position.dist(c.positionNE) - 110;

        PVector vector = new PVector(energyX, distY);
        float bestAngle = vector.heading2D();


        return 1 - (Math.abs(bestAngle - c.phenotype) / PConstants.TWO_PI); // 0 - 1
    }

}
