package cake_two;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CakeTwo {
    private static int _gcd(int a, int b) {
        if (b == 0) return a;
        else return _gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        String[] data = new Scanner(new FileReader("input.txt")).nextLine().split(" ");
        int m = Integer.parseInt(data[0]);
        int n = Integer.parseInt(data[1]);

        int res = m + n - _gcd(m, n);

        PrintWriter out = new PrintWriter(System.out);
        out.println(res);
        out.flush();
    }
}
