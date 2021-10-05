package _other_tasks_.play;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Play {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        sc.nextLine();
        String[] line = sc.nextLine().split(" ");

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < line.length; i++) {
            if (Long.parseLong(line[i]) % 2 != (i+1) % 2) {
                arr.add(i+1);
            }
        }

        if (arr.size() == 2 && arr.get(0)%2 != arr.get(1)%2) {
            out.println(arr.get(0) + " " + arr.get(1));
        } else if (arr.size() == 0 && line.length > 2) {
            out.println("1 3");
        } else {
            out.println("-1 -1");
        }

        out.flush();
    }
}
