package game_meter;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class GameMeter {
    /**
     * @param x1, y1, x2, y2 Координаты точек
     * @return Расстояние между двумя точками
     * */
    private static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        ArrayList<String[]> coordinates = new ArrayList<>();
        Set<Double> result = new TreeSet<>();

        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split(" ");
            if (line.length == 2) {
                coordinates.add(line);
            }
        }

        for (int i = 0; i < coordinates.size(); i++) {
            for (int j = 0; j < coordinates.size(); j++) {
                if (i != j) {
                    result.add(distance(Integer.parseInt(coordinates.get(i)[0]),
                            Integer.parseInt(coordinates.get(i)[1]),
                            Integer.parseInt(coordinates.get(j)[0]), Integer.parseInt(coordinates.get(j)[1])));
                }
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        out.println(result.size());
        for (double number: result) {
            out.println(number);
        }
        out.flush();
    }
}
