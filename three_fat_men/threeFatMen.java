package three_fat_men;

import java.io.*;
import java.util.*;

public class threeFatMen {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> weight = new ArrayList<>();
        boolean error = false;
        String out;
        String str;
        FileReader file = new FileReader("input.txt"); // Считывание данных из файла
        Scanner sc = new Scanner(file);
        str = sc.nextLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        while(st.hasMoreTokens()){
            weight.add(Integer.valueOf(st.nextToken()));
        }
        for (Integer aWeight : weight) {
            if (aWeight < 94 || aWeight > 727) {
                error = true;
            }
        }
        weight.sort(Collections.reverseOrder()); // Сортировка в обратном порядке
        out = (error) ? "Error" : String.valueOf(weight.get(0));
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(out);
        fileOut.close();
    }
}
