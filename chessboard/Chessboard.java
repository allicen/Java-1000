package chessboard;

import java.util.*;
import java.io.*;

public class Chessboard {
    private static ArrayList<Integer> data = new ArrayList<>();

    private static void getData() throws IOException{
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        String str = sc.nextLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        while (st.hasMoreTokens()){
            data.add(Integer.valueOf(st.nextToken()));
        }
    }

    public static void main(String[] argv) throws IOException{
        getData();
        int widht = data.get(0); // Ширина поля
        int height = data.get(1); // Высота поля
        int x = data.get(2); // 1 координата точки
        int y = data.get(3); // 2 координата точки
        int color = data.get(4); // Цвет точки
        String result = (widht % 2 == 0 || (widht % 2 == 1 && height % 2 == 0)) ? "equal" :
                (color == 0 && (x % 2 == y % 2)) ? "black" :
                        (color == 1 && (x % 2 == y % 2)) ? "white" :
                                (color == 0  && (x % 2 != y % 2)) ? "white" : "black";
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(result);
        pw.close();
    }
}
