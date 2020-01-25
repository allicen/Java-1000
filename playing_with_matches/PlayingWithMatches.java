package playing_with_matches;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PlayingWithMatches {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        int countMatches = sc.nextInt();
        String result = countMatches % 3 == 0 ? "2" : "1";

        FileWriter out = new FileWriter("output.txt");
        out.write(result);
        out.close();
    }
}
