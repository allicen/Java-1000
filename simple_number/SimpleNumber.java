package simple_number;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class SimpleNumber {
    private static StringBuilder sieve(int m, int n){ //Решето Эратосфена
        StringBuilder result = new StringBuilder();
        int[] numbers = new int[n+1];
        for(int k = 2; k <= n; k++){
            numbers[k] = k;
        }
        for (int k = 2; k*k <= n; k++){
            if(numbers[k] == k){
                for(int j = k * k ; j <= n; j += k){
                    numbers[j] = 0;
                }
            }
        }
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] >= m){
                result.append(i).append("\n");
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        String[] line = sc.nextLine().split(" ");
        int m = Integer.valueOf(line[0]);
        int n = Integer.valueOf(line[1]);

        StringBuilder result = sieve(m, n);

        if(result.length() == 0) {
            result.append("Absent");
        }

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(result).trim());
        out.close();
    }
}
