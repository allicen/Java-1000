package amount_two;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class AmountTwo {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);

        Scanner sc = new Scanner(new FileReader("input.txt"));
        int number = sc.nextInt();

        if (number < 4) {
            out.println(0);
        } else {
            int count = 0;
            for (int a = 1; a < number/2; a++) {
                for (int b = a; b < number/2; b++) {
                    if (a + b < number - 1) {
                        for (int c = b; c < number/2; c++) {
                            int d = number - (a + b + c);
                            if (d >= c) {
                                count++;
                            }
                        }
                    }
                }
            }

            out.println(count);
        }
        out.flush();
    }
}
