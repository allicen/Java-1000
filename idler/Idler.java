package idler;

import java.util.*;
import java.io.*;

public class Idler {
    private static ArrayList<Integer> data = new ArrayList<>();
    private static ArrayList<Integer> dateStart = new ArrayList<>();
    private static ArrayList<Integer> dateFinish = new ArrayList<>();
    private static void getData() throws IOException{ // Получение данных
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            String string = sc.nextLine();
            StringTokenizer st = new StringTokenizer(string, " ");
            while (st.hasMoreTokens()){
                data.add(Integer.valueOf(st.nextToken()));
            }
        }
        data.remove(0);
    }

    public static void main(String[] argv) throws IOException{
        getData();

        for(int i = 0; i < data.size(); i++){
            if(i % 2 == 0){ // Первая дата
                dateStart.add(data.get(i));
            }else{ // Последняя дата
                dateFinish.add(data.get(i));
            }
        }

        dateStart.sort(Collections.reverseOrder()); // Сортируем первую дату в обратном порядке
        Collections.sort(dateFinish); // Сортируем последнюю дату по возрастанию

        String result = (dateStart.get(0) <= dateFinish.get(0)) ? "YES" : "NO";

        System.out.println(result);

        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(result);
        pw.close();
    }
}
