package crane;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Crane {
    public static void main(String[] args) throws IOException {
        String result;
        int countBoys;
        int countGirl;
        int in;
        String str;
        FileReader file = new FileReader("input.txt"); // Считывание данных из файла
        Scanner sc = new Scanner(file);
        str = sc.nextLine();
        in = Integer.valueOf(str);
        countBoys = in / 6;
        countGirl = in - countBoys * 2;
        result = countBoys + " " + countGirl + " " + countBoys;
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(result);
        fileOut.close();
    }
}
