package frendly_numbers;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FrendlyNumbers {
    private static String reformatNumber(char[] ch){
        StringBuilder firstNumberBuilder = new StringBuilder();
        String prev = "a";
        for (char aCh : ch) {
            String symbol = String.valueOf(aCh);
            if (!symbol.equals(prev)) {
                firstNumberBuilder.append(symbol);
            }
            prev = symbol;
        }
        return firstNumberBuilder.toString();
    }

    private static boolean check(String firstNumber, String secondNumber){
        char[] chFirst = firstNumber.toCharArray();
        Arrays.sort(chFirst);
        firstNumber = reformatNumber(chFirst);

        char[] chSecond = secondNumber.toCharArray();
        Arrays.sort(chSecond);
        secondNumber = reformatNumber(chSecond);
        return firstNumber.equals(secondNumber);
    }

    public static void main(String[] args) throws IOException {
        StringBuilder result = new StringBuilder();
        ArrayList<String> data = new ArrayList<>();

        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
            while (st.hasMoreTokens()){
                data.add(st.nextToken());
            }
        }
        data.remove(0);

        while (data.size() > 0){
            String firstNumber = data.get(0);
            String secondNumber = data.get(1);
            if(check(firstNumber, secondNumber)){
                result.append("YES");
                result.append("\n");
            }else {
                result.append("NO");
                result.append("\n");
            }
            data.remove(0);
            data.remove(0);
        }

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(result));
        out.close();
    }
}
