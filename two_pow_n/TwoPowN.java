package two_pow_n;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class TwoPowN {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        int numberInput = sc.nextInt();

        BigInteger result = BigInteger.TWO.pow(numberInput);

        PrintWriter out = new PrintWriter(System.out);
        out.println(result);
        out.flush();
    }
}
