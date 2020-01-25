package digits;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Digits {
    private static int sum(ArrayList<Integer> copy){
        int sum = 0;
        boolean plus = true;
        for(int i : copy){
            if(plus){
                sum += i;
                plus = false;
            }else {
                sum -= i;
                plus = true;
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Integer> numbers = new ArrayList<>();
        int sum = 0;

        Scanner sc = new Scanner(new FileReader("input.txt"));
        char[] ch = sc.nextLine().toCharArray();
        for(char aCh : ch){
            numbers.add(aCh - '0');
        }

        for(int i = 0; i < numbers.size(); i++){
            ArrayList<Integer> copy = new ArrayList<>(numbers);
            copy.remove(i);
            int subtotal = sum(copy);
            if(i == 0){
                sum = subtotal;
            }else {
                sum = sum < subtotal ? subtotal : sum;
            }
        }

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(sum));
        out.close();
    }
}

