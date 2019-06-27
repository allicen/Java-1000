package chess_field;

import java.util.*;
import java.io.*;

public class ChessField {
    private static ArrayList<Integer> coordinate = new ArrayList<>();
    private static void getData() throws IOException{
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        String str = sc.nextLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        while (st.hasMoreTokens()){
            coordinate.add(Integer.valueOf(st.nextToken()) % 2);
        }
    }
    public static void main(String[] argv) throws IOException{
        getData();
        String result = (coordinate.get(0).equals(coordinate.get(1)) && coordinate.get(2).equals(coordinate.get(3)) ||
                !coordinate.get(0).equals(coordinate.get(1)) && !coordinate.get(2).equals(coordinate.get(3))) ? "YES" : "NO";
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(result);
        pw.close();
    }
}