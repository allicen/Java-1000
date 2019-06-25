package heron;

import java.io.*;
import java.util.*;

public class Heron {
    private static ArrayList<Integer> data = new ArrayList<>();
    private static int min = 0;
    private static int max = 0;

    private static void minMax(){ // Определение минимального и максимального количества цапель
        if(data.get(0) == data.get(1) * 2){
            min = data.get(0);
            max = data.get(0);
        }else if(data.get(0).equals(data.get(1))){
            min = (data.get(0) % 2 == 0) ? data.get(0) / 2 : data.get(0) / 2 + 1;
            max = data.get(0);
        }else{
            min = (data.get(1) % 2 == 0) ? data.get(1) / 2 : data.get(1) / 2 + 1;
            max = data.get(0);
        }
    }

    public static void main(String[] args) throws IOException {
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        String str = sc.nextLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        while (st.hasMoreTokens()){
            data.add(Integer.valueOf(st.nextToken()));
        }
        Collections.sort(data);

        minMax();

        String result = min + " " + max;
        System.out.println(result);
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(result);
        fileOut.close();
    }
}
