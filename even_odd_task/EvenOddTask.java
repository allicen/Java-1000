package even_odd_task;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class EvenOddTask {
    public static void main(String[] args) throws IOException {
        ArrayList<Long> data = new ArrayList<>();
        Scanner sc = new Scanner(new FileReader("input.txt"));
        int index = 0;
        int system = 8;
        while (sc.hasNextLine()){
            StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
            if(index > 0){
                while (st.hasMoreTokens()){
                    String numberStr = st.nextToken();
                    if(Long.valueOf(numberStr) % 2 == 0){
                        String number = String.valueOf(Long.toString(Long.parseLong(numberStr), system));
                        int symbol = Integer.valueOf(number.substring(number.length()-3, number.length()-2));
                        if(symbol % 2 == 1){
                            data.add(Long.valueOf(numberStr));
                        }
                    }
                }
            }
            index++;
        }

        Collections.sort(data);

        StringBuilder result = new StringBuilder();
        result.append(data.size()).append("\n");
        for(long number : data){
            result.append(number).append(" ");
        }

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(result).trim());
        out.close();
    }
}

