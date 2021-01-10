package goldbach_conjecture_two;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GoldbachConjectureTwo {

    private static boolean isSimple(int number) {
        for (int index = 2; index < number; index++) {
            if (number % index == 0) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) throws IOException {
        int n = new Scanner(new FileReader("input.txt")).nextInt();
        int result = 0;
        for (int i = 2; i <= n/2; i++) {
            int j = n - i;

            if (isSimple(i) && isSimple(j)) {
                result++;
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        out.println(result);
        out.flush();
    }
}
