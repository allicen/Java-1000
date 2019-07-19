package elevator;

import java.util.*;
import java.io.*;

public class Elevator {
    private static ArrayList<Integer> level = new ArrayList<>();
    private static int countLevel;

    private static void getData() throws IOException{ // Получение данных
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        String str = sc.nextLine();
        char[] ch = str.toCharArray();
        for (char aCh : ch) {
            level.add(aCh - '0');
        }
    }

    private static void countLevel(){
        int i = 0;
        int iMax = 0;
        int iMin = 0;
        for(Integer numberButton : level){
            if(numberButton == 1){
                i++;
            }else {
                i--;
            }
            if(iMin > i){ // Находим количество этажей внизу от этажа, с которого вызвали лифт
                iMin = i;
            }
            if(iMax < i){ // Находим количество этажей сверху от этажа, с которого вызвали лифт
                iMax = i;
            }
        }
        countLevel = Math.abs(iMax) + Math.abs(iMin) + 1; // Прибавляем этажи сверху, снизу и этаж, с которого вызван лифт
    }

    public static void main(String[] argv) throws IOException{
        getData();
        countLevel();
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(String.valueOf(countLevel));
        pw.close();
    }

}
