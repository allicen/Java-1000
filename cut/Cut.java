package cut;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Cut {
    public static void main(String[] args) throws IOException {
        ArrayList<Double> point = new ArrayList<>(); // Координаты точек
        double result;
        String str;
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        str = sc.nextLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        while (st.hasMoreTokens()){
            point.add(Double.valueOf(st.nextToken()));
        }
        result = Math.sqrt(Math.pow(point.get(3) - point.get(1), 2) + Math.pow(point.get(2) - point.get(0), 2)); // Вычисление длины отрезка
        String pattern = "##0.00000"; // Формат вывода
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String format = decimalFormat.format(result);
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(format.replace(",",".")); // Замена запятой на точку по условиям задачи
        fileOut.close();
    }
}
