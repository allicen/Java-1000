package Not_deaf_phone;
import java.io.*;
import java.util.*;
public class NotDeafPhone {
    public static void main(String[] args) throws IOException {
        String str;
        FileReader fin = new FileReader("input.txt"); // Получение числа из файла
        Scanner sc = new Scanner(fin);
        str = sc.nextLine();
        FileWriter countStepFinish = new FileWriter("output.txt");// Запись числа в файл
        countStepFinish.write(str);
        countStepFinish.close();
    }
}