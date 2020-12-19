package timer;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Timer {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        String[] time = sc.nextLine().split(":");
        String[] addTime = sc.nextLine().split(":");

        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);
        int seconds = Integer.parseInt(time[2]);
        int addHour = 0;
        int addMinute = 0;
        int addSecond;
        int addDays = 0;

        if (addTime.length == 3) {
            addHour = Integer.parseInt(addTime[0]);
            addMinute = Integer.parseInt(addTime[1]);
            addSecond = Integer.parseInt(addTime[2]);
        } else if (addTime.length == 2) {
            addMinute = Integer.parseInt(addTime[0]);
            addSecond = Integer.parseInt(addTime[1]);
        } else {
            addSecond = Integer.parseInt(addTime[0]);
        }

        if (seconds == 60) {
            seconds = 59;
            addSecond += 1;
        }

        if (minute == 60) {
            minute = 59;
            addMinute += 1;
        }

        seconds += addSecond;
        minute += addMinute;
        hour += addHour;

        if (seconds > 59) {
            minute += seconds / 60;
            seconds %= 60;
        }

        if (minute > 59) {
            hour += minute / 60;
            minute %= 60;
        }

        if (hour > 23) {
            addDays = hour / 24;
            hour %= 24;
        }

        PrintWriter out = new PrintWriter(System.out);

        if (hour < 10) {
            out.print("0");
        }
        out.print(hour + ":");

        if (minute < 10) {
            out.print("0");
        }
        out.print(minute + ":");

        if (seconds < 10) {
            out.print("0");
        }
        out.print(seconds);

        if (addDays > 0) {
            out.print("+" + addDays + " days");
        }

        out.flush();
    }
}
