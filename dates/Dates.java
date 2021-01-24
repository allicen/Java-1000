package dates;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Dates {
    public static void main(String[] args) throws IOException, ParseException {
        int dayCount = new Scanner(new FileReader("input.txt")).nextInt();

        final String startDay = "2008-01-01";
        final SimpleDateFormat dayFormat = new SimpleDateFormat( "yyyy-MM-dd" );
        final Date date = dayFormat.parse(startDay);
        final Calendar calendar = GregorianCalendar.getInstance();

        calendar.setTime(date);
        calendar.add( GregorianCalendar.DAY_OF_WEEK, dayCount);

        int dayWeekNumber = calendar.get(Calendar.DAY_OF_WEEK);
        String dayWeek = "";

        switch (dayWeekNumber) {
            case 1:
                dayWeek = "Sunday";
                break;
            case 2:
                dayWeek = "Monday";
                break;
            case 3:
                dayWeek = "Tuesday";
                break;
            case 4:
                dayWeek = "Wednesday";
                break;
            case 5:
                dayWeek = "Thursday";
                break;
            case 6:
                dayWeek = "Friday";
                break;
            case 7:
                dayWeek = "Saturday";
                break;
        }

        PrintWriter out = new PrintWriter(System.out);
        out.printf("%s, %td.%tm", dayWeek, calendar, calendar);
        out.flush();
    }
}
