package community_of_robots;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Scanner;

public class CommunityOfRobots {
    private static final int ROBOT_COUNT_FOR_GROUP_THREE = 5;
    private static final int ROBOT_COUNT_FOR_GROUP_FIVE = 9;

    private static long _robotMaxCount(long robotCountStart) {
        long fiveGroup = robotCountStart / 5;
        long threeGroup = (robotCountStart - (fiveGroup * 5)) / 3;
        long result = threeGroup * ROBOT_COUNT_FOR_GROUP_THREE + fiveGroup * ROBOT_COUNT_FOR_GROUP_FIVE;

        // максимальное количество групп по 5
        while (true) {
            boolean threePow = (robotCountStart - fiveGroup * 5 ) % 3 == 0;
            if (threePow) { // если есть группы по 5 и по 3
                threeGroup = (robotCountStart - fiveGroup * 5) / 3;

                long resultTmp = threeGroup * ROBOT_COUNT_FOR_GROUP_THREE + fiveGroup * ROBOT_COUNT_FOR_GROUP_FIVE;

                if (result < resultTmp) {
                    result = resultTmp;
                }

                break;
            } else {
                fiveGroup -= 1;
            }

            if (fiveGroup < 0) {
                break;
            }
        }

        threeGroup = robotCountStart / 3;

        // максимальное количество групп по 3
        long resultTmp = threeGroup * ROBOT_COUNT_FOR_GROUP_THREE;
        if (result < resultTmp) {
            result = resultTmp;
        }

        return result;
    }


    public static void main(String[] args) throws IOException {
        String[] data = new Scanner(new FileReader("input.txt")).nextLine().split(" ");
        long k = Long.parseLong(data[0]);
        int n = Integer.parseInt(data[1]);

        long robotCount = k;

        ArrayDeque<Long> process = new ArrayDeque<>();
        process.addLast(k);
        for (int i = 1; i <= n; i++) {
            // удаление роботов с 3го года
            if (i > 3) {
                robotCount -= process.removeFirst();
            }

            // последний год
            if (i == n) {
                break;
            }

            long count = _robotMaxCount(robotCount);
            robotCount += count;
            process.addLast(count);
        }

        PrintWriter out = new PrintWriter(System.out);
        out.println(robotCount);
        out.flush();
    }
}
