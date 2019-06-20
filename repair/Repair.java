package repair;

import java.io.*;
import java.util.*;

public class Repair {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> length = new ArrayList<>();
        int result;
        String str;
        FileReader file = new FileReader("input.txt"); // Считывание данных из файла
        Scanner sc = new Scanner(file);
        str = sc.nextLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        while (st.hasMoreTokens()){
            length.add(Integer.valueOf(st.nextToken())); // Записать все элементы в коллекцию
        }
        result = (2 * (length.get(0) * length.get(2) + length.get(1) * length.get(2))) / 16;
        if((2 * (length.get(0) * length.get(2) + length.get(1) * length.get(2))) % 16 != 0){
            result = result + 1;
        }
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(String.valueOf(result));
        fileOut.close();
    }
}
