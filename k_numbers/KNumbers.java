package k_numbers;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class KNumbers {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));

        long number = sc.nextLong();
        int count = 0;

        for(long firstPart = 1; firstPart < number; firstPart++){
            long secondPart = number - firstPart;
            int lastSymbolFirstPart = (int)firstPart % 10;
            int lastSymbolSecondPart = (int)secondPart % 10;
            int firstSymbolSecondPart = Integer.valueOf(String.valueOf(secondPart).substring(0, 1));

            if(lastSymbolFirstPart == firstSymbolSecondPart && (lastSymbolFirstPart + lastSymbolSecondPart) % 10 == (int) number % 10){
                StringBuilder overNumber = new StringBuilder();
                long numberCopy = secondPart;
                while (numberCopy > 0){
                    long digit = numberCopy % 10;
                    overNumber.append(digit);
                    numberCopy /= 10;
                }
                long overNumberLong = Long.valueOf(String.valueOf(overNumber));

                if(firstPart == overNumberLong){
                    count++;
                }
            }
        }

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(count));
        out.close();
    }
}
