package subarray_array;

import java.io.*;
import java.util.*;

public class SubarrayArray {
    private static ArrayList<String> data = new ArrayList<>(); // Исходные данные
    private static ArrayList<String> arrMain = new ArrayList<>(); // Главный массив, из которого получаем подмассивы
    private static ArrayList<String> arrSub = new ArrayList<>(); // Начальные и конечные элементы подмассивов
    private static ArrayList<String> arrSubOut = new ArrayList<>(); // Коллекция со всеми подмассивами
    private static ArrayList<String> arrSubOutBuild = new ArrayList<>(); // Коллекция для сборки подмассива

    private static void getData() throws IOException { // Получение данных из файла и предварительная обработка
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            data.add(sc.nextLine());
        }
        StringTokenizer st = new StringTokenizer(data.get(1), " ");
        while (st.hasMoreTokens()){
            arrMain.add(st.nextToken());
        }
        for(int i = 3; i < data.size(); i++){
            StringTokenizer add = new StringTokenizer(data.get(i), " ");
            while (add.hasMoreTokens()){
                arrSub.add(add.nextToken());
            }
        }
    }

    private static void buildSubArr(){ // Формирование подмассивов на основе данных из файла
        for(int j = 0; j < arrSub.size(); j++){
            if(j+1 < arrSub.size()){
                String start = arrSub.get(j); // Начало подмассива
                String finish = arrSub.get(j+1); // Конец подмассива
                if(!start.equals(finish)){ // Если начало и конец подмассива не равны
                    for (int i = 0; i < arrMain.size(); i++){
                        if(arrMain.get(i).equals(start) && arrSubOutBuild.isEmpty()){ // Если элемент совпадает с началом и при этом массив не пустой
                            while (!arrMain.get(i).equals(finish)){
                                if(i == 0){ // Добавляем 1 символ подмассива
                                    arrSubOutBuild.add(arrMain.get(i));
                                }else if(!arrMain.get(i).equals(arrMain.get(i-1))){ // Проверяем остальные символы массива на одинаковость
                                    arrSubOutBuild.add(arrMain.get(i));
                                }
                                i++;
                                if(i == arrMain.size()){ // Если индекс массива больше длины массива
                                    break;
                                }
                            }
                            arrSubOutBuild.add(finish);
                        }
                    }
                    arrSubOut.add(String.valueOf(arrSubOutBuild).replaceAll(",", "").replaceAll("^\\[|]$", "")); // Заменяем запятые на пробелы, убираем лишнее
                    arrSubOutBuild.clear();
                }else{
                    arrSubOut.add(start);
                }
            }
            j++;
        }
    }

    private static void removeSameElements(){ // Удаление одинаковых подмассивов
        for(int i = 0; i < arrSubOut.size(); i++){ // Удаление одинаковых подмассивов при выводе конечного ответа
            String compare = arrSubOut.get(i);
            int j;
            for(j = i + 1; j < arrSubOut.size(); j++){
                if(compare.equals(arrSubOut.get(j))){
                    arrSubOut.remove(j);
                    j--;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        getData();
        buildSubArr();
        removeSameElements();
        String result = String.valueOf(arrSubOut).replaceAll(", ", "\n").replaceAll("^\\[|]$", ""); // Формирование строки с конечным результатом
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(result); // Выавод результата
        fileOut.close();
    }
}
