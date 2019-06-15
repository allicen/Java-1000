package salary;

import java.util.*;
import java.io.*;

public class Salary {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> list = new ArrayList<>(); // Записываем все зп в коллекцию
        int difference; // Максимальная разница в зп
        int count; // Количество зарплат
        String str;
        FileReader file = new FileReader("input.txt"); // Считывание данных из файла
        Scanner sc = new Scanner(file);
        str = sc.nextLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        while (st.hasMoreTokens()){
            list.add(Integer.valueOf(st.nextToken()));
        }
        Collections.sort(list); // Сортируем коллекцию
        count = list.size(); // Получаем размер коллекции
        difference = list.get(count-1) - list.get(0); // Из максимальной зп вычитаем минимальную

        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(String.valueOf(difference));
        fileOut.close();
    }
}
