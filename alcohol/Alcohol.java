package alcohol;

import java.io.*;
import java.util.*;

public class Alcohol {
    public static void main(String[] args) throws IOException {
        ArrayList<Long> data = new ArrayList<>();
        long count = 0;
        long c, h, o;
        String str;
        FileReader file = new FileReader("input.txt"); // Считывание данных из файла
        Scanner sc = new Scanner(file);
        str = sc.nextLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        while(st.hasMoreTokens()){
            data.add (Long.valueOf(st.nextToken()));
        }
        c = data.get(0) / 2;
        h = data.get(1) / 6;
        o = data.get(2);
        if(c > 0 && h > 0 && o > 0){
            count = (c < h && c < o) ? c :
                    (h < c && h < o) ? h : o;
        }
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(String.valueOf(count));
        fileOut.close();
    }
}
