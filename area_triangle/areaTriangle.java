package area_triangle;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import static java.math.BigDecimal.ROUND_HALF_UP;

public class areaTriangle {
    public static void main(String[] args) throws IOException {
        ArrayList<Double> point = new ArrayList<>();
        double a, b, c, p;
        String str;
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            str = sc.nextLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            while (st.hasMoreTokens()){
                point.add(Double.valueOf(st.nextToken()));
            }
        }
        // Находим длины сторон треугольника
        a = Math.sqrt(Math.pow(point.get(3) - point.get(1), 2) + Math.pow(point.get(2) - point.get(0), 2));
        b = Math.sqrt(Math.pow(point.get(5) - point.get(3), 2) + Math.pow(point.get(4) - point.get(2), 2));
        c = Math.sqrt(Math.pow(point.get(5) - point.get(1), 2) + Math.pow(point.get(4) - point.get(0), 2));
        // Находим p для формулы Герона
        p = (a + b + c) /2;
        // Вычисляем площадь по формуле Герона, округляем до 2(!) знаков после запятой, используем тип BigDecimal для больших чисел
        BigDecimal result = new BigDecimal(Math.sqrt(p * (p -a) * (p - b) * (p - c))).setScale(2,ROUND_HALF_UP);
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(String.valueOf(result));
        fileOut.close();
    }
}
