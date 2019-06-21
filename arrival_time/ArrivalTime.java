package arrival_time;

import java.io.*;
import java.util.*;

public class ArrivalTime {
    public static void main(String[] args) throws IOException {
        ArrayList<String> data = new ArrayList<>(); // Входные данные построчно
        ArrayList<String> time = new ArrayList<>(); // Все время
        int hourLimit = 24;
        int minuteLimit = 60;
        int hour = 0, minute;
        String result;
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            data.add(sc.nextLine());
        }
        StringTokenizer stringOne = new StringTokenizer(data.get(0), ":"); // Добавить 1 строку в коллекцию
        while (stringOne.hasMoreTokens()){
            time.add(stringOne.nextToken());
        }
        StringTokenizer stringTwo = new StringTokenizer(data.get(1), " "); // Добаивть вторую строку в коллекцию
        while (stringTwo.hasMoreTokens()){
            time.add(stringTwo.nextToken());
        }
        if(Integer.valueOf(time.get(1)) + Integer.valueOf(time.get(3)) < minuteLimit){ // Расчет минут
            minute = Integer.valueOf(time.get(1)) + Integer.valueOf(time.get(3));
        }else{
            minute = (Integer.valueOf(time.get(1)) + Integer.valueOf(time.get(3))) % minuteLimit; // Перевод минут в часы
            hour = 1;
        }
        if(hour + Integer.valueOf(time.get(0)) + Integer.valueOf(time.get(2)) < hourLimit){ // Расчет часов
            hour = hour + Integer.valueOf(time.get(0)) + Integer.valueOf(time.get(2));
        }else{
            hour = (hour + Integer.valueOf(time.get(0)) + Integer.valueOf(time.get(2))) % 24; // Перевод часов (если больше суток)
        }
        System.out.println(minute);
        result = hour < 10 && minute < 10 ? "0" + hour + ":0" + minute :
                hour < 10 ? "0" + hour + ":" + minute :
                        minute < 10 ? hour + ":0" + minute : hour + ":" + minute;
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(result);
        fileOut.close();
    }
}
