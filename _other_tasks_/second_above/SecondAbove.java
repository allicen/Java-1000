package _other_tasks_.second_above;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class SecondAbove {
    public static void main(String[] args) throws IOException {
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);

        ArrayList<Integer> data = new ArrayList<>();

        while (sc.hasNextLine()) {
            int num = Integer.parseInt(sc.nextLine());

            if (num != 0) {
                data.add(num);
            } else {
                data.sort(Comparator.reverseOrder());
                PrintWriter out = new PrintWriter(System.out);

                out.println(data.get(1));
                out.flush();
            }
        }
    }
}
