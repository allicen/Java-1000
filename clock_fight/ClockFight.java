package clock_fight;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ClockFight {
    public static void main(String[] args) throws IOException {
        int hourStart = 0, minuteStart = 0, hourFinish = 0, minuteFinish = 0;

        Scanner sc = new Scanner(new FileReader("input.txt"));
        int index = 0;
        while (sc.hasNextLine()){
            StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
            if(index == 0){
                hourStart = Integer.valueOf(st.nextToken());
                minuteStart = Integer.valueOf(st.nextToken());
            }else {
                hourFinish = Integer.valueOf(st.nextToken());
                minuteFinish = Integer.valueOf(st.nextToken());
            }
            index++;
        }

        int hourCount = 0;
        int strokesCount = 0;
        int stroke = hourStart;

        while (true){
            if(hourStart == hourFinish && minuteStart < minuteFinish){
                break;
            }
            hourCount++;
            hourStart++;
            stroke++;
            if(hourStart == 25){
                hourStart = 1;
                stroke = 1;
            }
            if(stroke > 12){
                stroke -= 12;
            }
            strokesCount += stroke;
            if(hourStart == hourFinish){
                break;
            }
        }

        if(minuteStart > 30){
            hourCount--;
        }
        if(minuteFinish > 30){
            hourCount++;
        }

        int result = strokesCount + hourCount;

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(result));
        out.close();
    }
}
