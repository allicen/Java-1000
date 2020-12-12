package _other_tasks_.e_knights_and_knaves;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class KnightsAndKnaves {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner(new FileReader("input.txt"));
        sc.nextLine();
        String[] items = sc.nextLine().split(" ");

        ArrayList<Integer> k = new ArrayList<>();

        boolean success = false;
        for (String item : items) {
            k.add(Integer.parseInt(item));
        }

        k.sort(Collections.reverseOrder());

        for (int i = 0; i < k.size(); i++) {
            if (k.get(i) > i && (i+1 == k.size() || i+1 < k.size() && k.get(i+1) <= i)) {
                success = true;
                out.println(i+1);
            }
        }

        if (!success && k.get(k.size()-1) >= k.size()) {
            success = true;
            out.println(k.size());
        }

        if (!success) {
            out.println("-1");
        }

        out.flush();
    }
}
