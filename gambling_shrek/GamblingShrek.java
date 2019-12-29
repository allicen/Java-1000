package gambling_shrek;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class GamblingShrek {
    public static void main(String[] args) throws IOException {
        ArrayList<Long> data = new ArrayList<>();
        Scanner sc = new Scanner(new FileReader("input.txt"));
        while (sc.hasNextLine()){
            StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
            while (st.hasMoreTokens()){
                data.add(Long.valueOf(st.nextToken()));
            }
        }
        data.remove(0);
        Collections.sort(data);

        long dialer = 0;
        long player = 0;

        for(int i = 0; i < data.size(); i++){
            if(i < data.size()/2){
                dialer += data.get(i);
            }else {
                player += data.get(i);
            }
        }

        long result = player - dialer;

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(result));
        out.close();
    }
}
