package substrings_identical_letters;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SubstringsIdenticalLetters {
    public static void main(String[] args) throws IOException {
        int result = 0;
        String line = new Scanner(new FileReader("input.txt")).nextLine();
        char[] chars = line.toCharArray();

        for (char symbol : chars) {
            if (line.indexOf(symbol) != line.lastIndexOf(symbol)) {
                int diffs = line.lastIndexOf(symbol) - line.indexOf(symbol);
                if (diffs > result) {
                    result = diffs;
                }
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        out.println(result);
        out.flush();
    }
}
