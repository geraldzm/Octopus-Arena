package GA.model;


public class Nature {

    private Mutation mutator;
    private Crossover crossover;
    private double mutationProbability;

    public Nature(Mutation mutator, Crossover crossover) {
        this.mutator = mutator;
        this.mutationProbability = 0.12;
        this.crossover = crossover;
    }

    public Chromosome crossover(Chromosome a, Chromosome b) {
        return this.crossover.crossover(a, b, mutator);
    }

}
