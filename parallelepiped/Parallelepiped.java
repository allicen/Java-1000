package parallelepiped;

import java.io.*;
import java.util.*;

public class Parallelepiped {
    public static void main(String[] args) throws IOException {
        ArrayList<Long> side = new ArrayList<>();
        String squareSide;
        long square;
        long volume;
        String str;
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        str = sc.nextLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        while (st.hasMoreTokens()){
            side.add(Long.valueOf(st.nextToken()));
        }
        volume = side.get(0) * side.get(1) * side.get(2); // Расчет объема
        square = (side.get(0) * side.get(1) + side.get(0) * side.get(2) + side.get(1) * side.get(2)) * 2; // Расчет площади поверхности фигуры
        squareSide = square + " " + volume;
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(squareSide);
        fileOut.close();
    }
}
