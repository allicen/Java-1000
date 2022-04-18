package _other_tasks_.microbiology;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Microbiology {
    public static void main(String[] args) throws IOException {
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        String[] data = sc.nextLine().split(" ");
        long n = Long.parseLong(data[0]);
        long m = Long.parseLong(data[1]);

        long div = 1;
        long e = n;

        while (e > 0) {

            if (e % 2 == 1) {
                div *= n;
            }

            n *= n;
            e >>= 1;

            long r = div / m;
            if (r > 0) {
                div %= m;
            }

            n %= m;
        }

        PrintWriter out = new PrintWriter(System.out);
        out.println(div);
        out.flush();
    }
}
