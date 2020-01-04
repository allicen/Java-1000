package simple_series;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SimpleSeries {
    private static String numbers(int number){
        StringBuilder out = new StringBuilder();
        out.append(23);
        int i = 3;
        while (out.length() < number){
            i++;
            boolean simple = true;
            for(int j = i-1; j > 1; j--){
                if(i % j == 0){
                    simple = false;
                    break;
                }
            }
            if(simple){
                out.append(i);
            }
        }
        return String.valueOf(out);
    }

    public static void main(String[] args) throws IOException {
        int max = 0;
        ArrayList<Integer> positions = new ArrayList<>();
        Scanner sc = new Scanner(new FileReader("input.txt"));
        while (sc.hasNextLine()){
            StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
            while (st.hasMoreTokens()){
                int pos = Integer.valueOf(st.nextToken());
                if (pos > max) max = pos;
                positions.add(pos);
            }
        }
        positions.remove(0);

        String str = numbers(max);
        StringBuilder result = new StringBuilder();
        for(int i : positions){
            result.append(str.charAt(i-1));
        }

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(result));
        out.close();
    }
}
