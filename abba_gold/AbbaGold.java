package abba_gold;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class AbbaGold {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        String[] numbers = sc.nextLine().split(" ");
        BigInteger a = new BigInteger(numbers[0]);
        BigInteger b = new BigInteger(numbers[1]);
        BigInteger c = new BigInteger(numbers[2]);

        BigInteger result = a.max(b).max(c);
        PrintWriter out = new PrintWriter(System.out);
        out.println(result);
        out.flush();
    }
}
