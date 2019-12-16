package anagrams;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Anagrams {
    private static boolean isAnagrams(String firstString, String secondString){
        ArrayList<Character> firstArr = new ArrayList<>();
        ArrayList<Character> secondArr = new ArrayList<>();
        char[] firstCh = firstString.toCharArray();
        char[] secondCh = secondString.toCharArray();

        for(char ch : firstCh){
            firstArr.add(ch);
        }

        for(char ch : secondCh){
            secondArr.add(ch);
        }

        Collections.sort(firstArr);
        Collections.sort(secondArr);

        return firstArr.equals(secondArr);
    }


    public static void main(String[] args) throws IOException {
        String firstString = "";
        String secondString = "";
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            firstString = sc.nextLine();
            secondString = sc.nextLine();
        }

        String result = isAnagrams(firstString, secondString) ? "YES" : "NO";

        FileWriter out = new FileWriter("output.txt");
        out.write(result);
        out.close();
    }
}
