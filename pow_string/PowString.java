package pow_string;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PowString {

    /**
     * @param out Стандартный вывод
     * @param pow Степень
     * @param stringChar Символы строки
     * @param resultMaxLength Максимальная длина строки
     * */
    private static void plusPow(PrintWriter out, int pow, char[] stringChar, int resultMaxLength) {
        int charCount = 0;
        boolean finish = false;
        for (int i = 0; i < pow; i++) {
            for (char c : stringChar) {
                if (charCount < resultMaxLength) {
                    out.print(c);
                } else {
                    finish = true;
                    break;
                }
                charCount++;
            }

            if (finish) {
                break;
            }
        }
    }


    /**
     * @param out Стандартный вывод
     * @param stringChar Строка посимвольно
     * @param stringInput Исходная строка
     * @param  pow Степень
     * */
    private static void minusPow(PrintWriter out, char[] stringChar, String stringInput, int pow) {
        StringBuilder section = new StringBuilder();

        for (char c : stringChar) {
            if (section.length() == 0 || c != section.charAt(0)) {
                section.append(c);
            } else {
                if (stringInput.replaceAll(String.valueOf(section), "").length() == 0) {
                    break;
                } else {
                    section.append(c);
                }
            }
        }

        int sectionCount = (stringInput.length() - stringInput.replace(section, "").length()) / section.length();
        if (stringInput.length() % pow == 0 && sectionCount >= Math.abs(pow) && sectionCount % Math.abs(pow) == 0) {
            for (int i = 0; i < stringChar.length/Math.abs(pow); i++) {
                out.print(stringChar[i]);
            }
        } else {
            out.print("NO SOLUTION");
        }
    }


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        String stringInput = sc.nextLine();
        char[] stringChar = stringInput.toCharArray();

        int pow = sc.nextInt();
        int resultMaxLength = 1023;

        PrintWriter out = new PrintWriter(System.out);
        if (pow > 0) {
            plusPow(out, pow, stringChar, resultMaxLength);
        } else {
            minusPow(out, stringChar, stringInput, pow);
        }
        out.flush();
    }
}
