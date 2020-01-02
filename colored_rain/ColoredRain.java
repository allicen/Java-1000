package colored_rain;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ColoredRain {
    public static void main(String[] args) throws IOException {
        int[][] matrix = new int[0][];
        int[] color = new int[0];
        int row = -1;
        Scanner sc = new Scanner(new FileReader("input.txt"));
        int rowCount = 0;
        while (sc.hasNextLine()){
            if(row == -1){
                rowCount = Integer.valueOf(sc.nextLine());
                matrix = new int[rowCount][rowCount];
            }else if(row >= 0 && row < rowCount){
                StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
                int column = 0;
                while (st.hasMoreTokens()){
                    matrix[row][column] = Integer.valueOf(st.nextToken());
                    column++;
                }
            }else {
                StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
                int column = 0;
                color = new int[rowCount];
                while (st.hasMoreTokens()){
                    color[column] = Integer.valueOf(st.nextToken());
                    column++;
                }
            }
            row++;
        }

        int bad = 0;
        for(int i = 0; i< rowCount; i++){
            for(int j = i; j < rowCount; j++){
                if(matrix[i][j] == 1){
                    if(color[i] != color[j]){
                        bad++;
                    }
                }
            }
        }

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(bad));
        out.close();
    }
}
