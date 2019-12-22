package numbers_without_same_digit;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NumbersWithoutSameDigit {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new FileReader("input.txt"));
        int numberIn = scan.nextInt();

        int index = 0;
        int numberOut = 0;
        while (index != numberIn){
            numberOut++;
            int numberOutCopy = numberOut;
            boolean isSet = true;
            Set<Integer> digit = new HashSet<>();
            while (numberOutCopy != 0){
                if(digit.contains(numberOutCopy % 10)){
                    isSet = false;
                }else {
                    digit.add(numberOutCopy % 10);
                }
                numberOutCopy /= 10;
            }
            index += isSet ? 1 : 0;
        }

        System.out.println(numberOut);

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(numberOut));
        out.close();
    }
}
