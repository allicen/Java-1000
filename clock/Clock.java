package clock;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Clock {

    // Результирующий Map
    private static Map<Character, Integer> result = new TreeMap<>();

    /**
     * Подсчет количества цифр
     * @param number число, в котором считаем цифры
     * */
    private static void countNumbers(String number) {
        if (number.length() < 2) {
            addChar('0');
        }

        char[] chars = number.toCharArray();
        for (char symbol : chars) {
            addChar(symbol);
        }
    }

    /**
     * Посчитать символ
     * @param number символ, который надо учесть
     * */
    private static void addChar(char number) {
        int count = 1;
        if (result.containsKey(number)) {
            count = result.get(number) + count;
        }
        result.put(number, count);
    }


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));

        int[] start = new int[3];
        int[] finish = new int[3];

        int line = 0;
        while (sc.hasNextLine()) {
            String[] parts = sc.nextLine().split(":");
            for (int i = 0; i < parts.length; i++) {
                if (line == 0) {
                    start[i] = Integer.parseInt(parts[i]);
                } else {
                    finish[i] = Integer.parseInt(parts[i]);
                }
            }
            line++;
        }

        // Расчет разницы во времени
        int hours = start[0];
        int minutes = start[1];
        int seconds = start[2];

        while ((hours < finish[0]) || (hours <= finish[0]) && minutes < finish[1] || (hours <= finish[0] && minutes <= finish[1] && seconds < finish[2])) {
            countNumbers(String.valueOf(hours));
            countNumbers(String.valueOf(minutes));
            countNumbers(String.valueOf(seconds));

            seconds++;
            if (seconds >= 60) {
                seconds = 0;
                minutes++;
            }
            if (minutes >= 60) {
                minutes = 0;
                hours++;
            }
        }

        countNumbers(String.valueOf(hours));
        countNumbers(String.valueOf(minutes));
        countNumbers(String.valueOf(seconds));


        PrintWriter out = new PrintWriter(System.out);

        for (char i = '0'; i <= '9'; i++) {
            if (result.containsKey(i)) {
                out.println(result.get(i));
            } else {
                out.println('0');
            }
        }
        out.flush();
    }
}
