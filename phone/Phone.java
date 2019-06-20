package phone;

import java.io.*;
import java.util.*;

public class Phone {
    private static long result;
    private static ArrayList<Long> data = new ArrayList<>();
    private static void in(){ // обработка входных данных
        String str;
        FileReader file = null;
        try {
            file = new FileReader("input.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner sc = new Scanner(Objects.requireNonNull(file)); // Если есть файл
        str = sc.nextLine();
        StringTokenizer st = new StringTokenizer(str, " ");
         while (st.hasMoreTokens()){
             data.add(Long.valueOf(st.nextToken()));
         }
    }

    private static void out() throws IOException { // Выходные данные
        FileWriter fileOut = null;
        try {
            fileOut = new FileWriter("output.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Objects.requireNonNull(fileOut).write(String.valueOf(result));
        fileOut.close();
    }

    public static void main(String[] args) throws IOException {
        in();
        result = (data.get(3) >= data.get(0)) ? data.get(0) * data.get(1) + (data.get(3) - data.get(0)) * data.get(2) : data.get(3) * data.get(1);
        System.out.println(result);
        out();
    }
}
