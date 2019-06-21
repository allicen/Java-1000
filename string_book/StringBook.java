package string_book;

import java.io.*;
import java.util.*;

public class StringBook {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> numberIn = new ArrayList<>();
        ArrayList<Integer> numberOut = new ArrayList<>();
        StringBuilder result = null;
        String str;
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        str = sc.nextLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        while (st.hasMoreTokens()){
            numberIn.add(Integer.valueOf(st.nextToken()));
        }
        if(numberIn.get(1) % numberIn.get(0) != 0){ // Если это не последняя строка на странице
            numberOut.add(numberIn.get(1) / numberIn.get(0) + 1); // Расчет страницы
            numberOut.add(numberIn.get(1) % numberIn.get(0)); // Расчет строки
        }else{ // Если последняя
            numberOut.add(numberIn.get(1) / numberIn.get(0)); // Расчет страницы
            numberOut.add(numberIn.get(1) / numberOut.get(0)); // Расчет строки
        }

        for (Integer aNumberOut : numberOut) {
            if (result != null) {
                result.append(String.valueOf(aNumberOut)); // Вторая цифра
            } else {
                result = new StringBuilder(String.valueOf(aNumberOut) + " "); // Пробел после 1 цифры
            }
        }
        System.out.println(result);
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(String.valueOf(result));
        fileOut.close();
    }
}
