package puzzle_queens;

import java.io.*;
import java.util.*;

public class PuzzleQueens {
    public static void main(String[] args) throws IOException {
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        int countQueen = Integer.valueOf(sc.nextLine());
        int result = 0;
        for(int i = countQueen - 2; i > 0 ; i--){ // Перебираем варианты для одной стороны поля
            result += i;
        }
        result = result * 2; // Добавляем вторую сторону
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(String.valueOf(result));
        fileOut.close();
    }
}
