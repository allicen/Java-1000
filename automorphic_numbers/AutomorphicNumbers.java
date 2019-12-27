package automorphic_numbers;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AutomorphicNumbers {
    private static boolean check(long a){
        int symbolCount = String.valueOf(a).length();
        long square = (long) Math.pow(a, 2);
        int divider = 1;
        for(int i = 0; i < symbolCount; i++){
            divider *= 10;
        }
        return square % divider == a;
    }

    public static void main(String[] args) throws IOException {
        long start = 0, finish = 0;

        Scanner sc = new Scanner(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        while (st.hasMoreTokens()){
            start = Long.valueOf(st.nextToken());
            finish = Long.valueOf(st.nextToken());
        }

        StringBuilder result = new StringBuilder();
        for(long i = start; i <= finish; i++){
            boolean check = check(i);
            if(check){
                result.append(i).append(" ");
            }
        }

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(result).trim());
        out.close();
    }
}
