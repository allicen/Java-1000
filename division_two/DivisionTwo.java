package division_two;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DivisionTwo {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner(new FileReader("input.txt"));
        long number = sc.nextLong();

        while (number >= 1) {
            if (number % 2 == 0) {
                number /= 2;
            } else if (number % 5 == 0) {
                number /= 5;
            } else {
                break;
            }
        }

        if (number == 1) {
            out.println("NO");
        } else {
            out.println("YES");
        }

        out.flush();
    }
}
