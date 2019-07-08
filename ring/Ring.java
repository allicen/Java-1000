package ring;

import java.util.*;
import java.io.*;

public class Ring {
    private static ArrayList<Double> data = new ArrayList<>();
    private static void getData() throws IOException{ // Получение данных
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        String str = sc.nextLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        while (st.hasMoreTokens()){
            data.add(Double.valueOf(st.nextToken()));
        }
    }

    public static void main(String[] argv) throws IOException{
        getData();
        double r = Math.sqrt((Math.PI * Math.pow(data.get(1), 2) - data.get(0)) / Math.PI); // Используем формулу нахождения площади кольца
        String rformat = String.format("%.3f", r).replaceAll(",", "."); // Приводим число к нужному формату
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(String.valueOf(rformat));
        pw.close();
    }
}

