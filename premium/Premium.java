package premium;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Premium {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        int index = 0, n = 0;
        String k = "";
        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        while (st.hasMoreTokens()){
            if(index == 0){
                n = Integer.valueOf(st.nextToken());
            }else {
                k = st.nextToken();
            }
            index++;
        }

        int numberSystem = n % 10 + 2;
        BigInteger result = new BigInteger(k, numberSystem);

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(result));
        out.close();
    }
}
