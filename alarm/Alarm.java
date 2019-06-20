package alarm;

import java.io.*;
import java.util.*;

public class Alarm {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> time = new ArrayList<>();
        int result;
        String str;
        FileReader file = new FileReader("input.txt"); // Считывание данных из файла
        Scanner sc = new Scanner(file);
        str = sc.nextLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        while (st.hasMoreTokens()){
            time.add(Integer.valueOf(st.nextToken())); // Записать все элементы в коллекцию
        }
        result = (time.get(1) > time.get(0)) ? time.get(1) - time.get(0) : 12 + time.get(1) - time.get(0);
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(String.valueOf(result));
        fileOut.close();
    }
}
