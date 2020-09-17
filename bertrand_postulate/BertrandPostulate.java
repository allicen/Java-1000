package bertrand_postulate;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class BertrandPostulate {
    /**
     * @param number Число
     * @return true если число простое, false - иначе
     * */
    private static boolean simple(int number) {
        double sqrt = Math.sqrt(number);

        if(number == 1 || number == 2) return true;
        if(number % 2 == 0) return false;

        for(int i = 3; i <= sqrt; i += 2){
            if(number % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        int countSimpleNumber = 0;
        int n = new Scanner(new FileReader("input.txt")).nextInt();

        for (int i = n+1; i < 2*n; i++) {

            if (simple(i)) {
                countSimpleNumber++;
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        out.println(countSimpleNumber);
        out.flush();
    }
}
