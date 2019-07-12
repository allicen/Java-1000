package arrows;

import java.util.*;
import java.io.*;
import java.util.regex.*;

public class Arrows {
    private static int count = 0;
    private static void arrowCount() throws IOException{ // Получение данных
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        String str = sc.nextLine(); // Формируем строку из файла
        Matcher one = Pattern.compile("(?=(>>-->)|(<--<<))").matcher(str); // Проверяем наличие всех стрелок регулярным выражением
        while (one.find()){ // Считаем количество стрелок
            count++;
        }
    }
    public static void main(String[] argv) throws IOException{
        arrowCount();
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(String.valueOf(count));
        pw.close();
    }
}
