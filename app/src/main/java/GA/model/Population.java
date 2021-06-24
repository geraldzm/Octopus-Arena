package GA.model;

import Util.Utility;

import java.util.TreeMap;

public class Population {

    private Nature nature;
    private int sizePopulation;
    private Chromosome population[];
    private int amountGenerations;
    private Fitness fitnessCalculator;

    public Population(int pSizePopulation, int pAmountGenerations, Fitness pFitness) {
        this.nature = new Nature(MutationFactory.getInstance().getMutationType(MutationType.SINGLE_RANDOM_MUTATE));
        this.sizePopulation = pSizePopulation;
        this.amountGenerations = pAmountGenerations;
        this.population = new Chromosome[sizePopulation];
        this.fitnessCalculator = pFitness;
    }

    private void generateInitialPopulation() {
        for (int i = 0; i < sizePopulation; i++) {
            Chromosome individual = new Chromosome();
            individual.setGenes((short)Utility.random(0,65536));
            population[i] = individual;
        }
    }

    public Chromosome run(GAContext c) {
        generateInitialPopulation();
        TreeMap<Double, Chromosome> map = new TreeMap<Double, Chromosome>();
        for (int i = 0; i < amountGenerations; i++) {
            map.clear();
            testFitnessPopulation(c, map);
            breeding(map);
        }
        return map.lastEntry().getValue();
    }

    private void testFitnessPopulation(GAContext c, TreeMap<Double, Chromosome> map) {
        for (int j = 0; j < sizePopulation; j++) {
            c.chromosome = population[j].getGenes();
            map.put(fitnessCalculator.fitOf(c), population[j]);
            if(map.size() > (sizePopulation*0.6))
                map.remove(map.firstEntry());
        }
    }

    private void breeding(TreeMap<Double, Chromosome> map) {
        Chromosome fitArray[] = (Chromosome[]) map.values().toArray();
        for (int j = 0; j < sizePopulation; j++) {
            Chromosome male = Utility.choiceRandom(fitArray);
            Chromosome female = Utility.choiceRandom(fitArray);
            population[j] = nature.crossover(male, female);
        }
    }

}

