package statistics;

import java.io.*;
import java.util.*;

public class Statistics {
    private static ArrayList<String> data = new ArrayList<>(); // Данные построчно
    private static ArrayList<Integer> day = new ArrayList<>(); // Все дни недели
    private static ArrayList<Integer> even = new ArrayList<>(); // Четные дни
    private static ArrayList<Integer> odd = new ArrayList<>(); // Нечетные дни

    private static void getData() throws IOException{ // Получаем данные
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            data.add(sc.nextLine());
        }
        StringTokenizer st = new StringTokenizer(data.get(1), " ");
        while (st.hasMoreTokens()){
            day.add(Integer.valueOf(st.nextToken()));
        }
    }

    private static void evenOdd(){ // Определяем четное или нечетное число, записываем в соответствующую коллекцию
        for(Integer line : day){
            if(line % 2 == 0){
                even.add(line);
            }else{
                odd.add(line);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        getData();
        evenOdd();

        // Преобразовываем данные для вывода в файл
        String four = (odd.size() <= even.size()) ? "YES" : "NO";
        String oddString = String.valueOf(odd).replaceAll(", ", " ").replaceAll("^\\[|]$", "");
        String evenString = String.valueOf(even).replaceAll(", ", " ").replaceAll("^\\[|]$", "");
        String result = oddString + "\n" + evenString + "\n" + four;
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(result);
        fileOut.close();
    }
}
