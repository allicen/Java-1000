package last_digit;

import java.io.*;
import java.util.*;

public class LastDigit{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int base = in.nextInt() % 10;
        int exponent = in.nextInt() % 10;
        long result = (long) Math.pow(base, exponent);
        result = (base == 0) ? 0 : result % 10;

        out.println(result);
        out.flush();
    }
}
