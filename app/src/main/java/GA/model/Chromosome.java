package GA.model;

import Util.Utility;
import game.model.PConstants;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Chromosome implements Comparable<Chromosome> {

    private byte genes;
    private double phenotype;
    private double fit;

    // 0 - 63 = 45      - chase
    // 64 - 127 = 135   - attack
    // 128 - 191 = 225  - guard
    // 192 - 255 = 315  - run bitch

    public Chromosome() {
        randomGen();
        createPhenotype();
    }

    public Chromosome(byte genes) {
        this.genes = genes;
        createPhenotype();
    }

    public void randomGen() {
        genes = (byte) Utility.random(0, 256);
    }

    public double getPhenotype() {
        return phenotype;
    }

    public ChromosomeType getType() {

        int n = Byte.toUnsignedInt(genes);

        if(n < 64)
            return ChromosomeType.CHASE;
        if(n < 128)
            return ChromosomeType.ATTACK;
        if(n < 192)
            return ChromosomeType.GUARD;

        return ChromosomeType.EVADE;
    }

    private void createPhenotype() {
        float radians = PConstants.QUARTER_PI;
        int genType = Byte.toUnsignedInt(genes) / 64;
        phenotype= ((genType + 1) * radians + radians * genType);
    }


    public void setGenes(byte genes) {
        this.genes = genes;
        createPhenotype();
    }

    @Override
    public int compareTo(Chromosome otherChromosome) {
        return Double.compare(fit, otherChromosome.fit);
    }
}
