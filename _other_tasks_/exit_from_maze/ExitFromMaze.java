package _other_tasks_.exit_from_maze;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;

public class ExitFromMaze {
    public static void main(String[] args) throws IOException {

        BufferedReader sc = new BufferedReader(new FileReader("input.txt"));
        int index = 0, n = 0, m = 0;
        int[] menCoord = new int[2];
        int[] houseCoord = new int[2];
        int[][] labirint = new int[0][0];

        for (String line; (line = sc.readLine()) != null; ) {
            String[] str = line.split(" ");
            if (index == 0) {
                n = Integer.parseInt(str[0]);
                m = Integer.parseInt(str[1]);
                labirint = new int[n][m];
            } else if (index == n + 1) {
                menCoord[0] = Integer.parseInt(str[1])-1;
                menCoord[1] = Integer.parseInt(str[0])-1;
            } else if (index == n + 2) {
                houseCoord[0] = Integer.parseInt(str[1])-1;
                houseCoord[1] = Integer.parseInt(str[0])-1;
            } else {
                for (int i = 0; i < str.length; i++) {
                    short num = Short.parseShort(str[i]);
                    if (num == 1) {
                        labirint[index-1][i] = -1;
                    }
                }
            }

            index++;
        }

        labirint[menCoord[0]][menCoord[1]] = 1;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.addLast(menCoord);

        while (!queue.isEmpty()) {
            int[] point = queue.getFirst();
            queue.removeFirst();

            if (point[0] == houseCoord[0] && point[1] == houseCoord[1]) {
                System.out.println(labirint[point[0]][point[1]] - 1);
                return;
            }

            if (point[0] - 1 >= 0 && labirint[point[0] - 1][point[1]] == 0) { // вверх
                labirint[point[0] - 1][point[1]] = labirint[point[0]][point[1]] + 1;
                int[] tmp = new int[2];
                tmp[0] = point[0] - 1;
                tmp[1] = point[1];
                queue.addLast(tmp);
            }

            if (point[1] + 1 < m && labirint[point[0]][point[1] + 1] == 0) { // вправо
                labirint[point[0]][point[1] + 1] = labirint[point[0]][point[1]] + 1;
                int[] tmp = new int[2];
                tmp[0] = point[0];
                tmp[1] = point[1] + 1;
                queue.addLast(tmp);
            }

            if (point[0] + 1 < n && labirint[point[0] + 1][point[1]] == 0) { // вниз
                labirint[point[0] + 1][point[1]] = labirint[point[0]][point[1]] + 1;
                int[] tmp = new int[2];
                tmp[0] = point[0] + 1;
                tmp[1] = point[1];
                queue.addLast(tmp);
            }

            if (point[1] - 1 >= 0 && labirint[point[0]][point[1] - 1] == 0) { // влево
                labirint[point[0]][point[1] - 1] = labirint[point[0]][point[1]] + 1;
                int[] tmp = new int[2];
                tmp[0] = point[0];
                tmp[1] = point[1] - 1;
                queue.addLast(tmp);
            }
        }

        System.out.println(-1);
    }
}
