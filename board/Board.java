package board;

import java.util.*;
import java.io.*;

public class Board {
    private static ArrayList<String> dataAll = new ArrayList<>();
    private static ArrayList<String> advColor = new ArrayList<>();
    private static ArrayList<String> descColor = new ArrayList<>();

    private static void getData() throws IOException{ // Получение данных
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            String str = sc.nextLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            while (st.hasMoreTokens()){
                dataAll.add(st.nextToken());
            }
        }
        int height = Integer.valueOf(dataAll.get(0)); // Количество строк
        for(int i = 0; i < dataAll.size(); i++){
            if(i != 0 && i != 1){ // Если не параметры табло
                if(i < 2+height){ // Разбираем строки с цветом рекламы
                    char[] ch = dataAll.get(i).toCharArray();
                    for(Character line : ch){
                        advColor.add(String.valueOf(line));
                    }
                }else{
                    descColor.add(dataAll.get(i)); // Данные о цветопередаче табло
                }
            }
        }
    }

    public static void main(String[] argv) throws IOException{
        getData();

        boolean isAdvOk = true; // Рекламу показать можно

        for(int i = 0; i < advColor.size(); i++){
            switch (advColor.get(i)) { // Проверка условий, когда рекламу показать нельзя
                case ("G") :
                    if(!descColor.get(i).equals("2") && !descColor.get(i).equals("3") && !descColor.get(i).equals("6") && !descColor.get(i).equals("7")){
                        isAdvOk = false;
                    }
                    break;
                case ("R") :
                    if(!descColor.get(i).equals("4") && !descColor.get(i).equals("5") && !descColor.get(i).equals("6") && !descColor.get(i).equals("7")){
                        isAdvOk = false;
                    }
                break;
                case ("B") :
                    if(!descColor.get(i).equals("1") && !descColor.get(i).equals("3") && !descColor.get(i).equals("5") && !descColor.get(i).equals("7")){
                        isAdvOk = false;
                    }
                break;
            }
        }

        String result = (!isAdvOk) ? "NO" : "YES";

        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(result);
        pw.close();
    }
}
