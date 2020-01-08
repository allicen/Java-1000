package reverse_permutation;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ReversePermutation {
    public static void main(String[] args) throws IOException {
        Map<Integer, Integer> list = new TreeMap<>();
        Scanner sc = new Scanner(new FileReader("input.txt"));
        int index = 0;
        int step = 1;
        while (sc.hasNextLine()){
            StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
            while (st.hasMoreTokens()){
                int number = Integer.valueOf(st.nextToken());
                if(index != 0){
                    list.put(number, step);
                    step++;
                }
            }
            index++;
        }

        StringBuilder result = new StringBuilder();

        for (int i : list.keySet()){
            result.append(list.get(i)).append(" ");
        }

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(result).trim());
        out.close();

    }
}
