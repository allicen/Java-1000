package multi_digits;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class MultiDigits {

    /**
     * @param number Произвольное число
     * @return true, если число делится на произведение цифр, false в противном случае
     * */

    private static boolean check(long number){
        long numberCopy = number;
        long multi = 1;
        while (number > 0){
            long digit = number % 10;
            if(digit == 0){
                return false;
            }
            multi *= digit;
            number /= 10;
        }
        return numberCopy % multi == 0;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        String[] lineArr = sc.nextLine().split(" ");

        long l = Long.valueOf(lineArr[0]);
        long r = Long.valueOf(lineArr[1]);

        int count = 0;
        for (long i = l; i <= r; i++){
            if(check(i)) count++;
        }

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(count));
        out.close();
    }
}
