package eleven;

import java.util.*;
import java.io.*;

public class Eleven {
    private static String number;
    private static void getData() throws IOException{ // Получение данных
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        number = sc.nextLine();
    }

    public static void main(String[] argv) throws IOException{
        getData();

        long summEven = 0, summOdd = 0;
        char[] chNumber = number.toCharArray();

        for(int i = 0; i < chNumber.length; i++){
            if(i%2 == 0){
                summEven += chNumber[i] - '0';
            }else{
                summOdd += chNumber[i] - '0';
            }
        }

        String result = (summEven == summOdd || Math.abs(summEven - summOdd) % 11 == 0) ? "YES" : "NO";

        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(result);
        pw.close();
    }
}
