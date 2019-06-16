package game;

import java.util.*;
import java.io.*;

public class Game {
    public static void main(String[] args) throws IOException {
        String number; // Число-разница
        int interimNumber;
        int differenceNumber;
        String str;
        FileReader file = new FileReader("input.txt"); // Считывание данных из файла
        Scanner sc = new Scanner(file);
        str = sc.nextLine(); // 1 цифра
        interimNumber = Integer.valueOf(str);
        differenceNumber = 9 - interimNumber; // Получаем 3 цифру
        number = str + 9 + differenceNumber;
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(number);
        fileOut.close();
    }
}
