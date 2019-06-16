package cake;

import java.util.*;
import java.io.*;

public class Cake {
    public static void main(String[] args) throws IOException {
        int number;
        int guest;
        String str;
        FileReader file = new FileReader("input.txt"); // Считывание данных из файла
        Scanner sc = new Scanner(file);
        str = sc.nextLine();
        guest = Integer.valueOf(str);
        number = (guest == 1) ? 0 :
                (guest % 2 == 1) ? guest : guest / 2;
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(String.valueOf(number));
        fileOut.close();
    }

}
