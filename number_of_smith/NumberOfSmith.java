package number_of_smith;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class NumberOfSmith {

    /**
     * @param numberData Число в формате строки
     * @return Число
     * */
    private static int getNumber(String numberData) {
        return Integer.parseInt(numberData);
    }


    /**
     * @param number Число
     * @return Сумма цифр числа
     * */
    private static int sumNumberSymbol(int number) {
        int sum = 0;
        while (number != 0) {
            sum += (number % 10);
            number /= 10;
        }

        return sum;
    }


    /**
     * @param number Число
     * @return true если число простое, false - иначе
     * */
    private static boolean isSimple(int number) {
        double sqrt = Math.sqrt(number);

        if(number == 1 || number == 2) return true;
        if(number % 2 == 0) return false;

        for(int i = 3; i <= sqrt; i += 2){
            if(number % i == 0) return false;
        }
        return true;
    }


    /**
     * @param number Число
     * @return Список простых множителей числа
     * */
    private static ArrayList<Integer> simpleMultipliers(int number) {
        ArrayList<Integer> multipliers = new ArrayList<>();
        for (int i = 2; i <= number;) {
            if (isSimple(i) && number % i == 0) {
                multipliers.add(i);
                number /= i;
            } else {
                i++;
            }
        }

        return multipliers;
    }


    /**
     * @param number Число
     * @return Сумма цифр простых множителей
     * */
    private static int sumSimpleMultipliers(int number) {
        int sum = 0;
        ArrayList<Integer> multipliers = simpleMultipliers(number);
        for (int multiplier : multipliers) {
            sum += sumNumberSymbol(multiplier);
        }
        return sum;
    }


    /**
     * @param numberData Число в формате строки
     * @return 1 если это число Смита, 0 - иначе
     * */
    private static int isNumberOfSmith (String numberData) {
        int number = getNumber(numberData);
        if (!isSimple(number) && sumNumberSymbol(number) == sumSimpleMultipliers(number)) {
            return 1;
        }
        return 0;
    }


    public static void main(String[] args) throws IOException {

        String[] numbersInput = new Scanner(new FileReader("input.txt")).nextLine().split(" ");

        PrintWriter out = new PrintWriter(System.out);
        for (String number : numbersInput) {
            out.print(isNumberOfSmith (number));
        }

        out.flush();
    }
}
