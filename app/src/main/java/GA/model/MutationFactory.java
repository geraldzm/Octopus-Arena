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

        return c -> c;
    }

    private Chromosome singleRandomMutate(Chromosome c){
        short mutationRandom = (short) Math.pow(2, Utility.random(0,16));
        c.setGenes((short) (c.getGenes() ^ mutationRandom));
        return c;
    }

}