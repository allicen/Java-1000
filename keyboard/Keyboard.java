package keyboard;

import java.io.*;
import java.util.*;

public class Keyboard {
    private static String result;
    public static void main(String[] args) throws IOException {
        String allButton = "qwertyuiopasdfghjklzxcvbnm"; // Все символы клавиатуры
        String str;
        FileReader file = new FileReader("input.txt"); // Считывание данных из файла
        Scanner sc = new Scanner(file);
        str = sc.nextLine();
        char[] ch = allButton.toCharArray(); // Переписываем символы строки в массив
        for(int i = 0; i < allButton.length(); i++){
            if(str.equals(String.valueOf(ch[i]))){ // Если символ в строке совпал с символом из файла
                if(i+1 < allButton.length()){ // Если есть еще 1 символ в строке
                    result = String.valueOf(ch[i+1]); // Находим следующий символ
                }else {
                    result = String.valueOf(ch[0]); // Если в строке нет символов далее, то начать сначала
                }
            }
        }
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(result);
        fileOut.close();
    }
}
