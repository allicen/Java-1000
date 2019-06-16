package arithmetic;

import java.util.*;
import java.io.*;

public class Arithmetic {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> number = new ArrayList<>();
        String summ;
        String str;
        FileReader file = new FileReader("input.txt"); // Считывание данных из файла
        Scanner sc = new Scanner(file);
        str = sc.nextLine(); // 1 цифра
        StringTokenizer st = new StringTokenizer(str, " ");
        while (st.hasMoreTokens()){
            number.add(Integer.valueOf(st.nextToken()));
        }
        summ = (number.get(0) * number.get(1) == number.get(2)) ? "YES" : "NO";
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(summ);
        fileOut.close();
    }
}
