package sum_n_digit_numbers;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SumNDigitNumbers {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);

        Scanner sc = new Scanner(new FileReader("input.txt"));
        int n = sc.nextInt();

        if (n == 1) {
            out.println(45);
        } else if (n == 2) {
            out.println(4905);
        } else {

            out.print(494);

            int x = n-2;
            for (int i = 0; i < x-1; i++) {
                out.print(9);
            }
            out.print(55);

            for (int i = 0; i < x; i++) {
                out.print(0);
            }
        }

        out.flush();
    }
}
