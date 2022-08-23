package bus_tour;

import java.io.*;
import java.util.*;

public class BusTour {
    public static void main(String[] args) throws IOException {
        ArrayList<String> data= new ArrayList<>(); // Исходные данные построчно
        ArrayList<Integer> heightBridge = new ArrayList<>(); // Высота всех мостов
        int heightBus = 437; // Высота автобуса
        int numberBridge = 0; // Номер моста по умолчанию
        String result; // Результат решения задачи
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            data.add(sc.nextLine());
        }
        StringTokenizer st = new StringTokenizer(data.get(1), " ");
        while (st.hasMoreTokens()){
            heightBridge.add(Integer.valueOf(st.nextToken()));
        }
        for(int i = 0; i < heightBridge.size(); i++){
            if(heightBridge.get(i) <= heightBus){
                numberBridge = i + 1;
                break;
            }
        }
        result = (numberBridge == 0) ? "No crash" : "Crash " + numberBridge;
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(result);
        fileOut.close();
    }
}
