package GA.model;

import game.model.PVector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FitnessNoRadiumNoMoneyTest {

    int toTest = 10000;
    int attackGen;
    int guardGen;
    int moveGen;

    @Test
    void fitOfAttack() {
        Fitness fitness = new FitnessNoRadiumNoMoney();
        PVector position = new PVector(10, 10);
        PVector positionNE = new PVector(10, 10);
        PVector center = new PVector(100, 100);
        double energyNE = 50;
        double energy = 100;
        double radius = 0;
        for (int i = 0; i < toTest; i++) {
            generateRandomGenes();
            double fitAttack = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, attackGen);
            double fitMove = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, moveGen);
            double fitGuard = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, guardGen);
            assertTrue(fitAttack > fitMove);
            assertTrue(fitAttack > fitGuard);
        }
    }

    @Test
    void fitOfAttack1(){
        Fitness fitness = new FitnessNoRadiumNoMoney();
        PVector position = new PVector(10, 10);
        PVector positionNE = new PVector(169, 10);
        PVector center = new PVector(100, 100);
        double energyNE = 90;
        double energy = 100;
        double radius = 0;
        for (int i = 0; i < toTest; i++) {
            generateRandomGenes();
            double fitAttack = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, attackGen);
            double fitMove = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, moveGen);
            double fitGuard = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, guardGen);
            assertTrue(fitAttack > fitMove);
            assertTrue(fitAttack > fitGuard);
        }
    }
    @Test
    void fitOfAttack2(){
        Fitness fitness = new FitnessNoRadiumNoMoney();
        PVector position = new PVector(100, 100);
        PVector positionNE = new PVector(69, 20);
        PVector center = new PVector(100, 100);
        double energyNE = 50;
        double energy = 50;
        double radius = 0;
        for (int i = 0; i < toTest; i++) {
            generateRandomGenes();
            double fitAttack = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, attackGen);
            double fitMove = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, moveGen);
            double fitGuard = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, guardGen);
            assertTrue(fitAttack > fitMove);
            assertTrue(fitAttack > fitGuard);
        }
    }

    @Test
    void fitOfAttack3(){
        Fitness fitness = new FitnessNoRadiumNoMoney();
        PVector position = new PVector(101, 10);
        PVector positionNE = new PVector(169, 110);
        PVector center = new PVector(100, 100);
        double energyNE = 90;
        double energy = 10;
        double radius = 0;
        for (int i = 0; i < toTest; i++) {
            generateRandomGenes();
            double fitAttack = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, attackGen);
            double fitMove = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, moveGen);
            double fitGuard = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, guardGen);
            assertTrue(fitAttack > fitMove);
            assertTrue(fitAttack > fitGuard);
        }
    }

    @Test
    void fitOfAttack4(){
        Fitness fitness = new FitnessNoRadiumNoMoney();
        PVector position = new PVector(100, 10);
        PVector positionNE = new PVector(12, 110);
        PVector center = new PVector(100, 100);
        double energyNE = 10;
        double energy = 100;
        double radius = 0;
        for (int i = 0; i < toTest; i++) {
            generateRandomGenes();
            double fitAttack = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, attackGen);
            double fitMove = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, moveGen);
            double fitGuard = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, guardGen);
            assertTrue(fitAttack > fitMove);
            assertTrue(fitAttack > fitGuard);
        }
    }

    @Test
    void fitOfAttack5(){
        Fitness fitness = new FitnessNoRadiumNoMoney();
        PVector position = new PVector(30, 10);
        PVector positionNE = new PVector(109, 10);
        PVector center = new PVector(100, 100);
        double energyNE = 50;
        double energy = 80;
        double radius = 0;
        for (int i = 0; i < toTest; i++) {
            generateRandomGenes();
            double fitAttack = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, attackGen);
            double fitMove = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, moveGen);
            double fitGuard = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, guardGen);
            assertTrue(fitAttack > fitMove);
            assertTrue(fitAttack > fitGuard);
        }
    }

    @Test
    void fitOfAttack6(){
        Fitness fitness = new FitnessNoRadiumNoMoney();
        PVector position = new PVector(30, 10);
        PVector positionNE = new PVector(40, 40);
        PVector center = new PVector(100, 100);
        double energyNE = 50;
        double energy = 51;
        double radius = 0;
        for (int i = 0; i < toTest; i++) {
            generateRandomGenes();
            double fitAttack = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, attackGen);
            double fitMove = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, moveGen);
            double fitGuard = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, guardGen);
            assertTrue(fitAttack > fitMove);
            assertTrue(fitAttack > fitGuard);
        }
    }

    @Test
    void fitOfDefend1(){
        Fitness fitness = new FitnessNoRadiumNoMoney();
        PVector position = new PVector(10, 10);
        PVector positionNE = new PVector(169, 10);
        PVector center = new PVector(100, 100);
        double energyNE = 90;
        double energy = 100;
        double radius = 0;
        for (int i = 0; i < toTest; i++) {
            generateRandomGenes();
            double fitAttack = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, attackGen);
            double fitMove = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, moveGen);
            double fitGuard = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, guardGen);
            assertTrue(fitGuard > fitMove);
            assertTrue(fitGuard > fitAttack);
        }
    }
    @Test
    void fitOfDefend2(){
        Fitness fitness = new FitnessNoRadiumNoMoney();
        PVector position = new PVector(100, 100);
        PVector positionNE = new PVector(69, 20);
        PVector center = new PVector(100, 100);
        double energyNE = 50;
        double energy = 50;
        double radius = 0;
        for (int i = 0; i < toTest; i++) {
            generateRandomGenes();
            double fitAttack = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, attackGen);
            double fitMove = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, moveGen);
            double fitGuard = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, guardGen);
            assertTrue(fitGuard > fitMove);
            assertTrue(fitGuard > fitAttack);
        }
    }

    @Test
    void fitOfDefend3(){
        Fitness fitness = new FitnessNoRadiumNoMoney();
        PVector position = new PVector(101, 10);
        PVector positionNE = new PVector(169, 110);
        PVector center = new PVector(100, 100);
        double energyNE = 90;
        double energy = 10;
        double radius = 0;
        for (int i = 0; i < toTest; i++) {
            generateRandomGenes();
            double fitAttack = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, attackGen);
            double fitMove = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, moveGen);
            double fitGuard = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, guardGen);
            assertTrue(fitGuard > fitMove);
            assertTrue(fitGuard > fitAttack);
        }
    }

    @Test
    void fitOfDefend4(){
        Fitness fitness = new FitnessNoRadiumNoMoney();
        PVector position = new PVector(100, 10);
        PVector positionNE = new PVector(12, 110);
        PVector center = new PVector(100, 100);
        double energyNE = 10;
        double energy = 100;
        double radius = 0;
        for (int i = 0; i < toTest; i++) {
            generateRandomGenes();
            double fitAttack = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, attackGen);
            double fitMove = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, moveGen);
            double fitGuard = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, guardGen);
            assertTrue(fitGuard > fitMove);
            assertTrue(fitGuard > fitAttack);
        }
    }

    @Test
    void fitOfDefend5(){
        Fitness fitness = new FitnessNoRadiumNoMoney();
        PVector position = new PVector(30, 10);
        PVector positionNE = new PVector(109, 10);
        PVector center = new PVector(100, 100);
        double energyNE = 50;
        double energy = 80;
        double radius = 0;
        for (int i = 0; i < toTest; i++) {
            generateRandomGenes();
            double fitAttack = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, attackGen);
            double fitMove = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, moveGen);
            double fitGuard = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, guardGen);
            assertTrue(fitGuard > fitMove);
            assertTrue(fitGuard > fitAttack);
        }
    }

    @Test
    void fitOfDefend6(){
        Fitness fitness = new FitnessNoRadiumNoMoney();
        PVector position = new PVector(30, 10);
        PVector positionNE = new PVector(40, 40);
        PVector center = new PVector(100, 100);
        double energyNE = 50;
        double energy = 51;
        double radius = 0;
        for (int i = 0; i < toTest; i++) {
            generateRandomGenes();
            double fitAttack = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, attackGen);
            double fitMove = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, moveGen);
            double fitGuard = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, guardGen);
            assertTrue(fitGuard > fitMove);
            assertTrue(fitGuard > fitAttack);
        }
    }


    @Test
    void fitOfMove1(){
        Fitness fitness = new FitnessNoRadiumNoMoney();
        PVector position = new PVector(10, 10);
        PVector positionNE = new PVector(169, 10);
        PVector center = new PVector(100, 100);
        double energyNE = 90;
        double energy = 100;
        double radius = 0;
        for (int i = 0; i < toTest; i++) {
            generateRandomGenes();
            double fitAttack = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, attackGen);
            double fitMove = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, moveGen);
            double fitGuard = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, guardGen);
            assertTrue(fitMove > fitGuard);
            assertTrue(fitMove > fitAttack);
        }
    }
    @Test
    void fitOfMove2(){
        Fitness fitness = new FitnessNoRadiumNoMoney();
        PVector position = new PVector(100, 100);
        PVector positionNE = new PVector(69, 20);
        PVector center = new PVector(100, 100);
        double energyNE = 50;
        double energy = 50;
        double radius = 0;
        for (int i = 0; i < toTest; i++) {
            generateRandomGenes();
            double fitAttack = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, attackGen);
            double fitMove = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, moveGen);
            double fitGuard = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, guardGen);
            assertTrue(fitMove > fitGuard);
            assertTrue(fitMove > fitAttack);
        }
    }

    @Test
    void fitOfMove3(){
        Fitness fitness = new FitnessNoRadiumNoMoney();
        PVector position = new PVector(101, 10);
        PVector positionNE = new PVector(169, 110);
        PVector center = new PVector(100, 100);
        double energyNE = 90;
        double energy = 10;
        double radius = 0;
        for (int i = 0; i < toTest; i++) {
            generateRandomGenes();
            double fitAttack = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, attackGen);
            double fitMove = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, moveGen);
            double fitGuard = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, guardGen);
            assertTrue(fitMove > fitGuard);
            assertTrue(fitMove > fitAttack);
        }
    }

    @Test
    void fitOfMove4(){
        Fitness fitness = new FitnessNoRadiumNoMoney();
        PVector position = new PVector(100, 10);
        PVector positionNE = new PVector(12, 110);
        PVector center = new PVector(100, 100);
        double energyNE = 10;
        double energy = 100;
        double radius = 0;
        for (int i = 0; i < toTest; i++) {
            generateRandomGenes();
            double fitAttack = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, attackGen);
            double fitMove = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, moveGen);
            double fitGuard = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, guardGen);
            assertTrue(fitMove > fitGuard);
            assertTrue(fitMove > fitAttack);
        }
    }

    @Test
    void fitOfMove5(){
        Fitness fitness = new FitnessNoRadiumNoMoney();
        PVector position = new PVector(30, 10);
        PVector positionNE = new PVector(109, 10);
        PVector center = new PVector(100, 100);
        double energyNE = 50;
        double energy = 80;
        double radius = 0;
        for (int i = 0; i < toTest; i++) {
            generateRandomGenes();
            double fitAttack = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, attackGen);
            double fitMove = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, moveGen);
            double fitGuard = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, guardGen);
            assertTrue(fitMove > fitGuard);
            assertTrue(fitMove > fitAttack);
        }
    }

    @Test
    void fitOfMove6(){
        Fitness fitness = new FitnessNoRadiumNoMoney();
        PVector position = new PVector(30, 10);
        PVector positionNE = new PVector(40, 40);
        PVector center = new PVector(100, 100);
        double energyNE = 50;
        double energy = 51;
        double radius = 0;
        for (int i = 0; i < toTest; i++) {
            generateRandomGenes();
            double fitAttack = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, attackGen);
            double fitMove = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, moveGen);
            double fitGuard = fitness.fitOf(energy, energyNE, position, positionNE, center, radius, guardGen);
            assertTrue(fitMove > fitGuard);
            assertTrue(fitMove > fitAttack);
        }
    }

    private void generateRandomGenes(){
        attackGen = (int) ((Math.random() * 14768) + 36000);
        assertTrue(attackGen >= 36000 && attackGen <= 50767);

        moveGen =  (int) (Math.random() * 35999);
        assertTrue(moveGen >= 0 && moveGen <= 36000);

        guardGen = (int) ((Math.random() * 14768) + 50768);
        assertTrue(guardGen >= 50768 && guardGen <= 65535);
    }

}