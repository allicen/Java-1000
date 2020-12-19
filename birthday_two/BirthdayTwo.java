package birthday_two;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BirthdayTwo {
    private static boolean yearIsLeap(int year) {
        return year%400 == 0 || year%4 == 0 && year%100 != 0;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        String[] birth = sc.nextLine().split(" ");
        String[] today = sc.nextLine().split(" ");
        int birthDay = Integer.parseInt(birth[0]);
        int birthMonth = Integer.parseInt(birth[1]);
        int todayDay = Integer.parseInt(today[0]);
        int todayMonth = Integer.parseInt(today[1]);
        int todayYear = Integer.parseInt(today[2]);

        int result = 0;

        if (todayMonth != birthMonth || todayDay != birthDay) {

            ArrayList<Integer> monthWith31Days = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 8, 10, 12));
            ArrayList<Integer> monthWith30Days = new ArrayList<>(Arrays.asList(4, 6, 9, 11));

            while (todayMonth != birthMonth || todayDay != birthDay) {
                todayDay++;
                result++;

                if (monthWith31Days.contains(todayMonth) && todayDay == 32) {
                    todayDay = 1;
                    todayMonth++;
                } else if (monthWith30Days.contains(todayMonth) && todayDay == 31) {
                    todayDay = 1;
                    todayMonth++;
                } else if (todayMonth == 2) {
                    if (yearIsLeap(todayYear) && todayDay == 30) {
                        todayDay = 1;
                        todayMonth++;
                    } else if (!yearIsLeap(todayYear) && todayDay == 29) {
                        todayDay = 1;
                        todayMonth++;
                    }
                }

                if (todayMonth == 13) {
                    todayMonth = 1;
                    todayYear++;
                }
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        out.println(result);
        out.flush();
    }
}
