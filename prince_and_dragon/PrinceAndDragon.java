package prince_and_dragon;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PrinceAndDragon {
    public static void main(String[] args) throws IOException {
        ArrayList<Long> data = new ArrayList<>();
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        while (st.hasMoreTokens()){
            data.add(Long.valueOf(st.nextToken()));
        }

        long bladeCutCount = data.get(0); //n
        long dragonHeadCount = data.get(1); //m
        long regenerationHeadCount = data.get(2); //k

        int duelCount = 0;

        if(bladeCutCount >= dragonHeadCount){
            duelCount = 1;
        }else if(bladeCutCount + regenerationHeadCount < dragonHeadCount){
            duelCount = Math.toIntExact((dragonHeadCount - bladeCutCount - 1) / (bladeCutCount - regenerationHeadCount) + 2);
        }

        String result = (duelCount == 0) ? "NO" : String.valueOf(duelCount);

        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(String.valueOf(result));
        fileOut.close();

    }
}
