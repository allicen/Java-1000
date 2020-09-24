package robot_k79;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class RobotK79 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);

        ArrayList<String> points = new ArrayList<>();
        String[] steps = new Scanner(new FileReader("input.txt")).nextLine().split("");

        int x = 0, y = 0; // кординаты движения
        int directNumber = 0, stepCount = 0;
        boolean success = false;

        points.add(x + String.valueOf(y));
        for (String step : steps) {
            if (step.equals("S")) { // шаг вперед
                stepCount++;
                switch (directNumber) {
                    case 0: // навправо
                        x++;
                        break;
                    case 1: // вверх
                        y++;
                        break;
                    case 2: // налево
                        x--;
                        break;
                    case 3: // вниз
                        y--;
                        break;
                }
                String coordinate = x + String.valueOf(y);

                if (points.contains(coordinate)) {
                    out.println(stepCount);
                    success = true;
                    break;
                }
                points.add(coordinate);
            } else if (step.equals("L")) { // налево
                directNumber++;
            } else { // направо
                directNumber--;
            }

            if (directNumber > 3) {
                directNumber = 0;
            } else if (directNumber < 0) {
                directNumber = 3;
            }
        }

        if (!success) {
            out.println(-1);
        }

        out.flush();
    }
}
