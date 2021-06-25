package GA.model;

import Util.Utility;

public class CrossoverFactory {

    private static CrossoverFactory crossoverFactory;

    public static CrossoverFactory getInstance() {
        if(crossoverFactory == null)
            init();
        return crossoverFactory;
    }

    private static void init() {
        crossoverFactory = new CrossoverFactory();
    }

    public Crossover getCrossover(CrossoverType type) {

        switch (type) {
            case FIXED_POINT:
                return this::fixedPoint;
            case RANDOM_POINT:
                return this::randomPoint;
        }

        return (a, b, mutation) -> new Chromosome((byte) 0);
    }

    private Chromosome fixedPoint(Chromosome a, Chromosome b, Mutation mutation) {

        byte pivot = (byte) (0xff << 4);
        byte upperGene = (byte) (a.getGenes() & pivot);
        pivot ^= 0xff;
        byte lowerGene = (byte) (b.getGenes() & pivot);

        return new Chromosome((byte) (upperGene | lowerGene));
    }

    private Chromosome randomPoint(Chromosome a, Chromosome b, Mutation mutation) {

        byte pivot = (byte) (0xff << Utility.random(2, 6));
        byte upperGene = (byte) (a.getGenes() & pivot);
        pivot ^= 0xff;
        byte lowerGene = (byte) (b.getGenes() & pivot);

        return new Chromosome((byte) (upperGene | lowerGene));
    }

}
