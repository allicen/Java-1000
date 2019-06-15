package eniya;

import java.io.*;
import java.util.*;

public class Eniya {
    public static void main(String[] args) throws IOException {
        int weight;
        ArrayList<Integer> number = new ArrayList<>();
        String str;
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        str = sc.nextLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        while(st.hasMoreTokens()){
            number.add(Integer.valueOf(st.nextToken()));
        }
        weight = number.get(1) * number.get(2) * 2 * number.get(0);
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(String.valueOf(weight));
        fileOut.close();
    }
}
