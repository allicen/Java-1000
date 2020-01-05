package different_numbers;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class DifferentNumbers {
    public static void main(String[] args) throws IOException {

        Map<Long, Character> numberSystem = new HashMap<>();
        long start = 10;
        for(char i = 'A'; i <= 'Z'; i++){
            numberSystem.put(start++, i);
        }

        Scanner sc = new Scanner(new FileReader("input.txt"));
        long numberIn = sc.nextLong();
        int maxSystem = 36;
        int minSystem = 2;

        StringBuilder result = new StringBuilder();

        for(int i = minSystem; i <= maxSystem; i++){
            long numberInCopy = numberIn;
            Set<String> symbols = new HashSet<>();

            int index = 0;
            while (numberInCopy > 0){
                long part = numberInCopy % i;
                if(part < 10){
                    symbols.add(String.valueOf(part));
                }else {
                    symbols.add(String.valueOf(numberSystem.get(part)));
                }
                numberInCopy /= i;
                index++;
            }

            if(index == symbols.size()){
                result.append(i).append(" ");
            }
        }

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(result).trim());
        out.close();
    }
}
