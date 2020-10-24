package _other_tasks_.d_reliable_tag;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class ReliableTag {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        String[] line1 = sc.nextLine().split(" ");
        String[] line2 = sc.nextLine().split(" ");

        ArrayList<Long> array = new ArrayList<>();
        for (String number: line2) {
            array.add(Long.parseLong(number));
        }

        int n = Integer.parseInt(line1[0]);
        int k = Integer.parseInt(line1[1]);
        int r = Integer.parseInt(line1[2]);

        for (int i = 0; i < r; i++) {
            long a1 = 0;
            for (int j = 0; j < k; j++) {
                a1 += array.get(j);
            }

            array.remove(0);

            if (array.size() == 0 || array.size() == 1) {
                array.add(a1);
                Collections.sort(array);
            } else {
                for (int j = 0; j < array.size(); j++) {
                    // вставить элемент в лист в порядке возрастания
                    if (j+1 < array.size() && (a1 >= array.get(j) && a1 < array.get(j+1))) {
                        ArrayList<Long> slice = new ArrayList<Long>(array.subList(j+1, array.size()));
                        array.removeAll(slice);
                        array.add(a1);
                        array.addAll(slice);
                        break;
                    }
                }

                if (array.size() < n) {
                    array.add(a1);
                }
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        for (long number: array) {
            out.print(number + " ");
        }
        out.flush();

    }
}
