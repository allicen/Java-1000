package neznaika;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Neznaika {
    public static void main(String[] args) throws IOException {
        int t1, t2, s1, s2, s;
        Scanner sc = new Scanner(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        t1 = Integer.valueOf(st.nextToken());
        t2 = Integer.valueOf(st.nextToken());
        s1 = Integer.valueOf(st.nextToken());
        s2 = Integer.valueOf(st.nextToken());
        s = Integer.valueOf(st.nextToken());

        String result = "";

        if(s1 <= s2) {
            result = "NO";
        }else {
            double v1 = (double) s1/t1;
            double way = 0, time = 0;
            if(s <= s1){
                time = s * v1;
            }else {
                while (true){
                    way += s1;
                    if(way >= s){
                        if(way == s){
                            time += t1;
                        }else {
                            double delta = (t1 - (s - s1) / v1);
                            System.out.println(delta);
                            time += delta;
                        }
                        break;
                    }else {
                        time += t1;
                        way -= s2;
                        time += t2;
                    }
                }
            }
            result = String.valueOf(time);
        }

        FileWriter out = new FileWriter("output.txt");
        out.write(result);
        out.close();
    }
}
