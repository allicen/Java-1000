package military_base;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MilitaryBase {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        String[] field = sc.nextLine().split(" ");
        int n = Integer.parseInt(field[0]);
        int m = Integer.parseInt(field[1]);

        char[][] map = new char[n][m];
        int result = 0;

        int row = 0;
        while (sc.hasNextLine()) {
            map[row] = sc.nextLine().toCharArray();
            row++;
        }

        int start = -1, finish;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (map[i][j] == '#' && start == -1) {
                    start = j;
                }

                if (start > -1 && (j == m-1 || map[i][j] == '.')) {
                    if (map[i][j] == '#') {
                        finish = j;
                    } else finish = j-1;

                    result++;

                    if (i+1 < n && map[i+1][start] == '#') {
                        for (int down = i+1; down < n; down++) {
                            boolean exit = false;
                            for (int k = start; k <= finish; k++) {
                                if (map[down][k] == '#') {
                                    map[down][k] = '.';
                                } else {
                                    exit = true;
                                    break;
                                }
                            }
                            if (exit) break;
                        }
                    }
                    start = -1;
                }
            }
        }
        PrintWriter out = new PrintWriter(System.out);
        out.println(result);
        out.flush();
    }
}
