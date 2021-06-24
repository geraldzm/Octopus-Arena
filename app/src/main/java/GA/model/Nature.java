package GA.model;

import Util.Utility;

public class Nature {

    private Mutation mutator;
    private double mutationProbability;

    public Nature(Mutation mutator) {
        this.mutator = mutator;
        this.mutationProbability = 0.12;
    }

    public Chromosome crossover(Chromosome a, Chromosome b){
        int crossoverPoint = Utility.random(4,13);
        short pivot = (short) (((short) 0xffff) << (short)(16 - crossoverPoint));
        short upperGene = (short) (a.getGenes() & pivot);
        pivot ^= 0xffff;
        short lowerGene = (short) (b.getGenes() & pivot);
        Chromosome baby = new Chromosome((short) (upperGene & lowerGene));
        if(Math.random() < mutationProbability)
            mutator.mutate(baby);
        return baby;
    }



}
