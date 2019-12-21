package multiplication_table;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MultiplicationTable {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());

        int numeral = 10;
        Map<Integer, Integer> out = new HashMap<Integer, Integer>() {{
            put(0, 0);
            put(1, 0);
            put(2, 0);
            put(3, 0);
            put(4, 0);
            put(5, 0);
            put(6, 0);
            put(7, 0);
            put(8, 0);
            put(9, 0);
        }};

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                int multi = i * j;
                while (multi != 0){
                    int search = multi % 10;
                    out.put(search, out.get(search) + 1);
                    multi /= 10;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < numeral; i++){
            if(out.containsKey(i)){
                result.append(String.valueOf(out.get(i)));
            }else {
                result.append("0");
            }
            result.append("\n");
        }

        FileWriter output = new FileWriter("output.txt");
        output.write(String.valueOf(result).trim());
        output.close();
    }
}
