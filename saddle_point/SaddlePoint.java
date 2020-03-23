package saddle_point;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SaddlePoint {
    public static void main(String[] args) throws IOException {
        int[][] data = new int[0][];
        int[] minRow = new int[0];
        int[][] maxColumn = new int[0][];
        int result = 0;

        Scanner scan = new Scanner(new FileReader("input.txt"));
        int line = -1;
        while (scan.hasNextLine()){
            String[] tokens = scan.nextLine().split(" ");
            if(line == -1){
                int row = Integer.valueOf(tokens[0]);
                int column = Integer.valueOf(tokens[1]);
                minRow = new int[row];
                maxColumn = new int[column][2];
            }else {
                for (int i = 0; i < tokens.length; i++) {
                    int token = Integer.valueOf(tokens[i]);
                    if(minRow[line] == 0 || minRow[line] > token){
                        minRow[line] = token;
                    }

                    if(maxColumn[i][1] == 0 || maxColumn[i][1] < token){
                        maxColumn[i][0] = line;
                        maxColumn[i][1] = token;
                    }
                }
            }
            line++;
        }

        for (int i = 0; i < maxColumn.length; i++) {
            if(maxColumn[i][1] == minRow[maxColumn[i][0]]){
                result++;
            }
        }

        System.out.println(result);
        System.out.println(Arrays.toString(minRow));
        System.out.println(Arrays.deepToString(maxColumn));
    }
}
