package hairy_business;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class HairyBusiness {

    /**
     * Получить данные по ценам
     * @return Массив с ценами
     * */
    private static ArrayList<Integer> _getData() throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        ArrayList<Integer> data = new ArrayList<>();

        boolean isFirstLine = true;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (!isFirstLine) {
                String[] numbers = line.split(" ");
                for (String number: numbers) {
                    data.add(Integer.parseInt(number));
                }
            }
            isFirstLine = false;
        }
       return data;
    }


    /**
     * Получить индекс максимального элемента массива
     * @param data Массив с данными
     * @return Индекс максимиума
     * */
    private static int _getMaxElementIndex(ArrayList<Integer> data) {
        int max = 0;
        int maxIndex = 0;

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) > max) {
                max = data.get(i);
                maxIndex = i;
            }
        }

        return maxIndex;
    }


    public static void main(String[] args) throws IOException {
        ArrayList<Integer> data = _getData();
        int maxIndex = _getMaxElementIndex(data);

        int sum = 0;
        int tmpCount = 1; // Количество дней, за которое нужно суммировать цену

        for (int i = 0; i < data.size(); i++) {
            if (i < maxIndex) {
                tmpCount++;
            } else if (i == maxIndex) {
                sum += tmpCount * data.get(maxIndex);

                // Занизить значения учтенных цен
                for (int j = 0; j <= maxIndex; j++) {
                    data.set(j, -1);
                }
                maxIndex = _getMaxElementIndex(data);
                tmpCount = 1;
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        out.println(sum);
        out.flush();
    }
}
