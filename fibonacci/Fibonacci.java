package fibonacci;

import java.io.*;
import java.util.*;


public class Fibonacci {
    private static int result;
    private static void run(int number){ // Расчет числа Фибоначчи
        int a = 0, b = 1;
        while (number > 1){
            b = a + b;
            a = b - a;
            number--;
        }
        result = (number == 0) ? 0 : b;
    }
    public static void main(String[] args) throws IOException {
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        int number = sc.nextInt();
        run(number);
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(String.valueOf(result));
        fileOut.close();
    }
}
