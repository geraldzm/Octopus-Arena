package GA.model;

@FunctionalInterface
public interface Mutation {
     Chromosome mutate(Chromosome c, double probability);
}
