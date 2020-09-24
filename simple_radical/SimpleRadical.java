package simple_radical;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class SimpleRadical {

    /**
     * Проверка числа на простоту
     * */
    private static boolean simple(BigInteger number) {

        if (number.equals(BigInteger.ONE)) { // по условию
            return false;
        }

        if (number.equals(BigInteger.TWO)) {
            return true;
        }
        if (number.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
            return false;
        }

        for (BigInteger a = new BigInteger("3"); ; a = a.add(BigInteger.ONE)) {
            if (a.compareTo(number.sqrt()) > 0) {
                break;
            }
            if (number.mod(a).equals(BigInteger.ZERO)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Проверка суммы цифр числа на простоту
     * Сложение до тнех пор, пока не получится простое число или непростое не более 10
     * */
    private static BigInteger sumCharacterSimple(BigInteger number) {
        BigInteger sumCharacter = sumCharacter(number);
        while (!simple(sumCharacter) && sumCharacter.compareTo(new BigInteger("10")) > 0) {
            sumCharacter = sumCharacter(sumCharacter);
        }

        if (sumCharacter.compareTo(new BigInteger("10")) < 0 && !(simple(sumCharacter))) {
            return BigInteger.ZERO;
        } else {
            return sumCharacter;
        }
    }

    /**
     * Сумма цифр числа
     * */
    private static BigInteger sumCharacter(BigInteger number) {
        BigInteger sum = BigInteger.ZERO;
        while (!number.equals(BigInteger.ZERO)) {
            sum = sum.add(number.mod(new BigInteger("10")));
            number = number.divide(new BigInteger("10"));
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);

        String number = new Scanner(new FileReader("input.txt")).nextLine();
        BigInteger numberInt = new BigInteger(number);

        if (simple(numberInt)) {
            out.println(number);
        } else if (!simple(numberInt) && number.length() == 1) {
            out.println(0);
        } else {
            out.println(sumCharacterSimple(numberInt));
        }

        out.flush();
    }
}
