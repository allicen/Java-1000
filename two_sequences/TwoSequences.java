package two_sequences;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TwoSequences {
    private static int[] number(int n) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(2, 3, 4, 7, 13));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(1, 5, 6, 8, 9, 10, 11, 12));

        for (int i = 14; i <= 20000; i++) {
            if (a.size() >= n && b.size() >= n) {
                break;
            } else {
                a.add(b.get(a.size()-1) + b.get(a.size()-3));
                for (int j = a.get(a.size()-2)+1; j < a.get(a.size()-1); j++) {
                    b.add(j);
                }
            }
        }
        int[] result = new int[2];
        result[0] = a.get(n-1);
        result[1] = b.get(n-1);
        return result;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        int n = sc.nextInt();

        int[] result = number(n);
        PrintWriter out = new PrintWriter(System.out);
        out.println(result[0]);
        out.println(result[1]);
        out.flush();
    }
}
