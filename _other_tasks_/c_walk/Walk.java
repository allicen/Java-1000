package _other_tasks_.c_walk;

import java.io.PrintWriter;
import java.util.Scanner;

public class Walk {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        String[] info = in.nextLine().split(" ");
        int n = Integer.parseInt(info[0]);
        int m = Integer.parseInt(info[1]);
        long s = Long.parseLong(info[2]);

        int count = 0;

        long[][] matrix = new long[n][m];

        for (int i = 0; i < n; i++) {
            String[] line = in.nextLine().split(" ");
            for (int j = 0; j < line.length; j++) {
                matrix[i][j] = Long.parseLong(line[j]);
            }
        }

        // проверка 1 элемента
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] < s) {
                    count++;
                }
            }
        }

        int min = Math.min(n, m);
        int countCell = 2;
        int rowStart = 0;
        int columnStart = 0;
        boolean exit = false;

        // проверка квадратов
        while (countCell <= min) {
            long sumTmp = 0;
            for (int i = rowStart; i < rowStart+countCell; i++) {
                for (int j = columnStart; j < columnStart+countCell; j++) {
                    if (rowStart+countCell <= n && columnStart+countCell <= m) {
                        long number = matrix[i][j];

                        if (number > s) {
                            exit = true;
                            break;
                        }

                        sumTmp += number;

                        if (sumTmp > s) {
                            exit = true;
                            break;
                        }
                    }
                }

                if (exit) {
                    break;
                }
            }

            if (!exit && sumTmp > 0 && sumTmp < s) {
                count++;
            }
            rowStart++;
            exit = false;
            if (rowStart > n) {
                rowStart = 0;
                columnStart++;
            }
            if (columnStart > m) {
                rowStart = 0;
                columnStart = 0;
                countCell++;
            }
        }

        out.println(count);
        out.flush();

    }
}
