package strawberry;

import java.util.*;
import java.io.*;

public class Strawberry {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> berry = new ArrayList<>();
        int numberBerry;
        String berryOut;
        String str;
        FileReader file = new FileReader("input.txt"); // Считывание данных из файла
        Scanner sc = new Scanner(file);
        str = sc.nextLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        while(st.hasMoreTokens()){
            berry.add(Integer.valueOf(st.nextToken()));
        }
        numberBerry = berry.get(0) + berry.get(1) - berry.get(2);
        berryOut = (numberBerry >= 0) ? String.valueOf(numberBerry) : "Impossible";
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(berryOut);
        fileOut.close();
    }
}
