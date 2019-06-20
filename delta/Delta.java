package delta;

import java.io.*;
import java.util.*;

public class Delta {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> data = new ArrayList<>();
        String result;
        String str;
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        str = sc.nextLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        while (st.hasMoreTokens()){
            data.add(Integer.valueOf(st.nextToken()));
        }
        result = (data.get(0) < data.get(1) + data.get(2) && data.get(1) < data.get(0) + data.get(2) && data.get(2) < data.get(0) + data.get(1)) ? "YES" : "NO"; // Проверка на вырожденность
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(result);
        fileOut.close();
    }
}
