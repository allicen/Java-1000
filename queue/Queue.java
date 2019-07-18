package queue;

import java.util.*;
import java.io.*;

public class Queue {
    private static int peopleInQueue;
    private static String result;

    private static void getData() throws IOException{ // Получение данных
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        peopleInQueue = sc.nextInt();
    }

    private static void timeInQueue(){ // Расчет времени в очереди
        int queue;
        int hour, minute, allminute;
        boolean sucsess = true;
        if(peopleInQueue % 2 == 0){ // 1 очередь
            queue = peopleInQueue / 2 - 1;
            allminute = queue * 10;
            hour = allminute / 60;
            minute = allminute - hour * 60 + 5;
            if(minute >= 60){
                hour = hour + 1;
                minute = minute + 5 - 60;
            }
            if(hour > 11 || (hour == 11 && minute > 55)){
                sucsess = false;
            }
        }else{ // 2 очередь
            queue = peopleInQueue / 2;
            allminute = queue * 10;
            hour = allminute / 60;
            minute = allminute - hour * 60;
            if(minute >= 60){
                hour = hour + 1;
                minute = minute - 60;
            }
            if((hour == 12 && minute !=0) || hour > 12){
                sucsess = false;
            }
        }
        result = (!sucsess) ? "NO" : hour + " " + minute; // Ответ на задачу
    }

    public static void main(String[] argv) throws IOException{
        getData();
        timeInQueue();
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(result);
        pw.close();
    }
}
