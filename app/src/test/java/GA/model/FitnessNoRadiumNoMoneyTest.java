package GA.model;

import game.model.PVector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FitnessNoRadiumNoMoneyTest {

    int toTest = 1000;


    @Test
    void fitOfAttack() {

        Fitness fitness = new FitnessNoRadiumNoMoney();

        PVector position = new PVector(10, 10);
        PVector positionNE = new PVector(10, 10);

        PVector center = new PVector(100, 100);

        double energyNE = 50;
        double energy = 100;

        double radius = 0;

        // ---------------------------------------

        for (int i = 0; i < toTest; i++) {

            int attackGen = (int) ((Math.random() * 14768) + 36000);
            assertTrue(attackGen >= 36000 && attackGen <= 50767);

            int moveGen =  (int) (Math.random() * 35999);
            assertTrue(moveGen >= 0 && moveGen <= 36000);

            int guardGen = (int) ((Math.random() * 14768) + 50768);
            assertTrue(guardGen >= 50768 && guardGen <= 65535);

            double fitAttack = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, attackGen);
            double fitMove = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, moveGen);
            double fitGuard = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, guardGen);

            assertTrue(fitAttack > fitMove);
            assertTrue(fitAttack > fitGuard);
        }


    }

}