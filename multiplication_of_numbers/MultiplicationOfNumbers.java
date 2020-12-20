package multiplication_of_numbers;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MultiplicationOfNumbers {

    private static int div(int number) {
        for (int i = 9; i != 1; i--) {
            if (number % i == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main (String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        int n = new Scanner(new FileReader("input.txt")).nextInt();
        int number = 1;

        if (n > 1) {
            StringBuilder line = new StringBuilder();
            while ((n /= number) > 1 && (number = div(n)) != -1) {
                line.append(number);
            }
            if (number == -1) {
                out.println(-1);
            } else {
                out.println(line.reverse());
            }

        } else if (n == 0) {
            out.println(10);
        } else if (n == 1) {
            out.println(1);
        }

        out.flush();
    }
}
