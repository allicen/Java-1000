package unix;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class Unix {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        String[] numbersInput = sc.nextLine().split(" ");
        BigInteger oneNumber = new BigInteger(numbersInput[0], 3);
        BigInteger twoNumber = new BigInteger(numbersInput[1], 3);

        BigInteger sum = new BigInteger(String.valueOf(oneNumber.add(twoNumber)), 10);

        PrintWriter out = new PrintWriter(System.out);
        out.println(sum);
        out.flush();
    }
}
