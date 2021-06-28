package Logic;

import java.util.ArrayList;

//Adapted from https://www.geeksforgeeks.org/extract-all-integers-from-the-given-string-in-java/
public class DescriptionParser {



    public ArrayList<Integer> numberValuesFromString(String input){
        String s = extractInts(input);
        ArrayList<Integer> numbers = new ArrayList<>();
        String[] inputNumbers = s.split(" ");
        for (int i = 0; i < inputNumbers.length; i++) {
            numbers.add(Integer.parseInt(inputNumbers[i]));
        }
        return numbers;
    }

    public String extractInts(String str)
    {
        // Replacing every non-digit number
        // with a space(" ")
        str = str.replaceAll("[^\\d]", " ");

        // Remove extra spaces from the beginning
        // and the ending of the string
        str = str.trim();

        // Replace all the consecutive white
        // spaces with a single space
        str = str.replaceAll(" +", " ");

        if (str.equals(""))
            return "-1";

        return str;
    }

}
