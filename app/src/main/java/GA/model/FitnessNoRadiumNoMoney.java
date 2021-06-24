package GA.model;

import game.model.PVector;

import static java.lang.Math.abs;

public class FitnessNoRadiumNoMoney implements Fitness {

    @Override
    public double fitOf(GAContext c) {

        // ---------------------- Variables ----------------------

        double e0 = c.energyNE - c.energy + abs(c.energyNE - c.energy);
        double e1 = c.energy - c.energyNE + abs(c.energy - c.energyNE);

        double dist = c.position.dist(c.positionNE);

        double d0 = 160 - dist + abs(160 - dist);
        double d1 = dist - 160 + abs(dist - 160);

        int a0 =  c.chromosome % 100;
        float a1 = PVector.angleBetween(c.position, c.positionNE);

        // ------------------------------------------------------

        double x2 = -0.000001 * c.chromosome * c.chromosome;

        // (Attack):
        double attack = x2 + 0.086767 * c.chromosome - 1827.6121;

        // (Guard):
        double guard = x2 + 0.116303 * c.chromosome - 3327.08088;

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
