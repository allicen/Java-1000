package traffic_lights;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class TrafficLights {
    public static void main(String[] args) throws IOException {
        Map<Integer, Integer> data = new TreeMap<>();
        Scanner sc = new Scanner(new FileReader("input.txt"));

        int index = 0;
        int step = 1;
        while (sc.hasNextLine()){
            StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
            while (st.hasMoreTokens()){
                int number = Integer.valueOf(st.nextToken());
                if(index > 1){
                    if(data.containsKey(number)){
                        int val = data.get(number) + step;
                        data.put(number, val);
                    }else {
                        data.put(number, step);
                    }
                }
                index++;
            }
        }

        StringBuilder result = new StringBuilder();
        if(data.size() == 0){
            result.append("0");
        }else {
            for(int number : data.keySet()){
                result.append(data.get(number)).append(" ");
            }
        }

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(result).trim());
        out.close();
    }
}
