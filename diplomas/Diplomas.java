package diplomas;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class Diplomas {
    private static BigInteger maxwh (BigInteger w2, BigInteger h2) {
        if (w2.compareTo(h2) > 0) {
            return w2;
        } else return h2;
    }

    private static BigInteger maxd (BigInteger w1, BigInteger h1, BigInteger mid1) {
        return (mid1.divide(w1).multiply((mid1.divide(h1))));
    }


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        String[] numbersInput = sc.nextLine().split(" ");
        BigInteger w = new BigInteger(numbersInput[0]);
        BigInteger h = new BigInteger(numbersInput[1]);
        BigInteger n = new BigInteger(numbersInput[2]);

        BigInteger hi, lo, mid;
        hi = maxwh(w, h).multiply(n);
        lo = BigInteger.ZERO;

        while (hi.subtract(lo).compareTo(BigInteger.ONE) > 0) {
            mid = (hi.add(lo)).divide(BigInteger.TWO);
            if (maxd(w, h, mid).compareTo(n) < 0) {
                lo = mid;
            } else {
                hi = mid;
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        out.println(hi);
        out.flush();
    }
}