package sum_max_min;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SumMaxMin {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> allNumeric = new ArrayList<>();

        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        while (st.hasMoreTokens()){
            allNumeric.add(Integer.valueOf(st.nextToken()));
        }

        int min = 0;
        int max = 0;

        for(int i = 0; i < allNumeric.size(); i++){
            if(i == 0){
                min = allNumeric.get(i);
            }else if(i == 1){
                max = allNumeric.get(i);
            }else {
                if(i % 2 == 0){
                    min = (allNumeric.get(i) < min) ? allNumeric.get(i) : min ;
                }else {
                    max = (allNumeric.get(i) > max) ? allNumeric.get(i) : max;
                }
            }
        }
        int sum = min + max;

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(sum));
        out.close();
    }
}
