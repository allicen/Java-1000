package multiplication_table;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MultiplicationTable {
    private static int count(int number, int search){
        int count = 0;
        while (number != 0){
            if(number % 10 == search){
                count++;
            }
            number /= 10;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());

        int numeral = 10;
        Map<Integer, Integer> out = new HashMap<>();

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                int multi = i * j;
                for(int search = 0; search < numeral; search++){
                    if(search <= multi){
                        int val = 0;
                        if(out.containsKey(search)){
                            val = out.get(search);
                        }
                       out.put(search, count(multi, search) + val);
                    }
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
