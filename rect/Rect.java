package rect;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Rect {
    public static void main(String[] args) throws IOException {
        String[] sides = new Scanner(new FileReader("input.txt")).nextLine().split(" ");
        int w = Integer.parseInt(sides[0]);
        int h = Integer.parseInt(sides[1]);
        long res = 0;

        for (int i = 1; i <= w; i++) {
            for (int j = 1; j <= h; j++) {
                res += i*j;
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        out.print(res);
        out.flush();
    }
}
