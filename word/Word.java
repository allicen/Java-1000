package word;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Word {
    private static int next(int a, int b){
        return a + b;
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Integer> fib = new ArrayList<>(Arrays.asList(1, 2));
        StringBuilder result = new StringBuilder();

        Scanner sc = new Scanner(new FileReader("input.txt"));
        String symbols = sc.nextLine();
        char[] symbolsArr = symbols.toCharArray();

        int index = 1;
        int next = next(fib.get(fib.size() - 1), fib.get(fib.size() - 2));

        for (char symbol : symbolsArr){
            String str = String.valueOf(symbol);
            if(index == 1 || index == 2){
                result.append(str);
            }else {
                if(index == next){
                    result.append(str);
                    fib.add(index);
                    next = next(fib.get(fib.size() - 1), fib.get(fib.size() - 2));

                }
            }
            index++;
        }

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(result));
        out.close();
    }
}
