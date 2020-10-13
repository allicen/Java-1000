package shooter;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Shooter {

    /**
     * @param onePoint Первая точка
     * @param twoPoint Вторая точка
     * @return Точки лежат на одной прямой включая начало координат, false - иначе
     * */
    private static boolean onOneStraightLine(int[] onePoint, int[] twoPoint) {
        return onePoint[0] * twoPoint[1] - twoPoint[0] * onePoint[1] == 0;
    }

    /**
     * @param onePoint Первая точка
     * @param twoPoint Вторая точка
     * @return true - точки лежат в одной четвети, false - иначе
     * */
    private static boolean pointsOneDirection (int[] onePoint, int[] twoPoint) {
        boolean shotPossible = false;

        // 1 четверть
        if (onePoint[0] > 0 && onePoint[1] >= 0 && twoPoint[0] > 0 && twoPoint[1] >= 0) {
            shotPossible = true;
        }

        // 2 четверть
        if (onePoint[0] <= 0 && onePoint[1] > 0 && twoPoint[0] <= 0 && twoPoint[1] > 0) {
            shotPossible = true;
        }

        // 3 четверть
        if (onePoint[0] < 0 && onePoint[1] <= 0 && twoPoint[0] < 0 && twoPoint[1] <= 0) {
            shotPossible = true;
        }

        // 4 четверть
        if (onePoint[0] >= 0 && onePoint[1] < 0 && twoPoint[0] >= 0 && twoPoint[1] < 0) {
            shotPossible = true;
        }

        return shotPossible;
    }


    public static void main(String[] args) throws IOException {
        ArrayList<int[]> points = new ArrayList<>(); 
        
        Scanner sc = new Scanner(new FileReader("input.txt"));
        while (sc.hasNextLine()) {
            String[] lineArray = sc.nextLine().split(" "); 
            if (lineArray.length == 2) {
                int[] point = new int[2]; 
                point[0] = Integer.parseInt(lineArray[0]);
                point[1] = Integer.parseInt(lineArray[1]);
                points.add(point); 
            }
        }

        // количество выстрелов
        int shotCount = points.size();

        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {

                // проверка первой точки
                if (pointsOneDirection (points.get(i),points.get(j)) && onOneStraightLine(points.get(i), points.get(j))) {
                    points.remove(j);
                    j--;
                    shotCount--;

                    // проверка остальных точек
                    for (int k = j+1; k < points.size(); k++) {
                        if (pointsOneDirection (points.get(i),points.get(k)) && onOneStraightLine(points.get(i), points.get(k))) {
                            points.remove(k);
                            k--;
                            shotCount--;
                        }
                    }
                }
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        out.println(shotCount);
        out.flush();
    }
}
