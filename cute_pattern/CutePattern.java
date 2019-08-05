package cute_pattern;

import java.util.*;
import java.io.*;

public class CutePattern {
    private static ArrayDeque<String> data = new ArrayDeque<>();
    private static String[][] dataArr = new String[4][4];
    private static void getData() throws IOException{ // Получение данных
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            char[] ch = sc.nextLine().toCharArray();
            for(Character chLine : ch){
                data.add(String.valueOf(chLine));
            }
        }
         for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                dataArr[i][j] = data.getFirst();
                data.removeFirst();
            }
        }
    }

    public static void main(String[] argv) throws IOException{
        getData();
        String isCute = "Yes"; // Узор красивый по-умолчанию

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(i+1 < 4 && j+1 < 4 &&
                        dataArr[i][j].equals(dataArr[i][j+1]) && // Проверка на красивость
                        dataArr[i][j].equals(dataArr[i+1][j]) &&
                        dataArr[i][j+1].equals(dataArr[i+1][j+1]))
                {
                    isCute = "No";
                }
            }
        }

        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(isCute);
        pw.close();
    }
}

