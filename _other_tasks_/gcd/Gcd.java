package _other_tasks_.gcd;
// https://official.contest.yandex.ru/rucode5.0/contest/35546/problems/?success=67521304#7/2016_07_22/HvuFCYTXtU
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Gcd {
    static int gcd(int a, int b) {
        if (a == 0 || b == 0) {
            return a + b;
        }
        if (a > b) {
            return gcd(a % b, b);
        } else {
            return gcd(a, b % a);
        }
    }

    public static void main(String[] args) throws IOException {
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        int a = Integer.parseInt(sc.nextLine());
        int b = Integer.parseInt(sc.nextLine());
        int result = gcd(a, b);

        PrintWriter out = new PrintWriter(System.out);
        out.println(result);
        out.flush();
    }
}
