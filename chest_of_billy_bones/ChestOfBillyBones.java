package chest_of_billy_bones;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ChestOfBillyBones {
    public static void main(String[] args) throws IOException {
        String[] line = new Scanner(new FileReader("input.txt")).nextLine().split(" ");
        int x = Integer.parseInt(line[0]);
        int y = Integer.parseInt(line[1]);

        int[] result = new int[x];
        for (int second = 0; second < y - second; second++) {
            for (int first = second+1; first <= y - second; first++) {
                result[0] = first;
                result[1] = second;
                for (int i = 2; i < x; i++) {
                    result[i] = result[i-1] + result[i-2];
                }
                if (result[x-1] == y) {
                    PrintWriter out = new PrintWriter(System.out);
                    out.println(first + " " + second);
                    out.flush();
                    return;
                }
            }
        }
    }
}
