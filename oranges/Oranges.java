package oranges;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Oranges {
    private static long decision(long a, long b){
        if(a * b == 0){
            return a + b;
        }
        if(a < b){
            return  decision(a, b % a);
        }else {
            return decision(a % b, b);
        }
    }

    public static void main(String[] args) throws IOException {
        long friends = 0;
        long oranges = 0;

        Scanner sc = new Scanner(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        while (st.hasMoreTokens()){
            friends = Integer.valueOf(st.nextToken());
            oranges = Integer.valueOf(st.nextToken());
        }

        long result;

        if(oranges % friends == 0){
            result = 1;
        }else {
            result = friends/decision(friends, oranges);
        }

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(result));
        out.close();
    }
}
