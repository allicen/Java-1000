package oversteping;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class Oversteping {
    public static void main(String[] agrs) throws IOException {
        String[] data = new Scanner(new FileReader("input.txt")).nextLine().split(" ");
        int n = Integer.parseInt(data[0]);
        BigInteger m = new BigInteger(data[1]);

        BigInteger pow = BigInteger.TWO.pow(n);

        BigInteger answer = BigInteger.TWO.modPow(pow, m);

        PrintWriter out = new PrintWriter(System.out);
        out.println(answer);
        out.flush();
    }
}
