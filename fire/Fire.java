package fire;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Fire {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> data = new ArrayList<>();
        Scanner sc = new Scanner(new FileReader("input.txt"));
        while (sc.hasNextLine()){
            StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
            while (st.hasMoreTokens()){
                data.add(Integer.valueOf(st.nextToken()));
            }
        }
        int n = data.get(0), m = data.get(1);
        data.remove(0);
        data.remove(0);

        boolean success = true;
        int time = 0;
        for (int i = 0; i < data.size(); i++){
            if(data.get(i) > m){
                success = false;
            }
            if(i != data.size()-1){
                time += data.get(i) - 1;
            }else {
                time += data.get(i);
            }
        }
        String result = time >= m && success ? "yes" : "no";

        FileWriter out = new FileWriter("output.txt");
        out.write(result);
        out.close();
    }
}
