package _other_tasks_.search;

import java.io.PrintWriter;
import java.util.Scanner;

public class Search {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = sc.nextInt();

        if (n == 1) {
            out.println(1);
        } else {
            out.println(0);
        }

        out.flush();
    }
}
