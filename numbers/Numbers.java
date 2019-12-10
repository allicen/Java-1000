package numbers;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) throws IOException {
        String min, max;

        ArrayList<String> numbers = new ArrayList<>();
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        String numberIn = sc.nextLine();
        char[] ch = numberIn.toCharArray();
        for(Character symbol : ch){
            numbers.add(String.valueOf(symbol));
        }

        // Максимальное число
        numbers.sort(Comparator.reverseOrder());

        StringBuilder str = new StringBuilder();
        for(String symbol : numbers){
            str.append(symbol);
        }

        max = String.valueOf(str);

        // Минимальное число
        Collections.sort(numbers);

        int zeroCount = 0;
        str = new StringBuilder();
        for (String number : numbers) {
            if (number.equals("0")) {
                zeroCount++;
            } else {
                if (zeroCount != 0) {
                    str.append(number);
                    for (int j = zeroCount; j > 0; j--) {
                        str.append("0");
                    }
                    zeroCount = 0;
                } else {
                    str.append(number);
                }
            }
        }

        min = String.valueOf(str);

        FileWriter out = new FileWriter("output.txt");
        out.write(min + " " + max);
        out.close();
    }
}
