package palindrome;

import java.io.*;
import java.util.*;

public class Palindrome {
    public static void main(String[] args) throws IOException {
        ArrayList<String> number = new ArrayList<>(); // Прямой порядок символов
        ArrayList<String> numberReverse = new ArrayList<>(); // Обратный порядок символов
        String result;
        String str;
        FileReader file = new FileReader("input.txt"); // Считывание данных из файла
        Scanner sc = new Scanner(file);
        str = sc.nextLine();
        char[] ch = str.toCharArray();
        for (char aCh : ch) {
            number.add(String.valueOf(aCh));
        }
        for(int j = ch.length; j >0; j--){ // Записать в коллекцию в обратном порядке
            numberReverse.add(String.valueOf(ch[j-1]));
        }
        result = (number.equals(numberReverse)) ? "YES" : "NO";
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(result);
        fileOut.close();
    }
}
