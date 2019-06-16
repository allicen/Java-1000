package basketball;

import java.util.*;
import java.io.*;

public class Basketball {
    public static void main(String[] args) throws IOException {
        ArrayList<String> line = new ArrayList<>();
        ArrayList<Integer> score = new ArrayList<>();
        int a = 0, b = 0;
        String winner;
        String str;
        FileReader file = new FileReader("input.txt"); // Считывание данных из файла
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            str = sc.nextLine();
            line.add(str);
        }
        for(String i : line){ // Записать все очки в одну коллекцию
            StringTokenizer st = new StringTokenizer(i, " ");
            while(st.hasMoreTokens()){
                score.add(Integer.valueOf(st.nextToken()));
            }
        }
        for(int j = 0; j < score.size(); j++){ // Подсчет количества очков для каждой из команд
            if((j+1)%2 == 1){
                a += score.get(j);
            }else{
                b += score.get(j);
            }
        }
        winner = (a > b) ? "1" : // Какая команда победила
                (b > a) ? "2" : "DRAW";
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(winner);
        fileOut.close();
    }
}
