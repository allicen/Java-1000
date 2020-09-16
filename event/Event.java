package event;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Event {
    private static boolean leap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner dates = new Scanner(new FileReader("input.txt"));
        String[] dateStart = dates.nextLine().split("\\.");
        String[] dateFinish = dates.nextLine().split("\\.");

        int dayCount = 0;
        int dayS = Integer.parseInt(dateStart[0]), monthS = Integer.parseInt(dateStart[1]), yearS = Integer.parseInt(dateStart[2]);
        int dayF = Integer.parseInt(dateFinish[0]), monthF = Integer.parseInt(dateFinish[1]), yearF = Integer.parseInt(dateFinish[2]);

        while (yearS < yearF || (yearS <= yearF && monthS < monthF) || (yearS <= yearF && monthS <= monthF && dayS < dayF)) {
            dayCount++;
            dayS++;

            if (Arrays.asList(1, 3, 5, 7, 8, 10, 12).contains(monthS) && dayS > 31 ||
                Arrays.asList(4, 6, 9, 11). contains(monthS) && dayS > 30 ||
                (monthS == 2 && (leap(yearS) && dayS > 29 || !leap(yearS) && dayS > 28))) {

                dayS = 1;
                monthS++;
            }

            if (monthS > 12) {
                monthS = 1;
                yearS++;
            }
        }

        out.println(dayCount + 1);
        out.flush();
    }
}
