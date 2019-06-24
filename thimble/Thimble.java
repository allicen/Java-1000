package thimble;

import java.io.*;
import java.util.*;

public class Thimble {
    private static ArrayList<Integer> letter = new ArrayList<>(Arrays.asList(1,2,3)); // Порядковый номер наперстков
    private static int result = 0; // Переменная с результатом
    private static ArrayList<String> actions = new ArrayList<>(); // Коллекция со всеми действиями

    private static void changeThimble(){ // Поменять наперстки местами
        for (String action : actions) {
            switch (action) {
                case "A": // Поменять левый и центральный
                    // Промежуточная переменная
                    int interim = letter.get(0);
                    letter.set(0, letter.get(1));
                    letter.set(1, interim);
                    break;
                case "B": // Поменять правый и центральный
                    interim = letter.get(1);
                    letter.set(1, letter.get(2));
                    letter.set(2, interim);
                    break;
                default: // Поменять левый и правый
                    interim = letter.get(0);
                    letter.set(0, letter.get(2));
                    letter.set(2, interim);
                    break;
            }
        }
    }

    private static void searchBall(){ // Ищем наперсток с шариком
        for(int i = 0; i < letter.size(); i++){
            if(letter.get(i) == 1){
                result = i+1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        String str = sc.nextLine();
        char[] ch = str.toCharArray();
        for(char aCh : ch){
            actions.add(String.valueOf(Character.valueOf(aCh)));
        }

        changeThimble();
        searchBall();

        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(String.valueOf(result));
        fileOut.close();
    }
}
