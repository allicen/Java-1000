package percents;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Percents {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        sc.nextLine();

        ArrayList<Integer> proportions = new ArrayList<>();
        ArrayList<String> importance = new ArrayList<>();
        int count = 0;

        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split(" ");
            importance.add(line[0]);
            int percent = Integer.parseInt(line[1]);
            proportions.add(percent);
            count += percent;
        }

        ArrayList<Map<Integer, Integer>> percents = new ArrayList<>();
        double percentAverage = 100/(double)count;
        int percentCount = 0;

        int priorityHighCount = 0; // дробный важный компонент
        int priorityLowCount = 0; // дробный неважный компонент

        for (int i = 0; i < proportions.size(); i++) {
            double percentFloat = proportions.get(i) * percentAverage;
            int percent = (int) Math.floor(percentFloat);

            int priority = percentFloat != percent && importance.get(i).equals("+") ? 2 :
                    percentFloat != percent && importance.get(i).equals("-") ? 1 : 0;

            if (priority == 2) {
                priorityHighCount++;
            } else if (priority == 1) {
                priorityLowCount++;
            }

            Map<Integer, Integer> percentInfo = new HashMap<>();
            percentInfo.put(percent, priority);
            percents.add(percentInfo);

            percentCount += percent;
        }

        int percentageDifference = 100 - percentCount;
        int priorityTwo = percentageDifference - priorityHighCount; // количество процентов с приоритетом 2
        int priorityOne = 0; // кол-во процентов с приоритетом 1
        int priorityZero = 0; // количество процентов с приоритетом 0

        if (priorityTwo <= 0) {
            priorityTwo = percentageDifference;
        } else {
            priorityTwo = priorityHighCount;
            priorityOne = percentageDifference - priorityLowCount;

            if (priorityOne <= 0) {
                priorityOne = priorityLowCount;
            } else {
                priorityZero = percentageDifference - (priorityHighCount + priorityLowCount);
            }
        }

        for (int i = 0; i < percents.size(); i++) {
            if (percentageDifference == 0) {
                break;
            }
            Map<Integer, Integer> mapTmp = percents.get(i);
            for (int key : mapTmp.keySet()) {
                int priority = mapTmp.get(key);

                if (priority == 2 && priorityTwo > 0) {
                    mapTmp.put(key+1, priority);
                    mapTmp.remove(key);
                    priorityTwo--;
                    percentageDifference--;
                    percents.set(i, mapTmp);
                } else if (priority == 1 && priorityOne > 0) {
                    mapTmp.put(key+1, priority);
                    mapTmp.remove(key);
                    priorityOne--;
                    percentageDifference--;
                    percents.set(i, mapTmp);
                } else if (priority == 0 && priorityZero > 0) {
                    mapTmp.put(key+1, priority);
                    mapTmp.remove(key);
                    priorityZero--;
                    percentageDifference--;
                    percents.set(i, mapTmp);
                }
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        for (Map<Integer, Integer> percent : percents) {
            for (int key : percent.keySet()) {
                out.println(key);
            }
        }

        out.flush();
    }
}
