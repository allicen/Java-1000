package picking_blueberries;

import java.util.*;
import java.io.*;

public class PickingBlueberries {
    private static ArrayList<Integer> berryCount = new ArrayList<>();
    private static ArrayList<Integer> berrySum = new ArrayList<>();
    private static void getData() throws IOException{
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            String str = sc.nextLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            while (st.hasMoreTokens()){
                berryCount.add(Integer.valueOf(st.nextToken()));
            }
        }
    }
    public static void main(String[] argv) throws IOException{
        getData();
        for(int i = 0; i < berryCount.size(); i++){
            if(i == 0){ // Убираем количество кустов
                berryCount.remove(0);
            }
        }
        berryCount.add(berryCount.get(0)); // Добавляем кол-во ягод на 1м кусте в конец коллекции
        berryCount.add(berryCount.get(1)); // Добавляем кол-во ягод на 2м кусте в конец коллекции
        int result = 0;
        for(int i = 0; i < berryCount.size(); i++){
            if(i+1 < berryCount.size() && i+2 < berryCount.size()){
                result = berryCount.get(i) + berryCount.get(i+1) + berryCount.get(i+2); // Считаем количество ягод на 3х соседних кустах
            }
            berrySum.add(result);
            result = 0;
        }
        berrySum.sort(Collections.reverseOrder()); // Сортируем последовательность с количеством ягод на 3 кустах в обратном порядке
        result = berrySum.get(0);
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(String.valueOf(result));
        pw.close();
    }
}
