package road;

import java.util.*;
import java.io.*;

public class Road {
    private static ArrayList<Integer> number = new ArrayList<>();
    private static void getData() throws IOException{
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        String str;
        while (sc.hasNextLine()){
            str = sc.nextLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            while (st.hasMoreTokens()){
                number.add(Integer.valueOf(st.nextToken()));
            }
        }
    }
    public static void main(String[] argv) throws IOException{
        getData();
        int roadCount = 0;
        for(int i = 0; i < number.size(); i++){
            if(i != 0){
                if(number.get(i) == 1){
                    roadCount++;
                }
            }
        }
        roadCount = roadCount / 2;
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(String.valueOf(roadCount));
        pw.close();
    }
}
