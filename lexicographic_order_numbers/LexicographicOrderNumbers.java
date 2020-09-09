package lexicographic_order_numbers;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LexicographicOrderNumbers {
    public static void main(String[] args) throws IOException {
        String[] numbers = new Scanner(new FileReader("input.txt")).nextLine().split(" ");
        String n = numbers[0];
        String k = numbers[1];

        ArrayList<String> numArray = new ArrayList<>();
        for (int i = 1; i <= Integer.parseInt(n); i++) {
            numArray.add(String.valueOf(i));
        }
        Collections.sort(numArray);

        PrintWriter out = new PrintWriter(System.out);
        for (int i = 0; i < numArray.size(); i++) {
            if (numArray.get(i).equals(k)) {
                out.println(i+1);
                break;
            }
        }
        out.flush();
    }
}
