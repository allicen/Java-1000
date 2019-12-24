package beautiful_wall;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BeautifulWall {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        long tilingCount = sc.nextLong();

        long best = tilingCount;
        StringBuilder bestStr = new StringBuilder();

        for(int i = 0; i <= tilingCount/(Math.sqrt(tilingCount)); i++){
            for(int j = 0; j <= tilingCount/2+1; j++){
                if(i * j <= tilingCount){
                    long div = tilingCount - (i * j);
                    long square = Math.abs(i - j);
                    long beautifulVal = div + square;

                    if(best > beautifulVal){
                        best = beautifulVal;
                        bestStr = new StringBuilder();
                        bestStr.append(i).append(" ").append(j);
                    }
                }else break;
            }
        }

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(bestStr));
        out.close();
    }
}
