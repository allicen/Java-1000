package honey;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Honey {
    public static void main(String[] args) throws IOException {
        ArrayList<Long> data = new ArrayList<>();
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        while (st.hasMoreTokens()){
            data.add(Long.valueOf(st.nextToken()));
        }
        long n = data.get(0);
        long v = data.get(1);
        long k = data.get(2);

        boolean empty = false;
        long honey = 0;
        long minus = k;

        for(int i = 0; i < n; i++){
            if(i == 0){
                honey += v;
            }else {
                if(minus >= v){
                    minus = v;
                    empty = true;
                }
                honey += (v - minus);
                minus += k;
            }
        }

        String result = (empty) ? "NO " + honey : "YES " + honey;

        FileWriter out = new FileWriter("output.txt");
        out.write(result);
        out.close();
    }
}
