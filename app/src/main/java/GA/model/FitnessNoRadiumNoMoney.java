package GA.model;

import game.model.PVector;

import static java.lang.Math.*;

public class FitnessNoRadiumNoMoney implements Fitness {

    @Override
    public double fitOf(double energy,
                        double energyNE,
                        PVector position,
                        PVector positionNE,
                        PVector center,
                        double radium,
                        int genotype) {

        // ---------------------- Variables ----------------------
        double e0 = energyNE - energy + abs(energyNE - energy);
        double e1 = energy - energyNE + abs(energy - energyNE);

        double dist = position.dist(positionNE);

        double d0 = 160 - dist + abs(160 - dist);
        double d1 = dist - 160 + abs(dist - 160);

        int a0 =  genotype % 100;
        float a1 = PVector.angleBetween(position, positionNE);

        // ------------------------------------------------------

        double x2 = -0.000001 * genotype * genotype;

        // (Attack):
        double attack = x2 + 0.086767 * genotype - 1827.6121;

        // (Guard):
        double guard = x2 + 0.116303 * genotype - 3327.08088;

        // (move):
            // (Chase):
        double z0 = -0.00154321 * Math.pow(a0 - a1, 2) + 200;
            // (run):
        double z1 = -0.00154321 * Math.pow(((a0 + 180) % 360) - a1, 2) + 200 ;

        double move = e1 * z0 + e0 * z1;

        // ------------------------------------------------------

//        d1 * (Move)
//        +
//        d0 * e0 * (Guard)
//        +
//        d0 * e1 * (Attack)

        double fit = d1 * move + d0 * e0 * guard + d0 * e1 * attack;

        return fit;
    }


}
