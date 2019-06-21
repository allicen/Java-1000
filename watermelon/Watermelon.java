package watermelon;

import java.io.*;
import java.util.*;

public class Watermelon {
    public static void main(String[] args) throws IOException {
        ArrayList<String> data= new ArrayList<>(); // Исходные данные построчно
        ArrayList<Integer> weight = new ArrayList<>(); // Вес всех арбузов
        String result; // Результат решения задачи
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            data.add(sc.nextLine());
        }
        StringTokenizer st = new StringTokenizer(data.get(1), " ");
        while (st.hasMoreTokens()){
            weight.add(Integer.valueOf(st.nextToken()));
        }
        Collections.sort(weight); // Сортируем коллекцию
        result = weight.get(0) + " " + weight.get(weight.size() - 1); // Берем первый и последний элемент коллекции
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(result);
        fileOut.close();
    }
}
