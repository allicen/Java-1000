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
                long number = Long.parseLong(line[j]);
                // проверка каждого элемента
                if (number < s) {
                    count++;
                }
                matrix[i][j] = number;
            }
        }

        int min = Math.min(n, m);
        int countCell = 2;
        int rowStart = 0;
        int columnStart = 0;
        boolean exit = false;

        // проверка квадратов
        while (countCell <= min) {
            long sumTmp = -1;
            for (int i = rowStart; i < rowStart+countCell; i++) {
                for (int j = columnStart; j < columnStart+countCell; j++) {
                    if (rowStart+countCell <= n && columnStart+countCell <= m) {
                        long number = matrix[i][j];

                        if (number >= s) {
                            exit = true;
                            break;
                        }

                        if (sumTmp == -1) {
                            sumTmp = number;
                        } else {
                            sumTmp += number;
                        }

                        if (sumTmp > s) { // выйти, если условие невозможно
                            exit = true;
                            break;
                        }
                    }
                }

                if (exit) {
                    break;
                }
            }

            if (!exit && sumTmp > -1 && sumTmp < s) {
                count++;
            }
            rowStart++; // сдвиг вправо
            exit = false;
            if (rowStart > n) { // сдвиг вниз
                rowStart = 0;
                columnStart++;
            }
            if (columnStart > m) { // увеличение размера квадрата
                rowStart = 0;
                columnStart = 0;
                countCell++;
            }
        }

        out.println(count);
        out.flush();

    }
}
