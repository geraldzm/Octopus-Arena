package GA.model;

import org.junit.jupiter.api.Test;


class PopulationTest {


    @Test
    void initialPopulation() {

        GAContext context = new GAContext();
        Population population = new Population(20, 5, c -> c.phenotype);

        population.run(context);

    }

}