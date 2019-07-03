package rally;

import java.util.*;
import java.io.*;

public class Rrally {
    private static ArrayList<String> data = new ArrayList<>(); // Коллекция с исходными данными
    private static ArrayList<String> allPoint = new ArrayList<>(); // Коллекция с суммой очков каждого участника
    private static String result; // Ответ на задачу

    private static void getData() throws IOException{ // Получить данные
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            String str = sc.nextLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            while (st.hasMoreTokens()){
                data.add(st.nextToken());
            }
        }
    }

    private static void allPoints(){ // Сложить все очки каждого участника
        int j = 0;
        for(int i = 0; i < data.size(); i++){
            if(i != 0 && i != 1){
                if(data.get(i).matches("^-?\\d+$")){
                    j += Integer.valueOf(data.get(i));
                }else{
                    allPoint.add(String.valueOf(j));
                    j = 0;
                    allPoint.add(data.get(i));
                }
            }
        }
        allPoint.add(String.valueOf(j));
    }

    private static void winner(){ // Вычисление победителя с наименьшим кол-вом очков
        int minTime = 0;
        int minTimeIndex = 0;
        for(int i = 0; i < allPoint.size(); i++){
            if(i != 0){
                if(i % 2 == 0 && i + 2 < allPoint.size()){
                    if(i == 2){
                        minTime = Integer.valueOf(allPoint.get(i));
                        minTimeIndex = i;
                    }
                    if(Integer.valueOf(allPoint.get(i + 2)) < minTime){
                        minTime = Integer.valueOf(allPoint.get(i + 2));
                        minTimeIndex = i;
                    }
                }
            }
        }
        result = allPoint.get(minTimeIndex+1);
    }
    public static void main(String[] argv) throws IOException{
        getData();
        allPoints();
        winner();
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(result);
        pw.close();
    }
}
