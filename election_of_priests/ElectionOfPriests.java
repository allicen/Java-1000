package election_of_priests;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ElectionOfPriests {
    public static void main(String[] args) throws IOException {
        Map<Integer, Integer> priests = new HashMap<>();
        Map<Integer, Integer> change = new HashMap<>();

        Scanner sc = new Scanner(new FileReader("input.txt"));
        int lineNumber = 0;
        while (sc.hasNextLine()){
            String line = sc.nextLine();
            if(lineNumber == 1){
                StringTokenizer st = new StringTokenizer(line, " ");
                int i = 1;
                while (st.hasMoreTokens()){
                    priests.put(i, Integer.valueOf(st.nextToken()));
                    i++;
                }
            }else if(lineNumber > 2){
                StringTokenizer st = new StringTokenizer(line, " ");
                change.put(Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken()));
            }
            lineNumber++;
        }

        StringBuilder result = new StringBuilder();
        for(int i : priests.keySet()){
            if(change.containsKey(priests.get(i))){
                result.append(change.get(priests.get(i))).append(" ");
            }else {
                result.append(priests.get(i)).append(" ");
            }
        }

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(result));
        out.close();
    }
}
