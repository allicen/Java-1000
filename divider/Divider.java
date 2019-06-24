package divider;

import java.io.*;
import java.util.*;

public class Divider {
    private static ArrayList<Long> data = new ArrayList<>(); // Исходные числа
    private static long dividerGeneral; // НОД

    private static void divider(){
        long a = data.get(0);
        long b = data.get(1);
        while (a != b){
            if(a > b){
                a = a - b;
            }else{
                b = b - a;
            }
        }
        dividerGeneral = a;
    }

    public static void main(String[] args) throws IOException {
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        String str = sc.nextLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        while (st.hasMoreTokens()){
            data.add(Long.valueOf(st.nextToken()));
        }

        divider();

        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(String.valueOf(dividerGeneral));
        fileOut.close();
    }
}
