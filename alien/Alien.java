package alien;

import java.io.*;
import java.util.*;

public class Alien {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> data = new ArrayList<>();
        String out;
        String str;
        FileReader file = new FileReader("input.txt"); // Считывание данных из файла
        Scanner sc = new Scanner(file);
        str = sc.nextLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        while(st.hasMoreTokens()){
            data.add(Integer.valueOf(st.nextToken()));
        }
        out = (data.get(0)*2 >= data.get(1)*2 + data.get(2)*2) ? "YES" : "NO";
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(out);
        fileOut.close();
    }
}
