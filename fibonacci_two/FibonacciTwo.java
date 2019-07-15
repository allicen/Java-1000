package fibonacci_two;

import java.util.*;
import java.io.*;

public class FibonacciTwo {
    private static long number;
    private static void getData() throws IOException{ // Получение данных
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        number = sc.nextInt();
    }

    public static void main(String[] argv) throws IOException{
        getData();
        int a = 1, b = 1, k = 1;
        int isFibonacci = 0;
        while (number > a){
            k++;
            b = a + b;
            a = b - a;
            if(a == number){
                isFibonacci = 1;
            }
        }
        String result = (isFibonacci == 0) ? "0" : "1\n" + k;
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(result);
        pw.close();
    }
}
