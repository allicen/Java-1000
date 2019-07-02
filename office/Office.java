package office;

import java.util.*;
import java.io.*;

public class Office {
    private static ArrayList<Integer> data = new ArrayList<>();
    private static void getData() throws IOException{
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            String str = sc.nextLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            while (st.hasMoreTokens()){
                data.add(Integer.valueOf(st.nextToken()));
            }
        }
    }
    public static void main(String[] argv) throws IOException{
        getData();
        int peopleAllDay = 0;
        for (Integer aData : data) {
            peopleAllDay += aData;
        }
        int result = peopleAllDay / 27;
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(String.valueOf(result));
        pw.close();
    }
}
