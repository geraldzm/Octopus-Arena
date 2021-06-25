package GA.model;

import game.model.PConstants;
import org.junit.jupiter.api.Test;

import static Util.Utility.random;
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


    @Test
    void crossoverNoMutationsFixedPoint() {

//        System.out.printf("0x%02X%n", pivot);

        Nature nature = new Nature((c, probability) -> c, CrossoverFactory.getInstance().getCrossover(CrossoverType.FIXED_POINT));

        Chromosome c0 = new Chromosome((byte) 0x05); // 0000 0101
        Chromosome c1 = new Chromosome((byte) 0x4C);// 0100 1100
        Chromosome expected = new Chromosome((byte) 0x0C);// 0000 1100

        assertEquals(expected.getGenes(), nature.crossover(c0, c1).getGenes());

        c0.setGenes((byte) 0xA3);
        c1.setGenes((byte) 0x49);
        expected.setGenes((byte) 0xA9);

        assertEquals(expected.getGenes(), nature.crossover(c0, c1).getGenes());

        c0.setGenes((byte) 0x49);
        c1.setGenes((byte) 0xA3);
        expected.setGenes((byte) 0x43);

        assertEquals(expected.getGenes(), nature.crossover(c0, c1).getGenes());

    }

}