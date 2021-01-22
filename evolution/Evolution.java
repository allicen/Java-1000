package evolution;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class Evolution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        sc.nextLine();
        BigInteger first = new BigInteger(sc.nextLine());
        BigInteger second = new BigInteger(sc.nextLine());

        PrintWriter out = new PrintWriter(System.out);

        while (first.compareTo(second) != 0) {
            if (first.compareTo(second) > 0) {
                first = first.divide(BigInteger.TWO);
            } else {
                second = second.divide(BigInteger.TWO);
            }
        }
        out.println(first);
        out.flush();
    }
}
