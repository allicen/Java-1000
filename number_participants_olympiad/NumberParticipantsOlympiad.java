package number_participants_olympiad;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class NumberParticipantsOlympiad {
    public static void main (String[] args) throws IOException {
        Scanner scan = new Scanner(new FileReader("input.txt"));
        String[] items = scan.nextLine().split(" ");
        int k = Integer.parseInt(items[0]);
        int n = Integer.parseInt(items[1]);
        int m = Integer.parseInt(items[2]);
        int d = Integer.parseInt(items[3]);

        int itemCount = 0;
        for (int item = 1; item <= (k*m*n*d); item++) {
            if ((item % k == 0 && item % n == 0 && item % m == 0) && (item /k + item /n + item /m == item - d)) {
                itemCount = item;
                break;
            }
        }

        itemCount = itemCount > 0 ? itemCount : -1;

        PrintWriter out = new PrintWriter(System.out);
        out.println(itemCount);
        out.flush();
    }
}
