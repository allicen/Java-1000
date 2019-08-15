package stairs;

import java.util.*;
import java.io.*;

public class Stairs {
    private static int cubeCount;

    private static void getData() throws IOException{ // Получение данных
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        cubeCount = sc.nextInt();
    }

    public static void main(String[] argv) throws IOException{
        getData();

        int result = (int) (Math.abs(1 - Math.sqrt(1 + 4 * (2 * cubeCount))) / 2);

        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(String.valueOf(result));
        pw.close();
    }
}
