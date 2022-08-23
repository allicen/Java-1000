package known_everybody;

import java.io.*;
import java.util.*;

public class KnownEverybody {
    private static String result = "YES"; // Значение по умолчанию
    public static void main(String[] args) throws IOException {
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        String str = sc.nextLine();
        char[] ch = str.toCharArray();
        for (char aCh : ch) {
            int symbol = Character.getNumericValue(aCh);
            if (symbol == 0) {
                result = "NO"; // Если есть хотя бы 1 ноль
                break;
            }
        }
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(result);
        fileOut.close();
    }
}
