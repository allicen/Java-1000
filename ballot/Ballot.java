package ballot;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Ballot {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> groups = new ArrayList<>();
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
            while (st.hasMoreTokens()){
                groups.add(Integer.valueOf(st.nextToken()));
            }
        }
        int groupCount = groups.get(0);
        groups.remove(0);
        Collections.sort(groups);

        int numberVoicesWin = 0;
        for(int i = 0; i < groupCount/2+1; i++){
            numberVoicesWin += (groups.get(i) / 2 + 1);
        }

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(numberVoicesWin));
        out.close();
    }
}
