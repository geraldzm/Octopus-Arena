package Logic;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DescriptionParserTest {


    @Test
    void run() {
        DescriptionParser dp = new DescriptionParser();
        String s = "I want to play in arenas of 8 octopus and bet a total of 200 dollars. I have 0 experience.";
        String rs = dp.extractInts(s);
        System.out.println(rs);
        ArrayList<Integer> ans = dp.numberValuesFromString(rs);
    }
}