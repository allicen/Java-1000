package gardener_artist;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GardenerArtist {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        int number = sc.nextInt();
        int colorCount = 3;

        long count = (long) (colorCount * Math.pow(2, number-1));

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(count));
        out.close();
    }
}
