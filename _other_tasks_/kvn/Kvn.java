package _other_tasks_.kvn;

import java.io.PrintWriter;
import java.util.Scanner;

public class Kvn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line1 = sc.nextLine().split(" ");
        String[] line2 = sc.nextLine().split(" ");

        int play = 120;
        int obzor = 20;
        int obzorObzor = 3;

        long max = obzorObzor * Integer.parseInt(line1[0]) + obzor * Integer.parseInt(line1[1]) + play * Integer.parseInt(line1[2]);
        long mel = obzorObzor * Integer.parseInt(line2[0]) + obzor * Integer.parseInt(line2[1]) + play * Integer.parseInt(line2[2]);

        PrintWriter out = new PrintWriter(System.out);

        if (mel > max) {
            out.println("Mel");
        } else if (max > mel) {
            out.println("Max");
        } else {
            out.println("Draw");
        }
        out.flush();
    }
}
