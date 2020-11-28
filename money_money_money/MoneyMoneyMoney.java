package money_money_money;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MoneyMoneyMoney {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);

        long x = new Scanner(new FileReader("input.txt")).nextLong();

        if (x % 2 == 0) {
            out.println("0 0");
        } else {

            long a = 2;
            long b = x + a;

            out.println(a + " " + b);
        }

        out.flush();
    }
}
