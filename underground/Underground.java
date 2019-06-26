package underground;

import java.io.*;
import java.util.*;

public class Underground {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> data = new ArrayList<>();
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        String str = sc.nextLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        while (st.hasMoreTokens()){
            data.add(Integer.valueOf(st.nextToken()));
        }
        int a = Math.abs(data.get(1) - data.get(2)) - 1; // Если едем прямо
        int b = (data.get(1) > data.get(2)) ? data.get(2) + Math.abs(data.get(0) - data.get(1)) - 1 : data.get(1) + (data.get(0) - data.get(2)) - 1; // Если едем в обратную сторону
        int result = (a > b) ? b : a;
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(String.valueOf(result));
        fileOut.close();
    }
}
