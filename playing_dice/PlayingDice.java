package playing_dice;

import java.io.*;
import java.util.*;

public class PlayingDice {
    public static void main(String[] args) throws IOException {
        long minSecond; // Минимальное количество баллов второго игрока
        long maxSecond ; // Максимальное количепство баллов второго игрока
        String result;
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        long pointFirst = Long.valueOf(sc.nextLine());
        maxSecond = pointFirst * 6;
        if(pointFirst >= 6){
            minSecond =  (pointFirst % 6 == 5) ? pointFirst / 6 + 2 :
                            (pointFirst % 6 == 4) ?  pointFirst / 6 + 3 :
                                    (pointFirst % 6 == 3) ?  pointFirst / 6 + 4 :
                                            (pointFirst % 6 == 2) ? pointFirst / 6  + 5 :
                                                    (pointFirst % 6 == 1) ? pointFirst % 6 * (pointFirst / 6) + 6 : pointFirst / 6;
        }else{
           minSecond = (pointFirst % 5 == 0) ? 2 :
                   (pointFirst % 4 == 0) ? 3 :
                           (pointFirst % 3 == 0) ? 4 :
                                   (pointFirst % 2 == 0) ? 5 : 6;

        }
        result = minSecond + " " + maxSecond;
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(result);
        fileOut.close();
    }
}
