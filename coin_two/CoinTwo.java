package coin_two;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CoinTwo {
    public static void main(String[] args) throws IOException {
        FileReader file = new FileReader("input.txt");
        Scanner scan = new Scanner(file);
        StringTokenizer st = new StringTokenizer(scan.nextLine(), " ");
        long n = Integer.valueOf(st.nextToken());
        long w = Integer.valueOf(st.nextToken());
        long d = Integer.valueOf(st.nextToken());
        long p = Long.valueOf(st.nextToken());

        long numberBasket = 0;
        int rightWeight = 0;

        for(int i = 1; i < n; i++){
            rightWeight += (w * i);
        }

        numberBasket = rightWeight == p ? n : (rightWeight - p) / d;

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(numberBasket));
        out.close();
    }
}
