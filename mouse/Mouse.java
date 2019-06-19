package mouse;

import java.io.*;
import java.util.*;

public class Mouse {
    public static void main(String[] args) throws IOException {
        ArrayList<Long> size = new ArrayList<>();
        String out;
        String str;
        FileReader file = new FileReader("input.txt"); // Считывание данных из файла
        Scanner sc = new Scanner(file);
        str = sc.nextLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        while(st.hasMoreTokens()){
            size.add(Long.valueOf(st.nextToken()));
        }
        out = (size.get(2)*2 <= size.get(0) && size.get(2)*2 <= size.get(1)) ? "YES" : "NO";
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(out);
        fileOut.close();
    }
}
