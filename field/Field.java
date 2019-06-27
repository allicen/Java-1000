package field;

import java.io.*;
import java.util.*;

public class Field {
    public static void main(String[] args) throws IOException {
        ArrayList<Long> data = new ArrayList<>();
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        String str = sc.nextLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        while (st.hasMoreTokens()){
            data.add(Long.valueOf(st.nextToken()));
        }
        long areaRect = data.get(0) * data.get(1); // Площадь прямоугольника
        long sqrt = (long) Math.sqrt(areaRect); // Площадь стороны квадрата, если квадрат существует
        long result = (Math.pow(sqrt, 2) == areaRect) ? sqrt : 0; // Расчет результата
        System.out.println(result);
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(String.valueOf(result));
        fileOut.close();
    }
}
