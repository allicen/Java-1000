package homework;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Homework {
    private static long multi(ArrayList<Integer> data, long min, long max, int minIndex, int maxIndex){
        long multi = 1;
        boolean start = false;

        for(int number : data){
            if(minIndex < maxIndex){
                if(number == max){
                    start = false;
                    break;
                }
                if(start){
                    multi *= number;
                }
                if(number == min){
                    start = true;
                }
            }else {
                if(number == min){
                    start = false;
                    break;
                }
                if(start){
                    multi *= number;
                }
                if(number == max){
                    start = true;
                }
            }
        }
        return multi;
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Integer> data = new ArrayList<>();
        Scanner sc = new Scanner(new FileReader("input.txt"));
        while (sc.hasNextLine()){
            StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
            while (st.hasMoreTokens()){
                data.add(Integer.valueOf(st.nextToken()));
            }
        }
        data.remove(0);

        long sum = 0, min = data.get(0), max = data.get(0);
        int minIndex = 0, maxIndex = 0;
        for(int i = 0; i < data.size(); i++){
            if(data.get(i) > 0){
                sum += data.get(i);
            }
            if(data.get(i) < min){
                min = data.get(i);
                minIndex = i;
            }
            if(data.get(i) > max){
                max = data.get(i);
                maxIndex = i;
            }
        }

        long multi = multi(data, min, max, minIndex, maxIndex);

        String result = sum + " " + multi;

        FileWriter out = new FileWriter("output.txt");
        out.write(result);
        out.close();
    }
}
