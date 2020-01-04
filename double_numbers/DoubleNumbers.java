package double_numbers;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DoubleNumbers {
    private static boolean check(int number){
        Set<Integer> set = new HashSet<>();

        while (number > 0){
            int symbol = number % 10;
            set.add(symbol);
            number /= 10;
        }
        return set.size() < 3;
    }


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        int number = sc.nextInt();

        int result;
        if(check(number)){
            result = number;
        }else {
            int prev = 0, next = 0, prevStep = 0, nextStep = 0;
            for(int i = number; i > 0; i--){
                if(check(i)){
                    prev = i;
                    break;
                }
                prevStep++;
            }
            for(int i = number; i <= 30000; i++){
                if(check(i)){
                    next = i;
                    break;
                }
                nextStep++;
            }

            result = (nextStep < prevStep) ? next : prev;

        }

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(result));
        out.close();
    }
}
