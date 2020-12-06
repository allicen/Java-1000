package base_of_terrorists;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class BaseOfTerrorists {
    public static void main(String[] args) throws IOException {
        Scanner sc  = new Scanner(new FileReader("input.txt"));
        String[] baseInfo = sc.nextLine().split(" ");
        int n = Integer.parseInt(baseInfo[0]);
        int m = Integer.parseInt(baseInfo[1]);

        char[][] base = new char[n][m];

        int lineIndex = 0;
        while (n > 0) {
            String line = sc.nextLine();
            base[lineIndex] = line.toCharArray();
            lineIndex++;
            n--;
        }

        String[] mapInfo = sc.nextLine().split(" ");
        n =  Integer.parseInt(mapInfo[0]);
        m =  Integer.parseInt(mapInfo[1]);
        char[][] map = new char[n][m];
        lineIndex = 0;
        while (sc.hasNextLine()) {
            map[lineIndex] = sc.nextLine().toCharArray();
            lineIndex++;
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == base[0][0] || map[i][j] == '#') {
                    boolean exit = false;
                    for (int k = 0; k < base.length; k++) {
                        for (int l = 0; l < base[k].length; l++) {
                            if (i+k >= n || j+l >= m) {
                                exit = true;
                                break;
                            } else if (base[k][l] != map[i+k][j+l] && map[i+k][j+l] != '#') {
                                exit = true;
                                break;
                            }
                        }
                        if (exit) break;
                    }

                    if (!exit) result++;
                }
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        out.println(result);
        out.flush();
    }
}
