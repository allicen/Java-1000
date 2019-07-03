package rook;

import java.util.*;
import java.io.*;

public class Rook {
    private static ArrayList<Long> data = new ArrayList<>();

    private static void getData() throws IOException{
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        String str = sc.nextLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        while (st.hasMoreTokens()){
            data.add(Long.valueOf(st.nextToken()));
        }
    }

    public static void main(String[] argv) throws IOException{
        getData();
        long x = data.get(0);
        long y = data.get(1);

        String result = (x == 1 && y == 1) ? "0" :
                (x == y) ? "2" : "1";

        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(result);
        pw.close();
    }
}
