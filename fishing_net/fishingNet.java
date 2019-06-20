package fishing_net;

import java.io.*;
import java.util.*;

public class fishingNet {
    public static void main(String[] args) throws IOException {
        int node = 1;
        String str;
        FileReader file = new FileReader("input.txt"); // Считывание данных из файла
        Scanner sc = new Scanner(file);
        str = sc.nextLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        while(st.hasMoreTokens()){
            node = node * (Integer.valueOf(st.nextToken()) - 1);
        }
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(String.valueOf(node));
        fileOut.close();
    }
}
