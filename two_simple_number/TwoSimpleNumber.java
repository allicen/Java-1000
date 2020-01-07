package two_simple_number;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TwoSimpleNumber {
    private static boolean isSimple(long number){
        double sq = Math.sqrt(number);
        if(number == 1 || number == 2) return true;
        if(number % 2 == 0) return false;
        for(long i = 3; i <= sq; i += 2){
            if(number % i == 0) return false;
        }
        return true;
    }

    private static long fromListToNumber(ArrayList symbols){
        StringBuilder number = new StringBuilder();
        for (Object symbol : symbols) {
            number.append(symbol);
        }
        return Long.valueOf(String.valueOf(number));
    }


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        String number = sc.nextLine();

        boolean isSimple = true;
        ArrayList<Integer> symbols = new ArrayList<>();

        char[] ch = number.toCharArray();
        for(char i : ch){
            if(i - '0' == 0) {
                isSimple = false;
                break;
            } else {
                symbols.add(i - '0');
            }
        }
        if(isSimple){
            Collections.sort(symbols);
            long up = fromListToNumber(symbols);
            isSimple = isSimple(up);
            if(isSimple){
                symbols.sort(Collections.reverseOrder());
                long reverse = fromListToNumber(symbols);
                isSimple = isSimple(reverse);
            }
        }

        String result = isSimple ? "Yes" : "No";

        FileWriter out = new FileWriter("output.txt");
        out.write(result);
        out.close();
    }
}
