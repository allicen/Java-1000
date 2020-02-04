package castle;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Castle {
    private static BigInteger sum(int n, int k){
        BigInteger result = BigInteger.valueOf(0);
        for (int i = 0; i < k; i++){
            BigInteger sub = BigInteger.valueOf((n-2)).multiply(BigInteger.valueOf(i));
            result = result.add(sub);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        int n = 0, k = 0;

        Scanner sc = new Scanner(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        while (st.hasMoreTokens()){
            n = Integer.valueOf(st.nextToken());
            k = Integer.valueOf(st.nextToken());
        }

        BigInteger result = BigInteger.valueOf(n-1).multiply(BigInteger.valueOf(k)).add(sum(n, k)).add(BigInteger.valueOf(1));

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(result));
        out.close();
    }
}
