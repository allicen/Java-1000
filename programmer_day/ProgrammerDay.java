package programmer_day;

import java.io.*;
import java.util.*;

public class ProgrammerDay {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(31,28,31,30,31,30,31,31,30,31,30,31)); // Количество дней в каждом месяце
        String result; // Результат
        String dayS, monS, yearS; // Переменные для сборки итоговой строки
        int day = 255, month, year; // ПЕременные для расчетов
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        year = Integer.valueOf(sc.nextLine());
        month = day / 31 + 1;
        if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)){ // Вычисление високосного года, замена количества дней в коллекции
            for(Integer i : numbers){
                if(i == 28){
                    numbers.set(1, 29);
                }
            }
        }
        for (Integer number : numbers) { // Вычисляем день в месяце
            if (day - number > 0) {
                day = day - number;
            }
        }
        dayS = (day + 1) < 10 ? "0" + (day+1) : String.valueOf(day+1); // Вычисление дня
        monS = "0" + month; // Вычисление месяца
        yearS = (year < 10) ? "000" + year : // Вычисление года
                (year < 100) ? "00" + year:
                        (year < 1000) ? "0" + year : String.valueOf(year);
        result = dayS + "/" + monS + "/" + yearS;
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(result);
        fileOut.close();
    }
}
