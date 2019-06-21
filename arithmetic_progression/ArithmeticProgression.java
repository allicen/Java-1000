package arithmetic_progression;

import java.io.*;
import java.util.*;

public class ArithmeticProgression {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> data = new ArrayList<>(); // Входные данные
        int step; // Шаг програессии
        int result;  // Результат вычислений
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        String str = sc.nextLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        while (st.hasMoreTokens()){
            data.add(Integer.valueOf(st.nextToken()));
        }
        step = data.get(1) - data.get(0); // Вычисление шага
        result = data.get(0) + (data.get(2) - 1) * step; // Вычисление n-члена прогрессии
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(String.valueOf(result));
        fileOut.close();
    }
}
