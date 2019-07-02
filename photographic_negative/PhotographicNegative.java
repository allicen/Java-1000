package photographic_negative;

import java.util.*;
import java.io.*;

public class PhotographicNegative {
    private static ArrayList<String> data = new ArrayList<>(); // Исходные данные построчно
    private static ArrayList<String> imgOriginal = new ArrayList<>(); // Пиксели оригинального изображения
    private static ArrayList<String> imgNegative = new ArrayList<>(); // Пиксели негатива

    private static void getData() throws IOException{ // Получение данных из файла
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

    private static void dataProcessing(){ // Перебор данных
        for(int i = 0; i < data.size(); i++){
            int numberLine = Integer.valueOf(data.get(0));
            if(i != 0 && i != 1){ // Игнорируем цифры из файла
                if(i < numberLine + 2){ // Берем первые строки - изображение оригинала
                    char[] chOrigig = data.get(i).toCharArray();
                    for (char aChOrigig : chOrigig) {
                        imgOriginal.add(String.valueOf(aChOrigig));
                    }
                }else{
                    char[] chNegative = data.get(i).toCharArray();
                    for (char aChNegative : chNegative) {
                        String symbol = String.valueOf(aChNegative);
                        if (symbol.equals("B")) { // Заменить символы для негатиива
                            imgNegative.add("W");
                        } else {
                            imgNegative.add("B");
                        }
                    }
                }
            }
        }
    }


    public static void main(String[] argv) throws IOException{
        getData();
        dataProcessing();
        int wrong = 0; // Количество неверных пикселей
        for(int i = 0; i < imgOriginal.size(); i++){
            if(!imgOriginal.get(i).equals(imgNegative.get(i))){ // Если символы не совпадают
                wrong++; // Увеличить значение ошибки на 1
            }
        }
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(String.valueOf(wrong));
        pw.close();
    }
}
