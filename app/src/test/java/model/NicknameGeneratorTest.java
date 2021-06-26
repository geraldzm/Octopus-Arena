package model;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

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