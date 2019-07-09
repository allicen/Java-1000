package two_ring;

import java.util.*;
import java.io.*;

public class TwoRing {
    private static ArrayList<Integer> data = new ArrayList<>();
    private static void getData() throws IOException{ // Получение данных
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            String str = sc.nextLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            while (st.hasMoreTokens()){
                data.add(Integer.valueOf(st.nextToken()));
            }
        }
    }

    public static void main(String[] argv) throws IOException{
        getData();
        int r = (int) Math.sqrt(Math.pow((data.get(3) - data.get(0)), 2) + Math.pow((data.get(4) - data.get(1)), 2)); // Расчет расстояния между центрами окружностей
        String crossTwoRing = (r <= data.get(2) + data.get(5) && r + data.get(2) >= data.get(5) && r + data.get(5) >= data.get(2)) ? "YES" : "NO"; // Проверка условия существования общей точки
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(crossTwoRing);
        pw.close();
    }
}
