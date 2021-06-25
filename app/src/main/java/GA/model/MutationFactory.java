package GA.model;

import Util.Utility;

public class MutationFactory {

    private MutationFactory() {
    }

    private static MutationFactory instance = new MutationFactory();

    public static MutationFactory getInstance(){
        return instance;
    }

    public Mutation getMutationType(MutationType type) {
        switch (type) {
            case ALL_RANDOM_MUTATE:
               // return all_random_mutate();
            case HALF_RANDOM_MUTATE:
                // return all_random_mutate();
            case SINGLE_RANDOM_MUTATE:
                 return this::singleRandomMutate;
            case INTERCHANGE_MUTATE:
                // return all_random_mutate();
        }

        return (c, probability) -> c;
    }

    private Chromosome singleRandomMutate(Chromosome c, double mutationProbability) {

        if( Math.random() >= mutationProbability) return c;

        System.out.println("Mutate: ");
        System.out.printf("0x%02X%n", c.getGenes());
        byte mutationRandom = (byte) Math.pow(2, Utility.random(0,8));
        System.out.printf("with: 0x%02X%n", mutationRandom);
        c.setGenes((byte) (c.getGenes() ^ mutationRandom));
        System.out.printf("result 0x%02X%n", c.getGenes());

        return c;
    }

}
