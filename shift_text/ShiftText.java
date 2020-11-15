package shift_text;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ShiftText {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        String firstLine = sc.nextLine();
        String secondLine = sc.nextLine();

        int result = -1;
        int index = 0;

        for (char symbol: secondLine.toCharArray()) {

            if (firstLine.indexOf(symbol) == 0) {
                String head = secondLine.substring(index);
                String tail = secondLine.substring(0, index);

                if ((head + tail).equals(firstLine)) {
                    result = index;
                    break;
                }
            }

            index++;
        }

        PrintWriter out = new PrintWriter(System.out);
        out.println(result);
        out.flush();
    }
}
