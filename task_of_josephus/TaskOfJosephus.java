package task_of_josephus;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskOfJosephus {
    public static void main(String[] args) throws IOException {
        String[] data = new Scanner(new FileReader("input.txt")).nextLine().split(" ");
        int n = Integer.parseInt(data[0]);
        int k = Integer.parseInt(data[1]);

        ArrayList<Integer> items = new ArrayList<>();
        for (int index = 0; index < n; index++) {
            items.add(index + 1);
        }

        int index = 1;
        int step = 1;
        while (items.size() > 1) {
            if (index == k) {
                items.remove(step - 1);
                index = 0;
                step--;
            }
            if (step == items.size()) {
                step = 0;
            }

            index++;
            step++;
        }

        PrintWriter out = new PrintWriter(System.out);
        out.println(items.get(0));
        out.flush();
    }
}
