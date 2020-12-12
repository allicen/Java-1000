package _other_tasks_.f_positive_divisors;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PositiveDivisors {
    private static int dev(int num) {
        int count = 0;

        for (int i = 2; i < Math.sqrt(num); i += 1) {
            if (num%i == 0){
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        String[] line = sc.nextLine().split(" ");
        int l = Integer.parseInt(line[0]);
        int r = Integer.parseInt(line[1]);

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = l; i <= r; i++) {
            map.put(i, dev(i));
        }

        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue()).forEach(i -> System.out.print (i.getKey() + " "));
    }
}
