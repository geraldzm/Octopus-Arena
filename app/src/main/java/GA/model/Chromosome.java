package GA.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Chromosome {

    private short genes;

    public short getGenes() {
        return genes;
    }
    public void setGenes(short genes) {
        this.genes = genes;
    }

}
