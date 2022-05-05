package _other_tasks_.big_add_one;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class BigAddOneShort {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new FileReader("input.txt"));
        PrintWriter out = new PrintWriter(System.out);
        BigInteger num = new BigInteger(sc.nextLine());
        BigInteger res = num.add(BigInteger.ONE);

        out.println(res);
        out.flush();
    }
}
