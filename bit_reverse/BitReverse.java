package bit_reverse;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class BitReverse {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        long data = sc.nextInt();
        String dataSystemTwo = new BigInteger(String.valueOf(data)).toString(2);

        char[] ch = dataSystemTwo.toCharArray();
        StringBuilder revers = new StringBuilder();
        for(int i = ch.length-1; i >= 0; i--){
            revers.append(String.valueOf(ch[i]));
        }

        String reversNumber = revers.length() > 0 ? String.valueOf(revers) : "0";
        BigInteger reversSystemTen = new BigInteger(reversNumber, 2);

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(reversSystemTen));
        out.close();
    }
}
