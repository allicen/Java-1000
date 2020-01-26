package treasure;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Treasure {
    private static double[] startUpdate(double[] start, double[] way, int steps){
        double x = start[0] + way[0] * steps;
        double y = start[1] + way[1] * steps;
        return new double[]{x, y};
    }

    public static void main(String[] args) throws IOException {
        double diagonal = Math.sqrt(2)/2;

        Map<Integer, double[]> coordinate = new HashMap<>();
        coordinate.put(1, new double[]{0, 1});
        coordinate.put(2, new double[]{diagonal, diagonal});
        coordinate.put(3, new double[]{1, 0});
        coordinate.put(4, new double[]{diagonal, -diagonal});
        coordinate.put(5, new double[]{0, -1});
        coordinate.put(6, new double[]{-diagonal, -diagonal});
        coordinate.put(7, new double[]{-1, 0});
        coordinate.put(8, new double[]{-diagonal, diagonal});
        double[] start = new double[]{0, 0};

        Scanner sc = new Scanner(new FileReader("input.txt"));
        int index = 0;
        while (sc.hasNextLine()){
            String line = sc.nextLine();
            if(index != 0){
                StringTokenizer st = new StringTokenizer(line, " ");
                while (st.hasMoreTokens()){
                    int direction = Integer.valueOf(st.nextToken());
                    int steps = Integer.valueOf(st.nextToken());
                    start = startUpdate(start, coordinate.get(direction), steps);
                }
            }
            index = 1;
        }

        String x = String.format("%.3f", start[0]).replaceAll(",", ".");
        String y = String.format("%.3f", start[1]).replaceAll(",", ".");

        FileWriter out = new FileWriter("output.txt");
        out.write(x + " " + y);
        out.close();
    }
}
