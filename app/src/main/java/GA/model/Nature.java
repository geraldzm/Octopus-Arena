package GA.model;


import static Util.Utility.*;

public class Nature {

    private Mutation mutator;
    private double mutationProbability;

    public Nature(Mutation mutator) {
        this.mutator = mutator;
        this.mutationProbability = 0.12;
    }

    public Chromosome crossover(Chromosome a, Chromosome b) {

        int crossoverPoint = random(2, 6);

        byte pivot = (byte) (0xff << (8 - crossoverPoint));
        byte upperGene = (byte) (a.getGenes() & pivot);

        pivot ^= 0xff;
        byte lowerGene = (byte) (b.getGenes() & pivot);

        Chromosome baby = new Chromosome((byte) (upperGene & lowerGene));

        if(Math.random() < mutationProbability)
            mutator.mutate(baby);

        return baby;
    }

}
