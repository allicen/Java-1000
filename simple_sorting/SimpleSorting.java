package simple_sorting;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SimpleSorting {
    private static long sum(long number, long system){
        int sum = 0;
        while (number > 0){
            sum += number % system;
            number /= system;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        long n = 0, k = 0, m = 0;
        ArrayList<Long> data = new ArrayList<>();

        Scanner scan = new Scanner(new FileReader("input.txt"));
        int index = 0;
        while (scan.hasNextLine()){
            StringTokenizer token = new StringTokenizer(scan.nextLine(), " ");
            if(index == 0){
                k = Integer.valueOf(token.nextToken());
                m = Integer.valueOf(token.nextToken());
            }else {
                while (token.hasMoreTokens()){
                    data.add(Long.valueOf(token.nextToken()));
                }
            }
            index++;
        }

        for(int i = 0; i < data.size(); i++){
            long newNumber = sum(data.get(i), k) * sum(data.get(i), m);
            data.set(i, newNumber);
        }

        Collections.sort(data);
        StringBuilder result = new StringBuilder();
        for(long number : data){
            result.append(String.valueOf(number)).append(" ");
        }

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(result).trim());
        out.close();
    }
}
