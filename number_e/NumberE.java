package number_e;

import java.math.BigDecimal;
import java.util.*;
import java.io.*;

public class NumberE {
    private static int symbolCount;
    private static void getData() throws IOException{ // Получение данных
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        symbolCount = sc.nextInt();
    }

    public static void main(String[] argv) throws IOException{
        getData();
        BigDecimal e = new BigDecimal("2.7182818284590452353602875"); // Число е
        String result = String.format("%(."+symbolCount+"f", e).replaceAll(",", "."); // Округление с заданной точностью
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(result);
        pw.close();
    }
}
