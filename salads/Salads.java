package salads;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Salads {
    private static long combination(int numeric, int elementCount){
        BigInteger first = BigInteger.valueOf(1);
        BigInteger second = BigInteger.valueOf(1);
        BigInteger third = BigInteger.valueOf(1);

        int difference = numeric - elementCount;
        for ( ; numeric > 0; first = first.multiply(BigInteger.valueOf((numeric--))));
        for ( ; elementCount > 0; second = second.multiply(BigInteger.valueOf((elementCount--))));
        for ( ; difference > 0; third = third.multiply(BigInteger.valueOf((difference--))));

        BigInteger finish = first.divide(second.multiply(third));
        return Long.valueOf(String.valueOf(finish));
    }

    public static void main(String[] args) throws IOException {
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        int ingredientCount = sc.nextInt();

        long result = 0;
        if(ingredientCount > 1){
            for(int i = 2; i <= ingredientCount; i++){
                int ingredientUsed = ingredientCount - i;
                long combination = combination(ingredientCount, ingredientUsed);
                result += combination;
            }
        }

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(result));
        out.close();
    }
}
