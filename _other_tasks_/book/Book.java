package _other_tasks_.book;

import java.io.PrintWriter;
import java.util.Scanner;

public class Book {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n, k, m1, m2;

        n = Integer.parseInt(sc.nextLine());
        String[] line = sc.nextLine().split(" ");
        k = Integer.parseInt(line[0]);
        m1 = Integer.parseInt(line[1]);
        m2 = Integer.parseInt(line[2]);

        int count = 0;

        while (n > 0) {
            String[] book = sc.nextLine().split(" ");
            long h, k1;
            h = Long.parseLong(book[0]);

            for (int i = 2; i < book.length; i++) {
                long size = Long.parseLong(book[i]);
                if (size * m2 <= h * k && size * m1 >= h) {
                    continue;
                }
                count++;
            }
            n--;
        }

        out.println(count);

        out.flush();
    }
}
