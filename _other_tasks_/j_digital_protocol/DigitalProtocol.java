package _other_tasks_.j_digital_protocol;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class DigitalProtocol {
    public static void main(String[] args) throws IOException {
        String dataStr = new Scanner(new FileReader("input.txt")).nextLine();
        BigInteger one = BigInteger.ZERO, two = BigInteger.ZERO, sum = BigInteger.ZERO;
        boolean exit = false;

        for (int i = 1; i < dataStr.length(); i++) {
            for (int j = i+1; j < dataStr.length(); j++) {

                String oneStr = dataStr.substring(0, i);
                String twoStr = dataStr.substring(i, j);
                String sumStr = dataStr.substring(j);

                if (twoStr.length() > 1 && dataStr.charAt(0) == '0') {
                    continue;
                }

                one = new BigInteger(oneStr);
                two = new BigInteger(twoStr);
                sum = new BigInteger(sumStr);

                if (one.add(two).compareTo(sum) == 0) {
                    exit = true;
                    break;
                }
            }
            if (exit) break;
        }

        PrintWriter out = new PrintWriter(System.out);
        out.println(one + "+" + two + "=" + sum);
        out.flush();
    }
}
