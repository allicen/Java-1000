package digits_after_point;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DigitsAfterPoint {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        int a = Integer.valueOf(st.nextToken());
        int b = Integer.valueOf(st.nextToken());
        int k = Integer.valueOf(st.nextToken());

        String symbol;

        if(a % b == 0){
            symbol = "0";
        }else {
            BigDecimal c = new BigDecimal(String.valueOf(a));
            BigDecimal d = new BigDecimal(String.valueOf(b));
            BigDecimal div;
            if(k > 6 && (b != 7)){
                div = c.divide(d, 6, RoundingMode.DOWN);
            }else {
                div = c.divide(d, k%6, RoundingMode.DOWN);
            }
            String number = String.valueOf(div);
            symbol = number.substring(number.length()-1);

        }

        FileWriter out = new FileWriter("output.txt");
        out.write(symbol);
        out.close();
    }
}
