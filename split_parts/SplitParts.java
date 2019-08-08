package split_parts;

import java.util.*;
import java.io.*;

public class SplitParts {
    private static ArrayList<Integer> data = new ArrayList<>();
    private static void getData() throws IOException{ // Получение данных
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        while (st.hasMoreTokens()){
            data.add(Integer.valueOf(st.nextToken()));
        }
    }

    public static void main(String[] argv) throws IOException{
        getData();

        int number = data.get(0);
        int numbersSumm = data.get(1);
        int part = number/numbersSumm;

        StringBuilder result = new StringBuilder();

        if(number % numbersSumm == 0){
            while (numbersSumm > 0){
                result.append(part).append(" ");
                numbersSumm--;
            }
        }else{
            int remainder = number % numbersSumm;
            ArrayList<Integer> numbers = new ArrayList<>();
            while (numbersSumm > 0){
                if(remainder > 0){
                    numbers.add(part+1);
                    remainder--;
                }else{
                    numbers.add(part);
                }
                numbersSumm--;
            }
            Collections.sort(numbers);
            for(Integer line : numbers){
                result.append(line).append(" ");
            }
        }

        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(result);
        pw.close();
    }
}
