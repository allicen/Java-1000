package maximum_three;

import java.io.*;
import java.util.StringTokenizer;

public class MaximumThree {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int countLine = n;
        byte[][] field = new byte [n][n];

        int row = 0;
        while (countLine > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            int column = 0;
            while (st.hasMoreTokens()) {
                field[row][column] = Byte.parseByte(st.nextToken());
                column++;
            }
            countLine--;
            row++;
        }

        int result = -10000000;
        if (n == 1) {
            result = field[0][0];
        } else {
            for (row = 0; row < n; row++) {
                for (int column = 0; column < n; column++) {
                    int number;
                    int resultTmp = -10000000;

                    // вверх
                    if (row-1 >= 0 && column-1 >= 0) {
                        number = field[row][column] + field[row-1][column] + field[row-1][column-1];
                        if (resultTmp < number) resultTmp = number;
                    }
                    if (row-2 >= 0) {
                        number = field[row][column] + field[row-1][column] + field[row-2][column];
                        if (resultTmp < number) resultTmp = number;
                    }
                    if (row-1 >= 0 && column+1 < n) {
                        number = field[row][column] + field[row-1][column] + field[row-1][column+1];
                        if (resultTmp < number) resultTmp = number;
                    }

                    // вправо
                    if (row-1 >= 0 && column+1 < n) {
                        number = field[row][column] + field[row][column+1] + field[row-1][column+1];
                        if (resultTmp < number) resultTmp = number;
                    }
                    if (column+2 < n) {
                        number = field[row][column] + field[row][column+1] + field[row][column+2];
                        if (resultTmp < number) resultTmp = number;
                    }
                    if (row+1 < n && column+1 < n) {
                        number = field[row][column] + field[row][column+1] + field[row+1][column+1];
                        if (resultTmp < number) resultTmp = number;
                    }

                    // вниз
                    if (row+1 < n && column+1 < n) {
                        number = field[row][column] + field[row+1][column] + field[row+1][column+1];
                        if (resultTmp < number) resultTmp = number;
                    }
                    if (row+2 < n) {
                        number = field[row][column] + field[row+1][column] + field[row+2][column];
                        if (resultTmp < number) resultTmp = number;
                    }
                    if (row+1 < n && column-1 >= 0) {
                        number = field[row][column] + field[row+1][column] + field[row+1][column-1];
                        if (resultTmp < number) resultTmp = number;
                    }

                    // влево
                    if (column-2 >= 0) {
                        number = field[row][column] + field[row][column-1] + field[row][column-2];
                        if (resultTmp < number) resultTmp = number;
                    }
                    if (row+1 < n && column-1 >= 0) {
                        number = field[row][column] + field[row][column-1] + field[row+1][column-1];
                        if (resultTmp < number) resultTmp = number;
                    }
                    if (row-1 >= 0 && column-1 >= 0) {
                        number = field[row][column] + field[row][column-1] + field[row-1][column-1];
                        if (resultTmp < number) resultTmp = number;
                    }

                    if (result < resultTmp) {
                        result = resultTmp;
                    }
                }
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        out.println(result);
        out.flush();
    }
}
