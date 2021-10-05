package _other_tasks_.tower;

import java.io.PrintWriter;
import java.util.Scanner;

public class Tower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        sc.nextLine();
        String[] line = sc.nextLine().split(" ");

        long a1 = Long.parseLong(line[0]);

        if (a1 % 3 == 0) {
            out.println(0);
        } else if (a1 % 3 == 1) {
            out.println(1);
        } else if (line.length == 1) {
            out.println(2);
        } else {
            long a2 = Long.parseLong(line[1]);
            if (a2 % 2 == 0) {
                out.println(1);
            } else {
                out.println(2);
            }
        }

        out.flush();
    }
}
