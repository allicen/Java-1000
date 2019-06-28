package thaw;

import java.util.*;
import java.io.*;

public class Thaw {
    private static ArrayList<String> data = new ArrayList<>();
    private static ArrayList<Integer> temp = new ArrayList<>();
    private static ArrayList<Integer> tempPlus = new ArrayList<>();
    private static void getData() throws IOException{
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            data.add(sc.nextLine());
        }
        StringTokenizer st = new StringTokenizer(data.get(1), " ");
        while (st.hasMoreTokens()){
            temp.add(Integer.valueOf(st.nextToken()));
        }
    }
    public static void main(String[] argv) throws IOException{
        getData();
        int j = 0;
        for(Integer i : temp){
            if(i > 0){
                j++;
            }else{
                tempPlus.add(j);
                j = 0;
            }
        }
        tempPlus.add(j);
        tempPlus.sort(Collections.reverseOrder());
        String result = (!tempPlus.isEmpty()) ? String.valueOf(tempPlus.get(0)) : "0";
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(result);
        pw.close();
    }
}
