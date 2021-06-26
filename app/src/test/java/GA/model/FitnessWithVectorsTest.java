package GA.model;

import game.model.PApplet;
import game.model.PConstants;
import game.model.PVector;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FitnessWithVectorsTest {

    static Chromosome chase;
    static Chromosome attack;
    static Chromosome guard;
    static Chromosome escape;

    static Chromosome[] chromosomes;

    @BeforeAll
    static void setUp() {

        chase = new Chromosome((byte) 6);
        attack = new Chromosome((byte) 100);
        guard = new Chromosome((byte) 130);
        escape = new Chromosome((byte) 240);

        chromosomes = new Chromosome[]{chase, attack, guard, escape};
    }

    @Test
    void fitOfChase() {

        GAContext context = new GAContext();
        context.position = new PVector(180, 500);
        context.positionNE = new PVector(200, 500);
        context.energy = 70;
        context.energyNE = 80;

        FitnessWithVectors fitness = new FitnessWithVectors();

        context.phenotype = chase.getPhenotype();
        double v = fitness.fitOf(context);

        for (int i = 0; i < 4; i++) {
            context.phenotype =  chromosomes[i].getPhenotype();
            double v0 = fitness.fitOf(context);

            if(v == v0)
                System.out.println( Byte.toUnsignedInt(chromosomes[i].getGenes()));
            System.out.println(v + " " + v0);
          //  assertTrue(v >= v0);

        }

    }

}