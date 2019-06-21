package tea;

import java.io.*;
import java.util.*;

public class Tea {
    public static void main(String[] args) throws IOException {
        ArrayList<String> data = new ArrayList<>(); // Входные данные
        ArrayList<Integer> tee =  new ArrayList<>(); // Тройники
        int maxKettleCount = 0;
        int result = 0;
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            data.add(sc.nextLine());
        }
        StringTokenizer st = new StringTokenizer(data.get(1), " ");
        while (st.hasMoreTokens()){
            tee.add(Integer.valueOf(st.nextToken()));
        }
        for(Integer i : tee){
            maxKettleCount = maxKettleCount + i;
        }
        tee.sort(Collections.reverseOrder());
        if(Integer.valueOf(data.get(0)) == 1){ // Если тройник один
            result = maxKettleCount;
        }else { // Если тройников несколько
            for(Integer i : tee){
                result += i - 1;
            }
            result = result + 1;
        }
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(String.valueOf(result));
        fileOut.close();
    }
}

