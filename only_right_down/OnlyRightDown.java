package only_right_down;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class OnlyRightDown {
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
        int[][] data = _getData(); // данные
        int[][] ways = new int[n][m]; // подсчет шагов
        ways[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // значение в последней клетке не учитываем
                if (i == n-1 && j == m-1) {
                    break;
                }
                int num = data[i][j];

                if (ways[i][j] > 0) {
                    if (i+num < n) { // можно сделать шаг по вертикали
                        ways[i+num][j] += ways[i][j];
                    }
                    if (j+num < m) { // можно сделать шаг по горизонтали
                        ways[i][j+num] += ways[i][j];
                    }
                }
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        out.println(ways[n-1][m-1]);
        out.flush();
    }
}
