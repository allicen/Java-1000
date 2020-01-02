package artist;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Artist {
    public static void main(String[] args) throws IOException {
        int height = 0, width = 0;
        int[][] canvas = new int[0][];
        ArrayList<int[]> points = new ArrayList<>();

        Scanner sc = new Scanner(new FileReader("input.txt"));
        int index = 0;

        while (sc.hasNextLine()){
            StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
            while (st.hasMoreTokens()){
                if(index == 0){
                    width = Integer.valueOf(st.nextToken());
                    height = Integer.valueOf(st.nextToken());
                    canvas = new int[width][height];
                }else if(index> 1){
                    int x1 = Integer.valueOf(st.nextToken()),
                            y1 = Integer.valueOf(st.nextToken()),
                            x2 = Integer.valueOf(st.nextToken()),
                            y2 = Integer.valueOf(st.nextToken());
                    points.add(new int[]{x1, y1, x2, y2});
                }else {
                    st.nextToken();
                }
            }
            index++;
        }

        int painted = 0;
        for (int[] point : points) {
            int x1 = point[0];
            int y1 = point[1];
            int x2 = point[2];
            int y2 = point[3];
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    if ((x >= x1 && x < x2) && (y >= y1 && y < y2)) {
                        if(canvas[x][y] != 1){
                            painted++;
                            canvas[x][y] = 1;
                        }
                    } else {
                        if (canvas[x][y] != 1) {
                            canvas[x][y] = 0;
                        }
                    }
                }
            }
        }

        int result = width * height - painted;

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(result));
        out.close();
    }
}
