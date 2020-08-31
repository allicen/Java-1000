package fun_game;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FunGame {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        String number = sc.nextLine();

        ArrayList<String> numbers = new ArrayList<>();
        String numberBinary = new BigInteger(number, 10).toString(2);

        while (!numbers.contains(numberBinary)) {
            numbers.add(numberBinary);
            numberBinary = numberBinary.substring(numberBinary.length()-1) + numberBinary.substring(0, numberBinary.length()-1);
        }

        String maxBinary = Collections.max(numbers);
        String max = new BigInteger(maxBinary, 2).toString(10);

        PrintWriter out = new PrintWriter(System.out);
        out.println(max);
        out.flush();
    }
}
