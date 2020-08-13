package number_palindrome;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class NumberPalindrome {

    /**
     * @param numberInput Число
     * @param numberSystem Система счисления
     * @return Число в заданной системе счисления
     * */
    private static String translateNumeralSystems(long numberInput, int numberSystem) {
        return Long.toString(numberInput, numberSystem);
    }

    /**
     * @param numberInput Число
     * @param numberSystem Система счисления
     * @return true - Число является палиндромом, false - Число не палиндром
     * */
    private static boolean isPalindrome(long numberInput, int numberSystem) {
        char[] numberArray = translateNumeralSystems(numberInput, numberSystem).toCharArray();
        int finish = numberArray.length - 1;
        for (int start = 0; start <= numberArray.length / 2; start++) {
            if (numberArray[start] != numberArray[finish]) {
                return false;
            }
            finish--;
        }
        return true;
    }

    /**
     * Печать результатов
     * @param numberSystems Коллекция с системами счисления
     * */
    private static void printResult(ArrayList<Integer> numberSystems) {
        PrintWriter out = new PrintWriter(System.out);
        if (numberSystems.size() == 1) {
            out.println("unique");
            out.println(numberSystems.get(0));
        } else if (numberSystems.size() > 1) {
            out.println("multiple");
            for (int number: numberSystems) {
                out.print(number + " ");
            }
        } else {
            out.println("none");
        }
        out.flush();
    }


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        long numberInput = sc.nextLong();
        ArrayList<Integer> numberSystems = new ArrayList<>();

        for (int numberSystem = 2; numberSystem <= 36; numberSystem++) {
            if (isPalindrome(numberInput, numberSystem)) {
                numberSystems.add(numberSystem);
            }
        }
        printResult(numberSystems);
    }
}
