package unit;

import java.io.*;
import java.util.*;

public class Unit {
    public static void main(String[] args) throws IOException {
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        long number = Long.valueOf(sc.nextLine());
        long result = 0;
        while (number >= 1){
            if(number % 2 == 1){
                result++; // Увеличиваем инднекс, если в остатке единица
                number = number / 2;
            }else {
                number = number / 2;
            }

        }
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(String.valueOf(result));
        fileOut.close();
    }
}
