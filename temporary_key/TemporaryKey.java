package temporary_key;

import java.util.*;
import java.io.*;

public class TemporaryKey {
    private static int number;

    private static void getData() throws IOException{
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        number = Integer.valueOf(sc.nextLine());
    }

    public static void main(String[] argv) throws IOException{
        getData();
        int n = number; // Исходное число
        int s = 0; // Добавочное число
        while (number > 0){
            if(number % 2 == 1){
                s++;
            }
            number = number / 2;
        }
        int newKey = n + s;
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(String.valueOf(newKey));
        pw.close();
    }

}
