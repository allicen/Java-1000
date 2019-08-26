package constant_kaprekar;

import java.util.*;
import java.io.*;

public class ConstantKaprekar {
    private static int data;

    private static void getData() throws IOException{ // Получение данных
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        data = sc.nextInt();
    }

    private static int[] numberChange(int data){ // Вычисление максималного и минимального числа
        int max, min;
        ArrayList<Integer> number = new ArrayList<>();
        char[] ch = String.valueOf(data).toCharArray();
        for (char aCh : ch) {
            number.add(aCh - '0');
        }

        Collections.sort(number); // Минимальное число
        StringBuilder strMin = new StringBuilder();
        for(int i = 0; i < 4; i++){
            if(i < number.size()){
                strMin.append(number.get(i));
            }
        }
        min = Integer.valueOf(String.valueOf(strMin));

        number.sort(Collections.reverseOrder()); // Максимальное число
        StringBuilder strMax = new StringBuilder();
        for(int i = 0; i < 4; i++){
            if(i < number.size()){
                strMax.append(number.get(i));
            }else {
                strMax.append("0");
            }
        }
        max = Integer.valueOf(String.valueOf(strMax));
        return new int[]{max, min};
    }

    public static void main(String[] argv) throws IOException{
        getData();

        int[] numberMaxMin = numberChange(data);
        int max = numberMaxMin[0];
        int min = numberMaxMin [1];

        int index = 0; // Кол-во итераций

        while (max - min != data) { // Пока не найдем нужное число
            data = max - min;
            numberMaxMin = numberChange(data);
            max = numberMaxMin[0];
            min = numberMaxMin[1];
            index++;
        }

        int Kaprekar = max - min;
        String result = Kaprekar + "\n" + index;

        System.out.println(result);

        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(result);
        pw.close();
    }
}
