package factorial;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        String[] line = sc.nextLine().split(" ");

        int number = Integer.valueOf(line[0]);
        int factorials = line[1].length();

        int result = number;
        int k = 1;
        while (number - k * factorials > 0){
            result *= (number - k * factorials);
            k++;
        }

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(result));
        out.close();
    }
}
