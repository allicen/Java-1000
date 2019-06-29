package manhattan_streets;

import java.util.*;
import java.io.*;

public class ManhattanStreets {
    private static ArrayList<Long> data = new ArrayList<>();
    private static long result;
    private static void area(){
        long avenue = data.get(0);
        long street = data.get(1);
        long width = data.get(2);
        long height = data.get(3);
        long areaOneCroossroad = width * width; // Площадь 1 перекрестка
        long crossroadCount = avenue * street; // Количество перекрестков
        long areaAvenue = avenue * (width * height - street * areaOneCroossroad); // Площадь авеню без учета перекрестков
        long areaStreet = street * (width * height - avenue * areaOneCroossroad); // Площадь улиц без учета перекрестков
        result = areaAvenue + areaStreet + areaOneCroossroad * crossroadCount; // Общая площадь
    }

    public static void main(String[] argv) throws IOException{
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        String str = sc.nextLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        while (st.hasMoreTokens()){
            data.add(Long.valueOf(st.nextToken()));
        }
        area();
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(String.valueOf(result));
        pw.close();
    }
}
