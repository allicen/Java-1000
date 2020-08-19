package mockery;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Mockery {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        int[][] matrix = new int[0][];
        int row = -1;

        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            if (row == -1) {
                int size = Integer.parseInt(str);
                matrix = new int[size][size];
            } else {
                StringTokenizer st = new StringTokenizer(str, " ");
                int column = 0;
                while (st.hasMoreTokens()){
                    matrix[row][column] = Integer.parseInt(st.nextToken());
                    column++;
                }
            }
            row++;
        }

        int shortestWay = Integer.MAX_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i < j) {
                    for (int k = 0; k < matrix.length; k++) {
                        if (matrix[i][j] != 0 && matrix[i][k] != 0 && matrix[j][k] != 0) {
                            int sumRouds = matrix[i][j] +  matrix[i][k] + matrix[j][k];

                            if (shortestWay > sumRouds) {
                                shortestWay = sumRouds;
                            }
                        }
                    }
                }
            }
        }
        PrintWriter out = new PrintWriter(System.out);
        out.println(shortestWay);
        out.flush();

    }
}
