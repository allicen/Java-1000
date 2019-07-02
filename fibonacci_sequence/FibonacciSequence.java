package fibonacci_sequence;

import java.util.*;
import java.io.*;

public class FibonacciSequence {
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
        int a = data.get(1);
        int b = data.get(2);
        int c = data.get(2);
        for(int i = data.get(0) - 1; i > 0; i--){
            a = b - a;
            b = c - a;
            c = b;
        }
        String result = a + " " + b;
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(result);
        pw.close();
    }
}
