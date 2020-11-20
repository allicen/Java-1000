package minimum_path_table;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MinimumPathTable {

    private static int n = 0;
    private static int m = 0;


    // получить данные
    private static int[][] _getData() throws IOException {
        int [][] data = new int[0][];

        Scanner sc = new Scanner(new FileReader("input.txt"));
        int row = -1;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (row > -1) {
                String[] cells = line.split(" ");
                for (int column = 0; column < cells.length; column++) {
                    data[row][column] = Integer.parseInt(cells[column]);
                }
            } else {
                String[] size = line.split(" ");
                n = Integer.parseInt(size[0]);
                m = Integer.parseInt(size[1]);
                data = new int[n][m];
            }

            row++;
        }

        return data;
    }

    public static void main(String[] args) throws IOException {
        int[][] data = _getData();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i > 0 && j > 0) {
                    data[i][j] += Math.min(data[i-1][j], data[i][j-1]);
                } else if (i > 0) {
                    data[i][j] += data[i-1][j];
                } else if (j > 0) {
                    data[i][j] += data[i][j-1];
                }
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        out.println(data[n-1][m-1]);
        out.flush();

    }
}
