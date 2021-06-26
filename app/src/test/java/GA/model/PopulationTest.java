package GA.model;

import Util.Utility;
import game.model.PApplet;
import game.model.PVector;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PopulationTest {

    @Test
    void chaseMethod() {

        GAContext context = new GAContext();
        context.position = new PVector(100, 500);
        context.positionNE = new PVector(200, 500);
        context.energy = 80;
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

    @Test
    void chaseMethodGame() {

        GAContext context = new GAContext();
        context.position = new PVector(200, 500);
        context.positionNE = new PVector(600, 500);
        context.energy = 100;
        context.energyNE = 70;

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

    @Test
    void singleTest() {

        GAContext context = new GAContext();
        context.position = new PVector(200, 500);
        context.positionNE = new PVector(600, 500);
        context.energy = 100;
        context.energyNE = 70;

        Population population = new Population(20, 5, new FitnessWithVectors());

        Chromosome run = population.run(context);

        System.out.println(run);
    }

    @Test
    void singleTest2() {

        GAContext context = new GAContext();
        context.position = new PVector(600, 500);
        context.positionNE = new PVector(200, 500);
        context.energy = 70;
        context.energyNE = 100;

        Population population = new Population(20, 5, new FitnessWithVectors());

        int fail = 0, success = 0;
        for (int i = 0; i < 1000; i++) {
            Chromosome run = population.run(context);

            if(PApplet.degrees((float) run.getPhenotype()) == 315)  {
                success++;
            } else {
                fail++;
            }

        }
        System.out.println(success);
        System.out.println(fail);

        assertTrue(success > fail);

    }

    @Test
    void test() {

        PriorityQueue<Chromosome> chromosomes = new PriorityQueue<>();
        Chromosome chromosome0 = new Chromosome();
        chromosome0.setFit(4);

        Chromosome chromosome1 = new Chromosome();
        chromosome1.setFit(4);

        Chromosome chromosome2 = new Chromosome();
        chromosome2.setFit(3.5);

        Chromosome chromosome3 = new Chromosome();
        chromosome3.setFit(3.5);

        chromosomes.add(chromosome0);
        chromosomes.add(chromosome1);
        chromosomes.add(chromosome2);
        chromosomes.add(chromosome3);


        Map<Double, Long> collect = chromosomes.stream()
                .collect(Collectors.groupingBy(Chromosome::getFit, Collectors.counting()));

        collect.forEach((aDouble, aLong) -> System.out.println(aDouble + ":\t" + aLong));

        Map.Entry<Double, Long> doubleLongEntry = Utility.maxFromMap(collect);

        System.out.println(doubleLongEntry);

    }

}