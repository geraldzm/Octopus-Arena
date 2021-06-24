package GA.model;

import Util.Utility;

public class Chromosome {

     private short genes;

    public short getGenes() {
        return genes;
    }

    public void setGenes(short genes) {
        this.genes = genes;
    }

    public short bitwise_and_bytes(Chromosome b){
        return (short)(this.genes & b.genes);
    }

    public short bitwise_or_bytes(Chromosome b){
        return (short)(this.genes | b.genes);
    }

    public short bitwise_xor_bytes(Chromosome b){
        return (short)(this.genes ^ b.genes);
    }

//    public short crossover(Chromosome b){
//    }

}
