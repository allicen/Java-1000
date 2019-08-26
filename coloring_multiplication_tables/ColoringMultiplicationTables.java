package coloring_multiplication_tables;

import java.util.*;
import java.io.*;

public class ColoringMultiplicationTables {
    private static ArrayList<Integer> data = new ArrayList<>();

    private static void getData() throws IOException{ // Получение данных
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        while (st.hasMoreTokens()){
            data.add(Integer.valueOf(st.nextToken()));
        }
    }

    private static int[] color(int n, int m){ // Раскрашиваем данные
        int blue = 0;
        int green = 0;
        int red = 0;
        int black = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(i * j % 5 == 0){
                    blue++;
                }else if(i * j % 3 == 0){
                    green++;
                }else if(i * j % 2 == 0){
                    red++;
                }else {
                    black++;
                }
            }
        }
        return new int[]{red, green, blue, black};
    }


    public static void main(String[] argv) throws IOException{
        getData();
        String[] colorName = {"RED", "GREEN", "BLUE", "BLACK"};
        StringBuilder result = new StringBuilder();
        int n = data.get(0);
        int m = data.get(1);
        int color[] = color(n, m);

        for(int i = 0; i < colorName.length; i++){ // Формируем строку
            result.append(colorName[i]).append(" : ").append(color[i]).append("\n");
        }

        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(result);
        pw.close();
    }
}
