package teleportation;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Teleportation {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);

        Scanner sc = new Scanner(new FileReader("input.txt"));
        String[] start = sc.nextLine().split(" ");
        String[] finish = sc.nextLine().split(" ");
        int x1 = Integer.parseInt(start[0]);
        int y1 = Integer.parseInt(start[1]);
        int x2 = Integer.parseInt(finish[0]);
        int y2 = Integer.parseInt(finish[1]);

        // считаем ходы слона
        if (Math.abs(x2-x1) == Math.abs(y2-y1)) {
            out.println(1);
        } else if ((x1+y1) % 2 == (x2+y2) % 2) {
            out.println(2);
        }
        else  {
            out.println(0);
        }
        out.flush();
    }
}
