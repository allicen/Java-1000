package hamming_distance;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class HammingDistance {
    private static int byteCount(String line, String template) {
        int count = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == template.charAt(i)) {
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        int index = -1;
        String template = "";
        int minWay = Integer.MIN_VALUE;
        ArrayList<Integer> messageIndex = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (index == -1) {
                template = line;
            } else if (index != 0) {
                int byteCount = byteCount(line, template);
                if (minWay < byteCount) {
                    minWay = byteCount;
                    messageIndex.clear();
                    messageIndex.add(index);
                } else if (minWay == byteCount) {
                    messageIndex.add(index);
                }
            }
            index++;
        }

        PrintWriter out = new PrintWriter(System.out);
        out.println(messageIndex.size());
        for (int number: messageIndex) {
            out.print(number + " ");
        }
        out.flush();
    }
}
