package permutation;

import java.io.*;
import java.util.*;

public class Permutation {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> numbers = new ArrayList<>();
        String out;
        String str;
        FileReader file = new FileReader("input.txt"); // Считывание данных из файла
        Scanner sc = new Scanner(file);
        str = sc.nextLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        while(st.hasMoreTokens()){
            numbers.add(Integer.valueOf(st.nextToken()));
        }
        out = (numbers.get(0) + numbers.get(1) == numbers.get(2)) ? "YES" :
                (numbers.get(0) + numbers.get(2) == numbers.get(1)) ? "YES" :
                        (numbers.get(1) + numbers.get(2) == numbers.get(0)) ? "YES" : "NO";
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(out);
        fileOut.close();
    }
}
