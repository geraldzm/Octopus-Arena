package GA.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class PopulationTest {

    Population population;

    @BeforeAll
    void setUp() {
        population = new Population(20, 5, c -> 0);
    }


    @Test
    void initialPopulation() {


    }

}