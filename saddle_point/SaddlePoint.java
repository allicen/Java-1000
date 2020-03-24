package saddle_point;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SaddlePoint {
    public static void main(String[] args) throws IOException {
        int[][] data = new int[0][];
        int[] minRow = new int[0];
        int[] maxColumn = new int[0];
        int result = 0;

        Scanner scan = new Scanner(new FileReader("input.txt"));
        int line = -1;
        while (scan.hasNextLine()){
            String[] tokens = scan.nextLine().split("( )+");
            if(line == -1){
                int row = Integer.valueOf(tokens[0]);
                int column = Integer.valueOf(tokens[1]);

                data = new int[row][column];
                minRow = new int[row];
                maxColumn = new int[column];
            }else {
                for (int col = 0; col < tokens.length; col++) {
                    int token = Integer.valueOf(tokens[col]);
                    if(minRow[line] == 0 || minRow[line] > token){
                        minRow[line] = token;
                    }

                    if(maxColumn[col] == 0 || maxColumn[col] < token){
                        maxColumn[col] = token;
                    }

                    data[line][col] = token;
                }
            }
            line++;
        }

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] == minRow[i]) {
                    if (data[i][j] == maxColumn[j]) {
                        result++;
                    }
                }
            }
        }

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(result));
        out.close();
    }
}
