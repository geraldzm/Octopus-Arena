package GA.model;

import java.util.Collection;
import java.util.TreeMap;

import static Util.Utility.*;

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
        this.acceptedPopulationSize = (int) (pSizePopulation * 0.4);
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

        TreeMap<Double, Chromosome> map = new TreeMap<>();
        for (int i = 0; i < amountGenerations; i++) {
            map.clear();
            getMoreFit(c, map);
            breeding(map);
        }

        return map.lastEntry().getValue();
    }

    private void getMoreFit(GAContext c, TreeMap<Double, Chromosome> map) {

        for (int j = 0; j < sizePopulation; j++) {

            Chromosome chromosome = population[j];
            c.phenotype = chromosome.getPhenotype();

            map.put(fitnessCalculator.fitOf(c), chromosome);

            if(map.size() > acceptedPopulationSize)
                map.remove(map.firstEntry().getKey());

        }

    }

    private void breeding(TreeMap<Double, Chromosome> map) {

        Collection<Chromosome> values = map.values();

        for (int j = 0; j < sizePopulation; j++) {
            Chromosome male = choiceRandom(values);
            Chromosome female = choiceRandom(values);
            population[j] = nature.crossover(male, female);
        }

    }

}