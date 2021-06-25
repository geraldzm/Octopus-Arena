package GA.model;

@FunctionalInterface
public interface Crossover {

    Chromosome crossover(Chromosome a, Chromosome b, Mutation mutation);

}
