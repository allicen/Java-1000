package sequence_conversion_two;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SequenceConversionTwo {
    private static int listContainsNumberCount (ArrayList<Integer> list, int number) {
        int count = 0;
        for (int item: list) {
            if (item == number) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Integer> inputNumbers = new ArrayList<>();

        Scanner sc = new Scanner(new FileReader("input.txt"));
        while (sc.hasNextLine()) {
            String[] numbers = sc.nextLine().split(" ");
            for (String number: numbers) {
                inputNumbers.add(Integer.parseInt(number));
            }
        }
        inputNumbers.remove(0);

        ArrayList<Integer> maxCountNumbers = new ArrayList<>(); // числа с максимальным повторением
        int maxCount = 0; // количество повторений числа

        for (int number: inputNumbers) {
            if (maxCountNumbers.size() == 0) {
                maxCountNumbers.add(number);
                maxCount++;
            } else {
                int countInputNumbers = listContainsNumberCount(inputNumbers, number); // кол-во в исходном массиве
                if (maxCount < countInputNumbers) {
                    maxCountNumbers.clear();
                    maxCountNumbers.add(number);
                    maxCount = countInputNumbers;
                } else if (maxCount == countInputNumbers && !maxCountNumbers.contains(number)) {
                    maxCountNumbers.add(number);
                }
            }
        }

        int minNumber = Collections.min(maxCountNumbers);

        PrintWriter out = new PrintWriter(System.out);
        for (int number: inputNumbers) {
            if (number != minNumber) {
                out.print(number + " ");
            }
        }
        for (int index = 0; index < maxCount; index++) {
            out.print(minNumber + " ");
        }

        out.flush();
    }
}
