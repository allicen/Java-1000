package dots_on_dominoes;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class DotsOnDominoes {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        int maxDots = sc.nextInt();
        long count = 0;
        for(int i = 0; i <= maxDots; i++){
            for(int j = 0; j <= maxDots; j++){
                if(i <= j){
                    count += (i+j);
                }
            }
        }

        System.out.println(count);

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(count));
        out.close();
    }
}
