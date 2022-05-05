package _other_tasks_.rapid_exponentiation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class RapidExponentiation {
    public static double multi(double x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 0) {
            return multi(x * x, n / 2);
        } else {
            return x * multi(x, n - 1);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new FileReader("input.txt"));
        PrintWriter out = new PrintWriter(System.out);
        double a = Double.parseDouble(sc.nextLine());
        long n = Long.parseLong(sc.nextLine());

        double res = multi(a, n);
        out.println(res);

        out.flush();
    }
}
