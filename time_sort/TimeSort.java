package time_sort;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class TimeSort {
    private static ArrayList<String> time = new ArrayList<>();
    private static void getData() throws FileNotFoundException {
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            time.add(sc.nextLine());
        }
       time.remove(0);

        for(int i = 0; i < time.size(); i++){
            StringBuilder newTime = new StringBuilder();
            StringTokenizer st = new StringTokenizer(time.get(i), " ");
            while (st.hasMoreTokens()){
                String str = st.nextToken();
                if (str.length() == 2){
                    newTime.append(str).append(" ");
                }else if(str.length() == 1){
                    newTime.append("0").append(str).append(" ");
                }
            }
            time.set(i, String.valueOf(newTime).trim());
        }
    }

    private static void deleteZero(){
        for(int i = 0; i < time.size(); i++){
            StringBuilder strOut = new StringBuilder();
            StringTokenizer st = new StringTokenizer(time.get(i), " ");
            while (st.hasMoreTokens()){
                int number = Integer.valueOf(st.nextToken());
                strOut.append(String.valueOf(number)).append(" ");
            }
            time.set(i, String.valueOf(strOut).trim());
        }
    }

    public static void main(String[] args) throws IOException {
        getData();
        Collections.sort(time);
        deleteZero();
        StringBuilder result = new StringBuilder();
        for (String line : time){
            result.append(line).append("\n");
        }
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(String.valueOf(result));
        fileOut.close();
    }
}
