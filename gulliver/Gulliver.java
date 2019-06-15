package gulliver;

import java.io.*;
import java.util.*;

public class Gulliver {
    public static void main(String[] args) throws IOException {
        int count;
        ArrayList<Integer> number = new ArrayList<>();
        String str;
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        str = sc.nextLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        while(st.hasMoreTokens()){
            number.add(Integer.valueOf(st.nextToken()));
        }
        count = number.get(0) * number.get(0) * number.get(1);
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(String.valueOf(count));
        fileOut.close();
    }
}
