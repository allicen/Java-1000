package symmetry;

import java.util.*;
import java.io.*;

public class Symmetry {
    private static ArrayList<Long> data = new ArrayList<>();
    private static void getData() throws IOException{
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            String str = sc.nextLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            while (st.hasMoreTokens()){
                data.add(Long.valueOf(st.nextToken()));
            }
        }
    }
    public static void main(String[] argv) throws IOException{
        getData();
        long x, y;
        if(data.get(0).equals(data.get(2))){ // Если прямая параллельна y
            x = data.get(0) + (data.get(2) - data.get(4));
            y = data.get(5);
        }else{ // Если прямая параллельна x
            x = data.get(4);
            y = data.get(1) + (data.get(3) - data.get(5));
        }
        String result = x + " " + y;
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(result);
        pw.close();
    }
}
