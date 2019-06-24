package census;

import java.io.*;
import java.util.*;

public class Census {
    private static ArrayList<Integer> data = new ArrayList<>();
    private static int oldManNumber = -1;
    private static int manAge = 0;

    private static void dataValidation(){ //
        int j = 0; // Счетчик номера жильца
        for (int i = 0; i < data.size(); i++){
            if(data.get(i) != 0 && i % 2 == 1){
                j++;
            }
            if(i % 2 == 1 && data.get(i+1) == 1 && i+1 < data.size()){ // Проверка возраста мужчины
                if(data.get(i) > manAge){
                    manAge = data.get(i);
                    oldManNumber = j;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        String str;
        while (sc.hasNextLine()){
            str = sc.nextLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            while (st.hasMoreTokens()){
                data.add(Integer.valueOf(st.nextToken()));
            }
        }
        dataValidation();
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(String.valueOf(oldManNumber));
        fileOut.close();
    }
}
