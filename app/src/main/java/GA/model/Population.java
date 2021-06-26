package GA.model;

import Util.Utility;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

import static Util.Utility.choiceRandom;

public class Population {

    private int sizePopulation, amountGenerations, acceptedPopulationSize;
    private Nature nature;
    private Chromosome population[];
    private Fitness fitnessCalculator;

    public Population(int pSizePopulation, int pAmountGenerations, Fitness pFitness) {

        this.nature = new Nature(
                MutationFactory.getInstance().getMutationType(MutationType.SINGLE_RANDOM_MUTATE),
                CrossoverFactory.getInstance().getCrossover(CrossoverType.RANDOM_POINT)
        );

        this.sizePopulation = pSizePopulation;
        this.acceptedPopulationSize = (int) (pSizePopulation * 0.6);
        this.amountGenerations = pAmountGenerations;
        this.population = new Chromosome[sizePopulation];
        this.fitnessCalculator = pFitness;

    }

    private void generateInitialPopulation() {

        for (int i = 0; i < sizePopulation; i++) {

            Chromosome chromosome = new Chromosome();
            chromosome.randomGen();
            population[i] = chromosome;

        }

    }

    public Chromosome run(GAContext c) {

        generateInitialPopulation();

        PriorityQueue<Chromosome> mostFit = new PriorityQueue<>();
        for (int i = 0; i < amountGenerations; i++) {
            mostFit.clear();
            getMoreFit(c, mostFit);
            breeding(mostFit);

            Map<ChromosomeType, Long> collect = mostFit.stream()
                    .collect(Collectors.groupingBy(Chromosome::getType, Collectors.counting()));

            /*System.out.println("\nGen #" +i);
            collect.forEach((ch, n) -> System.out.println(ch + "\t" + n));*/
        }

        Map<Byte, Long> collect = mostFit.stream()
                .collect(Collectors.groupingBy(Chromosome::getGenes, Collectors.counting()));

        Map.Entry<Byte, Long> doubleLongEntry = Utility.maxFromMap(collect);

        return new Chromosome(doubleLongEntry.getKey());
    }

    private void getMoreFit(GAContext c, PriorityQueue<Chromosome> mostFit) {

        for (int j = 0; j < sizePopulation; j++) {

            Chromosome chromosome = population[j];
            c.phenotype = chromosome.getPhenotype();
            chromosome.setFit(fitnessCalculator.fitOf(c));

            mostFit.add(chromosome);

            if(mostFit.size() > acceptedPopulationSize)
                mostFit.poll();

        }

    }

    private void breeding(PriorityQueue<Chromosome> mostFit) {

        Chromosome[] values = new Chromosome[mostFit.size()];

        mostFit.toArray(values);

        for (int j = 0; j < sizePopulation; j++) {
            Chromosome male = choiceRandom(values);
            Chromosome female = choiceRandom(values);
            population[j] = nature.crossover(male, female);
        }

    }

}