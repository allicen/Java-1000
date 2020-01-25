package deletion;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Deletion {
    public static void main(String[] args) throws IOException {
        Set<Integer> allNumbers = new HashSet<>();
        Scanner sc = new Scanner(new FileReader("input.txt"));
        char[] symbols = sc.nextLine().toCharArray();
        for (int i = 0; i < symbols.length; i++){
            for(int j = i + 1; j < symbols.length; j++){
                for (int k = j + 1; k < symbols.length; k++){
                    String one = String.valueOf(symbols[i] - '0');
                    String two = String.valueOf(symbols[j] - '0');
                    String three = String.valueOf(symbols[k] - '0');
                    int number = Integer.valueOf(one + two + three);
                    if(number >= 100){
                        allNumbers.add(number);
                    }
                }
            }
        }

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(allNumbers.size()));
        out.close();
    }
}
