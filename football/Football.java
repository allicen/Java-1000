package football;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Football {
    public static void main(String[] args) throws IOException {
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        int ballCount = sc.nextInt();

        int index = 0;
        while (ballCount > 0){
            index++;
            ballCount -= index;
        }
        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(index));
        out.close();
    }
}

