package wagons;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Wagons {
    public static void main(String[] args) throws IOException {
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        int arrSize = Integer.valueOf(sc.nextLine());

        int[] wagonsNumbers = new int[arrSize];
        String str = sc.nextLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        int count = 0;
        while (st.hasMoreTokens()){
            wagonsNumbers[count] = Integer.valueOf(st.nextToken());
            count++;
        }

        int countCombination = 0;
        int prev = 0;
        for (int wagonsNumber : wagonsNumbers) {
            if(prev != 0){
                if (prev + 1 != wagonsNumber) {
                    countCombination++;
                }
            }
            prev = wagonsNumber;
        }

        System.out.println(countCombination);
        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(countCombination));
        out.close();
    }
}
