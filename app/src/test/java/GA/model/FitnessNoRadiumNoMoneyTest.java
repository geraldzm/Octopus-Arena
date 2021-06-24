package GA.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FitnessNoRadiumNoMoneyTest {

    int toTest = 10000;
    int attackGen;
    int guardGen;
    int moveGen;

    private void generateRandomGenes(){
        attackGen = (int) ((Math.random() * 14768) + 36000);
        assertTrue(attackGen >= 36000 && attackGen <= 50767);

        moveGen =  (int) (Math.random() * 35999);
        assertTrue(moveGen >= 0 && moveGen <= 36000);

        guardGen = (int) ((Math.random() * 14768) + 50768);
        assertTrue(guardGen >= 50768 && guardGen <= 65535);
    }

}