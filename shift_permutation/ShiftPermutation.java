package shift_permutation;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ShiftPermutation {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> list = new ArrayList<>();
        int min = 0;
        Scanner sc = new Scanner(new FileReader("input.txt"));
        int index = 0;
        while (sc.hasNextLine()){
            StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
            while (st.hasMoreTokens()){
                int number = Integer.valueOf(st.nextToken());
                if(index == 0){
                    min = number;
                }else {
                    if(min > number){
                        min = number;
                    }
                    list.add(number);
                }
            }
            index++;
        }

        StringBuilder result = new StringBuilder();
        boolean start = false;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) == min){
                start = true;
            }
            if(start){
                result.append(list.get(i)).append(" ");
                list.remove(i);
                i--;
            }
        }

        if(list.size() != 0){
            for(int i : list){
                result.append(i).append(" ");
            }
        }

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(result).trim());
        out.close();
    }
}
