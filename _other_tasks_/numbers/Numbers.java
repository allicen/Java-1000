package _other_tasks_.numbers;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        String first = sc.nextLine().replaceAll("zero", "0").replaceAll("one", "1");
        String second = sc.nextLine().replaceAll("zero", "0").replaceAll("one", "1");

        BigInteger firstLong = new BigInteger(first);
        BigInteger secondLong = new BigInteger(second);

        if (firstLong.compareTo(secondLong) > 0) {
            out.println(">");
        } else if (secondLong.compareTo(firstLong) > 0) {
            out.println("<");
        } else {
            out.println("=");
        }

        out.flush();
    }
}
