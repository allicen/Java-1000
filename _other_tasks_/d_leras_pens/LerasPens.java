package _other_tasks_.d_leras_pens;

import java.io.PrintWriter;
import java.util.Scanner;

public class LerasPens {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        String[] info = in.nextLine().split(" ");

        int n = Integer.parseInt(info[0]);
        int k = Integer.parseInt(info[1]);

        int forgot = 0;
        int kStart = k;

        for (int i = 0; i < n; i++) {
            String[] student = in.nextLine().split(" ");
            int a = Integer.parseInt(student[0]);
            int b = Integer.parseInt(student[1]);

            if (i == 0) {
                forgot = b;
                k -= forgot;
            } else {
                if (forgot == 0) {
                    forgot = b;
                    k -= forgot;
                } else if (forgot > a) {
                    k += a;
                    forgot = kStart - k;
                    if (b > forgot) {
                        int c = b - forgot;
                        k -= c;
                    }
                } else {
                    k += forgot;
                    k -= b;
                }
            }
            forgot = kStart - k;
        }

        out.println(k);
        out.flush();

    }
}
