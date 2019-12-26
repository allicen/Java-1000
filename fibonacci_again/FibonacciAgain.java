package fibonacci_again;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FibonacciAgain {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new FileReader("input.txt"));
        long number = (scan.nextLong()) % 60;

        long a = 0, b = 1;
        for (int i = 0; i < number; i++){
            b = a + b;
            a = b - a;
        }
        long result = b%10;

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(result));
        out.close();
    }
}
