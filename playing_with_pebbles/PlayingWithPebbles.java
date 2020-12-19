package playing_with_pebbles;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class PlayingWithPebbles {
    public static void main(String[] args) throws IOException {
        int n = new Scanner(new FileReader("input.txt")).nextInt();
        int[] results = new int[n+1];

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= (i-1)/2; j++) {
                if (results[i - j] == 0) {
                    results[i] = 1;
                    break;
                }
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        if (results[n] == 0) {
            out.println(0);
        } else {
            for (int i = 1; i <= n; i++) {
                if (results[n-i] == 0) {
                    out.println(i);
                    break;
                }
            }
        }

        out.flush();
    }
}
