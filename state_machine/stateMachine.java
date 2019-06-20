package state_machine;

import java.io.*;
import java.text.MessageFormat;
import java.util.*;

public class stateMachine {
    private static String resultOut;
    public static void main(String[] args) throws IOException {
        ArrayList<String> number = new ArrayList<>(); // Для данных из файла
        ArrayList<String> result = new ArrayList<>(); // Для данных, полученных в результате вычислений
        int resultInt;
        String str;
        FileReader file = new FileReader("input.txt"); // Считывание данных из файла
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            str = sc.nextLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            while (st.hasMoreTokens()){
                number.add(st.nextToken()); // Записать все элементы в коллекцию
            }
        }
        int j = 1;
        for(int i = 0; i < number.size(); i++){
            if(i != 0 && j < number.size()){
                int n = Integer.valueOf(number.get(j));
                int m = Integer.valueOf(number.get(j + 1));
                j = j + 2;
                resultInt = 19* m + (n + 239)*(n + 366) / 2; // Формула из задачи
                result.add(String.valueOf(resultInt));
            }
        }
        for(String line : result)
            if (resultOut != null) {
                resultOut = String.format("%s%s", resultOut, MessageFormat.format("{0}\n", line)); // Записываем результат со второй строки
            } else {
                resultOut = line + "\n"; // Записываем результат в 1 строку
            }
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(resultOut);
        fileOut.close();
    }
}
