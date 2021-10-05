package _other_tasks_.champion;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

////////// неверно

public class Champion {
    public static void main(String[] args) {

        ArrayList<Long> nums = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        sc.nextLine();

        String[] data = sc.nextLine().split(" ");
        long k = 0;
        for (String s: data) {
            nums.add(Long.parseLong(s) + k);
            k++;
        }

        if (nums.size() == 1) {
            out.println(1);
        } else {
            long len = 0;
            long max = 0;

            for (int i = 0; i < nums.size(); i++) {
                if (i == 0) {
                    continue;
                }

                if (nums.get(i - 1) < nums.get(i)) {
                    if (i == 1 || len == 0) {
                        len++;
                    }
                    len++;
                } else {
                    if (max < len) {
                        max = len;
                    }
                    len = 0;
                }
            }

            if (max == 0 || len > max) {
                out.println(len);
            } else {
                out.println(max);
            }
        }

        out.flush();
    }
}
