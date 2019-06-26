package circle;

import java.io.*;
import java.util.*;

public class Circle {
    public static void main(String[] args) throws IOException {
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        String str = sc.nextLine();
        char[] ch = str.toCharArray();
        long flag = 0;
        for (char aCh : ch) {
            String symbol = Character.toString(aCh);
            switch (symbol) {
                case ("6"):
                    flag++;
                    break;
                case ("8"):
                    flag = flag + 2;
                    break;
                case ("9"):
                    flag++;
                    break;
                case ("0"):
                    flag++;
                    break;
            }
        }
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(String.valueOf(flag));
        fileOut.close();
    }
}
