package GA.model;

import Util.Utility;
import game.model.PApplet;
import game.model.PConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Chromosome {

    private byte genes;

    public void randomGen() {
        genes = (byte) Utility.random(0, 256);
    }

    public double getPhenotype() {
        return genes;
    }

}
