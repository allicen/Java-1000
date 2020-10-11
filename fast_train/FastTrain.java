package fast_train;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FastTrain {

    /**
     * @param time Время
     * @return Разница во времени
     * */
    private static int timeTransformInMinute(String[] time) {
        return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
    }


    public static void main (String[] args) throws IOException {

        int maxTime = 24*60; // Больше этого времени поезд в пути быть не может
        int time = maxTime;
        int distance = 650;
        String trainName = " ";
        int speed = 0;

        Scanner sc = new Scanner(new FileReader("input.txt"));
        int index = 0;
        while (sc.hasNextLine()) {
            index++;
            String line = sc.nextLine();

            if (index == 1) { // игнорировтаь первую строку
                continue;
            }

            String name = line.substring(line.indexOf("\""), line.lastIndexOf("\"")+1);

            line = line.replaceAll(name, ""). replaceAll("\"", "").trim();
            String[] lineArguments = line.split(" ");

            if (lineArguments.length > 1) {
                String[] timeStart = lineArguments[0].split(":");
                String[] timeFinish = lineArguments[1].split(":");

                int timeInWay = (timeTransformInMinute(timeFinish) - timeTransformInMinute(timeStart));

                if (timeInWay < 0) { // поезд приходит на следующие сутки
                    timeInWay = maxTime + timeInWay;
                }

                if (timeInWay == 0 && time == maxTime) { // поезд едет ровно сутки
                    trainName = name;
                    speed = (Math.round((float) distance / ((float) time / 60)));
                } else if (timeInWay != 0 && timeInWay <= time) {
                    time = timeInWay;
                    trainName = name;
                    speed = Math.round((float) distance / ((float) timeInWay / 60));
                }
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        out.println("The fastest train is " + trainName + ".");
        out.println("Its speed is " + speed + " km/h, approximately.");
        out.flush();
    }
}
