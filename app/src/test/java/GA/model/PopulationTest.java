package GA.model;

import game.model.PApplet;
import game.model.PVector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PopulationTest {

    @Test
    void initialPopulation() {

        GAContext context = new GAContext();
        context.position = new PVector(500, 200);
        context.positionNE = new PVector(200, 200);
        context.energy = 100;
        context.energyNE = 80;

        Population population = new Population(20, 5, new FitnessWithVectors());

        int fail = 0, success = 0;
        for (int i = 0; i < 1000; i++) {
            Chromosome run = population.run(context);

            if( PApplet.degrees((float) run.getPhenotype()) == 45)  {
                success++;
            } else {
                fail++;
            }

        }

        assertTrue(success > fail);

        System.out.println(success);
        System.out.println(fail);
    }

}