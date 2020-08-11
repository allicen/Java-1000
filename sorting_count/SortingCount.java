package sorting_count;


import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class SortingCount {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> inputArray = new ArrayList<>();

        // Считываем данные в коллекцию
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("input.txt"));

        int i;
        int index = -1;
        StringBuilder numberString = new StringBuilder();

        while((i = bufferedInputStream.read())!= -1){
            if (i == 13 || i == 32) {
                if (numberString.length() > 0) {
                    int number = Integer.parseInt(numberString.toString());
                    if (index != -1) {
                        inputArray.add(number);
                    }
                    numberString = new StringBuilder();
                    index++;
                }

            }
            else if (i != 10) {
                numberString.append((char) i);
            }
        }

        // Записываем последнее число
        if (numberString.length() > 0) {
            int number = Integer.parseInt(numberString.toString());
            inputArray.add(number);
        }

        // Формирукем вспомогательный массив с кол-вом возможных значений
        int[] helpArray = new int[201];

        // Записываем данные на определенное место
        for (int value : inputArray) {
            helpArray[value + 100] = helpArray[value + 100] + 1;
        }

        // Считываем данные, вычисляем место в массиве
        PrintWriter out = new PrintWriter(System.out);
        int number = -100;
        for (int value : helpArray) {
            for (int k = 0; k < value; k++) {
                out.print(number + " ");
            }
            number++;
        }
        out.flush();
    }
}
