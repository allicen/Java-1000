package turn;

import java.io.*;
import java.util.*;

public class Turn {
    public static void main(String[] args) throws IOException {
        ArrayList <String> lines = new ArrayList<>();
        ArrayList<String> numbers = new ArrayList<>();
        StringBuilder out = new StringBuilder();
        String str;
        FileReader file = new FileReader("input.txt"); // Считывание данных из файла
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            str = sc.nextLine();
            lines.add(str);
        }
        StringTokenizer st = new StringTokenizer(lines.get(1), " ");
        while(st.hasMoreTokens()){
            numbers.add(st.nextToken());
        }
        Collections.reverse(numbers);
        for(String i : numbers){
            out.append(i).append(" "); // Записать в переменную i и пробел
        }
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(out.toString());
        fileOut.close();
    }
}
