package traps;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Traps {
    public static void main(String[] args) throws IOException {
        ArrayList<String> data = new ArrayList<>();
        Scanner sc = new Scanner(new FileReader("input.txt"));
        while (sc.hasNextLine()){
            data.add(sc.nextLine());
        }
        data.remove(0);
        data.add("0 0");

        int x = 0, y = 0, xprev = 0, yprev = 0;
        double way = 0;

        for(String line : data){
            StringTokenizer st = new StringTokenizer(line, " ");
            while (st.hasMoreTokens()){
                x = Integer.valueOf(st.nextToken());
                y = Integer.valueOf(st.nextToken());
            }

            way += Math.sqrt(Math.pow(x - xprev, 2) + Math.pow(y - yprev, 2));
            xprev = x;
            yprev = y;
        }

        String result = String.format("%.3f", way).replaceAll(",", ".");

        FileWriter out = new FileWriter("output.txt");
        out.write(result);
        out.close();
    }
}
