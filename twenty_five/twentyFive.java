package twenty_five;

import java.io.*;
import java.util.*;

public class twentyFive {
    public static void main(String[] args) throws IOException {
        long strInt;
        long out;
        String str;
        FileReader file = new FileReader("input.txt"); // Считывание данных из файла
        Scanner sc = new Scanner(file);
        str = sc.nextLine();
        strInt = Integer.valueOf(str);
        out = (long) Math.pow(strInt, 2);
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(String.valueOf(out));
        fileOut.close();
    }
}
