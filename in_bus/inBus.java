package in_bus;

import java.util.*;
import java.io.*;

public class inBus {
    private static ArrayList<Integer> data = new ArrayList<>();
    private static void getData() throws IOException{ // Получение данных
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
        int min = (data.get(0) >= data.get(1)) ? data.get(0) : data.get(1);
        int max = (data.get(1) == 0) ? data.get(0) : data.get(0) + (data.get(1) - 1);
        String result = (data.get(0) == 0 && data.get(1) == 0) ? 0 + " " + 0 :
                (data.get(0) != 0) ? min + " " + max : "Impossible";
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(result);
        pw.close();
    }
}
