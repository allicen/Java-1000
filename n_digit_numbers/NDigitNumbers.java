package n_digit_numbers;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class NDigitNumbers {

    /**
     * @param number Число
     * @return Сумма цифр числа, произведение
     * */
    private static boolean digitSumMulti(long number) {
        int sum = 0;
        int multi = 1;
        while (number != 0) {
            long digit = number % 10;
            if (digit == 0) {
                return false;
            }

            sum += digit;
            if (digit != 1) {
                multi *= digit;
            }

            if (multi > 90 || multi/2 > sum) {
                return false;
            }

            number /= 10;
        }

        return sum == multi;
    }


    /**
     * @param number Число
     * @return Количество перестановок
     * */
    private static int swapCount(long number) {
        Map<Integer, Integer> digitCount = new HashMap<>();

        long numberTmp = number;
        while (numberTmp != 0) {
            int digit = (int) (numberTmp % 10);
            if (digitCount.containsKey(digit)) {
                digitCount.put(digit, digitCount.get(digit)+1);
            } else {
                digitCount.put(digit, 1);
            }

            numberTmp /= 10;
        }

        int multi = 1;
        for (int digit : digitCount.values()) {
            if (digit != 0) {
                multi *= fact(digit);
            }
        }
        return (fact(String.valueOf(number).length()))/(multi);
    }


    /**
     * @param number Число
     * @return Факториал числа
     * */
    private static int fact(int number) {
        int count = 1;
        for (int i = number; i > 1; i--) {
            count *= i;
        }
        return count;
    }


    public static void main(String[] args) throws IOException {
        int digit = new Scanner(new FileReader("input.txt")).nextInt();
        long min = 0;
        long countFound = 0, minFound = -1;

        if (digit > 1) {
            min = Long.parseLong("1" + "1".repeat(digit - 1));
        }

        if (digit > 1) {
            int aCount = digit == 10 ? 9 : 0;
            int bCount = digit >= 9 ? 9 : 0;
            int cCount = digit >= 8 ? 9 : 0;
            int dCount = digit >= 7 ? 9 : 0;
            int eCount = digit >= 6 ? 9 : 0;
            int fCount = digit >= 5 ? 9 : 0;
            int gCount = digit >= 4 ? 9 : 0;
            int hCount = digit >= 3 ? 9 : 0;

            for (int a = 0; a <= aCount; a++) {
                for (int b = a; b <= bCount; b++) {
                    for (int c = b; c <= cCount; c++) {
                        for (int d = c; d <= dCount; d++) {
                            for (int e = d; e <= eCount; e++) {
                                for (int f = e; f <= fCount; f++) {
                                    for (int g = f; g <= gCount; g++) {
                                        for (int h = g; h <= hCount; h++) {
                                            for (int i = h; i <= 9; i++) {
                                                for (int j = i; j <= 9; j++) {
                                                    long number =
                                                            a*(long) Math.pow(10, 9) +
                                                            b*(long) Math.pow(10, 8) +
                                                            c*(long) Math.pow(10, 7) +
                                                            d*(long) Math.pow(10, 6) +
                                                            e*(long) Math.pow(10, 5) +
                                                            f*(long) Math.pow(10, 4) +
                                                            g*(long) Math.pow(10, 3) +
                                                            h*(long) Math.pow(10, 2) +
                                                            i*(long) Math.pow(10, 1) + j;

                                                    if (number >= min) {
                                                        if (digitSumMulti(number)) {
                                                            countFound += swapCount(number);
                                                            if (minFound == -1) {
                                                                minFound = number;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        if (digit == 1) {
            out.println(10 + " " + 0);
        } else {
            out.println(countFound + " " + minFound);
        }
        out.flush();
    }
}
