package _other_tasks_.b_test_task_in_naumen;

import java.io.PrintWriter;
import java.util.Scanner;

public class TestTaskInNaumen {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.parseInt(in.nextLine());
        String[] vectorN = in.nextLine().split(" ");
        int m = Integer.parseInt(in.nextLine());
        String[] vectorM = in.nextLine().split(" ");

        int index = 0;
        for (String number: vectorN) {
            int count = Integer.parseInt(number);

            for (int i = 0; i < count; i++) {
                out.print(vectorM[index]);
            }
            out.print(" ");

            index++;
            if (index >= vectorM.length) {
                index = 0;
            }

        }

        out.flush();
    }
}
