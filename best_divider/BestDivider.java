package best_divider;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class BestDivider {
    private static int sum(int number){
        int sum = 0;
        while (number != 0){
            sum += (number % 10);
            number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        FileReader file = new FileReader("input.txt");
        Scanner scan = new Scanner(file);
        int number = scan.nextInt();

        Map<Integer, Integer> dividers = new TreeMap<>(Collections.reverseOrder());

        for(int i = 1; i <= number; i++){
            if(number % i == 0){
                dividers.put(i, sum(i));
            }
        }


        List<Map.Entry<Integer, Integer>> dividerSortValue = dividers.entrySet().stream()
                .sorted((v1, v2) -> v1.getValue().compareTo(v2.getValue()))
                .collect(Collectors.toList());

        String result = String.valueOf(dividerSortValue.get(dividerSortValue.size()-1).getKey());

        FileWriter out = new FileWriter("output.txt");
        out.write(result);
        out.close();
    }
}
