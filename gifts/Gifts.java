package gifts;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Gifts {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        int x = Integer.valueOf(st.nextToken());
        int y = Integer.valueOf(st.nextToken());
        int z = Integer.valueOf(st.nextToken());
        int total = Integer.valueOf(st.nextToken());

        int count = 0;

        for(int i = 0; i <= total; i += x){
            for (int j = 0; j <= total-i; j += y){
                for(int k = 0; k <= total - (i + j); k += z){
                    if(i + j + k == total){
                        count++;
                    }
                }
            }
        }

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(count));
        out.close();
    }
}
