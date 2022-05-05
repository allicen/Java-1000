package _other_tasks_.large_prime_numbers;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LargePrimeNumbers {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);

        Scanner sc = new Scanner(new FileReader("input.txt"));
        String[] line = sc.nextLine().split(" ");

        long m = Long.parseLong(line[0]);
        long n = Long.parseLong(line[1]);

        int max = (int) (1e6 + 1);
        byte[] prime = new byte[max];
        byte[] ans = new byte[max];
        prime[0] = 1;
        prime[1] = 1;

        for (int i = 2; i < max; ++i) {
            if (prime[i] == 0) {
                int tmp = (int) ((i - (m % i)) % i);

                if (m + tmp > i && tmp < max) {
                    ans[tmp] = 1;
                }

                if (i + tmp < max && m + tmp + i > i) {
                    ans[i + tmp] = 1;
                }

                for (int j = 2 * i; j < max; j += i) {
                    prime[j] = 1;

                    if (m <= j && j - m < max) {
                        int index = (int)(j - m);
                        ans[index] = 1;
                    }

                    if (j + tmp < max) {
                        ans[j + tmp] = 1;
                    }
                }
            }
        }

        for (int i = 0; i <= n - m; i++) {
            if (ans[i] == 0 && m + i >= 2) {
                long num = m + i;
                out.print(num + " ");
            }
        }

        out.flush();
    }
}
