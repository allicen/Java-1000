package simple_calculation;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SimpleCalculation {
    private static int difference(long numberOfSystem){
        int sum = 0;
        int multi = 1;

        while (numberOfSystem > 0){
            long number = numberOfSystem % 10;
            sum += number;
            multi *= number;
            numberOfSystem /= 10;
        }
        return multi - sum;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        long numberIn = sc.nextLong();
        int numberSystem = sc.nextInt();

        long numberOfSystem = Long.parseLong(Long.toString(numberIn, numberSystem));
        long result = difference(numberOfSystem);

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(result));
        out.close();
    }
}
