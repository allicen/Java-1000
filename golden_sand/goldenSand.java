package golden_sand;

import java.io.*;
import java.util.*;

public class goldenSand {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> price = new ArrayList<>();
        ArrayList<Integer> container = new ArrayList<>();
        int profit = 0;
        String str;
        FileReader file = new FileReader("input.txt"); // Считывание данных из файла
        Scanner sc = new Scanner(file);
        str = sc.nextLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        while (st.hasMoreTokens()){
            if(price.size() < 3){
                price.add(Integer.valueOf(st.nextToken())); // Записывавем цены
            }else{
                container.add(Integer.valueOf(st.nextToken())); // Записываем емкость
            }
        }
        Collections.sort(price); // Сортируем цены
        Collections.sort(container); // Сортируем емкости
        for(int i = 0; i<price.size(); i++){
            profit = profit + price.get(i) * container.get(i); // Перемножаем минимальные цены с минимальными емкостями
        }
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(String.valueOf(profit));
        fileOut.close();
    }

}
