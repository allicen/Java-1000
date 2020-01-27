package short_sequence;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ShortSequence {
    public static void main(String[] args) throws IOException {
        StringBuilder string = new StringBuilder();

        Scanner sc = new Scanner(new FileReader("input.txt"));
        int number = sc.nextInt();

        int start = 1;
        StringBuilder memory = new StringBuilder();
        while (string.length() <= number){
            memory.append(start);
            string.append(memory);
            start++;
        }

        String result = String.valueOf(string.charAt(number-1));

        FileWriter out = new FileWriter("output.txt");
        out.write(result);
        out.close();
    }
}
