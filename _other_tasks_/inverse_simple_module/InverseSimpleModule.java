package _other_tasks_.inverse_simple_module;

import java.io.*;

public class InverseSimpleModule {

    private static long p = (long) (1e9 + 9);

    private static long func(long x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 0) {
            return func(x * x % p, n / 2) % p;
        } else {
            return x * func(x, n - 1) % p;
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader sc = new BufferedReader(new FileReader("input.txt"));
        PrintWriter out = new PrintWriter(System.out);

        long a;

        byte index = 0;

        for (String line; (line = sc.readLine()) != null; ) {
            if (index == 1) {
                a = Long.parseLong(line);
                out.println(func(a, p - 2));
            }
            if (index == 0) {
                index = 1;
            }
        }

        out.flush();
    }
}
