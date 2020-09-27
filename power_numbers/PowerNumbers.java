package power_numbers;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PowerNumbers {

    /**
     * @param number Проверяемое число
     * @return true - если число степенное, false - иначе
     * */
    private static boolean powerNumbers(long number) {
        long numberTemp = number;
        for (int divider = 2; divider <= Math.sqrt(numberTemp); divider++) {
            while (numberTemp > 1) {
                if (numberTemp % divider == 0) {
                    numberTemp /= divider;
                } else {
                    numberTemp = number;
                    break;
                }
            }
            if (numberTemp == 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner(new FileReader("input.txt"));

        sc.nextLine(); // считываем количество чисел
        String[] numbers = sc.nextLine().split(" ");

        for (String number : numbers) {
            if (powerNumbers(Long.parseLong(number))) {
                out.println("YES");
            } else {
                out.println("NO");
            }
        }
        out.flush();
    }
}
