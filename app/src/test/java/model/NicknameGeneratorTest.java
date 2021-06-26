package model;

import Logic.NicknameGenerator;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class NicknameGeneratorTest {

    @Test
    void generateNickname() throws IOException {
        for (int i = 0; i < 100000; i++) {
            String s = NicknameGenerator.getInstance().chooseRandomValue("src/main/resources/data.adjectives");
            System.out.println(s);
        }
    }

    @Test
    void testGenerateNickname() {

        for (int i = 0; i < 10000; i++) {
            String s = NicknameGenerator.getInstance().generateNickname();
            System.out.println(s);
        }
    }
}