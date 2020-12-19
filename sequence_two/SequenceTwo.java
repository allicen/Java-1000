package sequence_two;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class SequenceTwo {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        int n = Integer.parseInt(sc.nextLine());
        String[] line = sc.nextLine().split(" ");
        ArrayList<Integer> numbers = new ArrayList<>();

        for (String number :  line) {
            numbers.add(Integer.parseInt(number));
        }

        int leftMax = -1000000;

        for (int i = 0; i < numbers.size(); i++) {
            if (leftMax < numbers.get(i)) {
                leftMax = numbers.get(i);
            }
            if (i > 0 && i+1 < numbers.size()) {
                for (int k = i+1; k < numbers.size(); k++) {
                    if (numbers.get(i) < leftMax && numbers.get(i) < numbers.get(k)) {
                        numbers.remove(i);
                        i--;
                        break;
                    }
                }
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        out.println(numbers.size());
        for (int number : numbers) {
            out.print(number + " ");
        }
        out.flush();
    }
}
