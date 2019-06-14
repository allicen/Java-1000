package beads;

import java.io.*;
import java.util.Scanner;

public class Beads {
    public static void main(String[] args) throws IOException {
        int numeric;
        String str;
        FileReader fin = new FileReader("input.txt"); // Получение числа из файла
        Scanner sc = new Scanner(fin);
        str = sc.nextLine();
        numeric = Integer.valueOf(str) + 1;
        FileWriter countStepFinish = new FileWriter("output.txt");// Запись числа в файл
        countStepFinish.write(String.valueOf(numeric));
        countStepFinish.close();
    }
}
