package binary_numbers;

import java.io.*;
import java.util.*;

public class BinaryNumbers {
    public static void main(String[] args) throws IOException {
        String out = "YES";
        String str;
        FileReader file = new FileReader("input.txt"); // Считывание данных из файла
        Scanner sc = new Scanner(file);
        str = sc.nextLine();
        int strInt = Integer.valueOf(str);
        if(strInt <= 0){
            out = "NO";
        }else{
            while(strInt > 1){
                if(strInt%2 == 0){ // Проверка четности остатка
                    strInt = strInt / 2; // Следующее число
                }else{
                    out = "NO";
                    break;
                }
            }
        }
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(out);
        fileOut.close();
    }
}
