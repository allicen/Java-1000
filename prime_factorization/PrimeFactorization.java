package prime_factorization;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PrimeFactorization {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        long number = sc.nextLong();

        StringBuilder result = new StringBuilder();

        int n = 2;
        while (n <= Math.sqrt(number)){
            if(number % n == 0){
                result.append(n);
                number /= n;
                if (number > 1) result.append("*");
            }else  n++;
        }
        if(number > 1)result.append(number);
        System.out.println(result);

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(result));
        out.close();
    }
}
