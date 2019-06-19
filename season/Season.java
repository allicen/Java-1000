package season;

import java.io.*;
import java.util.*;

public class Season {
    public static void main(String[] args) throws IOException {
        String season;
        String str;
        int month;
        FileReader file = new FileReader("input.txt"); // Считывание данных из файла
        Scanner sc = new Scanner(file);
        str = sc.nextLine();
        month = Integer.valueOf(str);
        season = (month == 1 || month == 2 || month == 12) ? "Winter" :
                (month == 3 || month == 4 || month == 5) ? "Spring" :
                        (month == 6 || month == 7 || month == 8) ? "Summer" :
                                (month == 9 || month == 10 || month == 11) ? "Autumn" : "Error";
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(season);
        fileOut.close();
    }
}
