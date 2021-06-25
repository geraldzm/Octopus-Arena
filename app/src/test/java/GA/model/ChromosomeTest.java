package GA.model;

import game.model.PConstants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ChromosomeTest {


    // 0 - 63 = 45
    // 64 - 127 = 135
    // 128 - 191 = 225
    // 192 - 255 = 315

    float radians45 = PConstants.QUARTER_PI;
    float radians135 = PConstants.QUARTER_PI * 3;
    float radians225 = PConstants.QUARTER_PI * 5;
    float radians315 = PConstants.QUARTER_PI * 7;

    @Test
    void phenotypeConversionChase() {

        Chromosome chromosome = new Chromosome();

        for (int i = 0; i < 64; i++) {
            chromosome.setGenes((byte) i);

            assertEquals(radians45, chromosome.getPhenotype());
        }

    }

    @Test
    void phenotypeConversionAttack() {

        Chromosome chromosome = new Chromosome();

        for (int i = 64; i < 128; i++) {
            chromosome.setGenes((byte) i);

            assertEquals(radians135, chromosome.getPhenotype());
        }

    }

    @Test
    void phenotypeConversionGuard() {

        Chromosome chromosome = new Chromosome();

        for (int i = 128; i < 192; i++) {
            chromosome.setGenes((byte) i);
            assertEquals(radians225, chromosome.getPhenotype());
        }

    }

    @Test
    void phenotypeConversionEvade() {

        Chromosome chromosome = new Chromosome();

        for (int i = 192; i < 256; i++) {
            chromosome.setGenes((byte) i);

            double phenotype = chromosome.getPhenotype();

            assertEquals(radians315, phenotype);
        }

    }
}