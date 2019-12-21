package similar_arrays;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class SimilarArrays {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        int i = 0;

        Set<Integer> firstSet = new HashSet<>();
        Set<Integer> secondSet = new HashSet<>();

        while (sc.hasNextLine()){
            String str = sc.nextLine();
            if(i != 0){
                StringTokenizer st = new StringTokenizer(str, " ");
                if(i == 1){
                    while (st.hasMoreTokens()){
                        firstSet.add(Integer.valueOf(st.nextToken()));
                    }
                }else {
                    while (st.hasMoreTokens()){
                        secondSet.add(Integer.valueOf(st.nextToken()));
                    }
                }
            }
            i++;
        }

        String result = firstSet.equals(secondSet) ? "1" : "0";

        FileWriter out = new FileWriter("output.txt");
        out.write(result);
        out.close();
    }
}
