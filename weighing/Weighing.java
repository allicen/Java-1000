package weighing;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Weighing {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        int result = 0;
        int number = new Scanner(new FileReader("input.txt")).nextInt();

        if (number == 2 || number == 3) {
            result = 1;
        } else {
            boolean plusOne = false;
            while (number > 2) {
                int div = number/3;
                int mod;

                if (div * 3 == number) {
                    mod = div;
                } else {
                    mod = div + 1;
                }

                if (mod == 2) {
                    plusOne = true;
                }

                result++;
                number = mod;
            }

            if (plusOne) {
                result++;
            }
        }
        out.println(result);
        out.flush();
    }
}
