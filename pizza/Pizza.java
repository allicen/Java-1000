package pizza;

import java.util.*;
import java.io.*;

public class Pizza {
    private static int cutCount;
    private static void getData() throws IOException{ // Получение данных
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        cutCount = sc.nextInt();
    }

    public static void main(String[] argv) throws IOException{
        getData();
        int d = 1; // Насколько увеличивается количество кусков при следующем разрезе
        for(int i = 1; i < cutCount; i++){
            d = d + i;
        }
        int pieceCount = cutCount + d; // Всего количество кусков
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(String.valueOf(pieceCount));
        pw.close();
    }
}
