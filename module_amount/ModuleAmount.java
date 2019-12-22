package module_amount;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ModuleAmount {
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

        StringBuilder plus = new StringBuilder();
        StringBuilder minus = new StringBuilder();

        int sumPlus = 0;
        int sumMinus = 0;

        int countPlus = 0;
        int countMinus = 0;

        int index = 1;
        for(int number : data){
            if(number >= 0){
                sumPlus += number;
                countPlus++;
                plus.append(index).append(" ");
            }else {
                sumMinus += Math.abs(number);
                countMinus++;
                minus.append(index).append(" ");
            }
            index++;
        }

        String result = sumPlus >= sumMinus ? String.valueOf(countPlus) + "\n" + plus :
                String.valueOf(countMinus) + "\n" + minus;

        FileWriter out = new FileWriter("output.txt");
        out.write(result);
        out.close();
    }
}
