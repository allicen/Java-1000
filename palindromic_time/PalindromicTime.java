package palindromic_time;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PalindromicTime {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(sc.nextLine(), ":");
        int hourIn = Integer.valueOf(st.nextToken());
        int minuteIn = Integer.valueOf(st.nextToken());

        StringBuffer hour;
        StringBuffer minute;

        while (true){
            minuteIn++;

            if(minuteIn >=59){
                hourIn++;
                minuteIn = -1;
            }
            if(hourIn == 24){
                hourIn = 0;
            }

            hour = String.valueOf(hourIn).length() == 1 ? new StringBuffer("0" + hourIn) : new StringBuffer(String.valueOf(hourIn));
            minute = String.valueOf(minuteIn).length() == 1 ? new StringBuffer("0" + minuteIn) : new StringBuffer(String.valueOf(minuteIn));
            minute.reverse();

            if(String.valueOf(hour).equals(String.valueOf(minute))){
                minute.reverse();
                break;
            }
        }

        String result = String.valueOf(hour) + ":" + String.valueOf(minute);
        FileWriter out = new FileWriter("output.txt");
        out.write(result);
        out.close();
    }
}
