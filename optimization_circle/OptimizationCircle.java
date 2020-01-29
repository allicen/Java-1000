package optimization_circle;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class OptimizationCircle {
    public static void main(String[] args) throws IOException {
        double a = 0, b = 0, r = 0;
        double max, x, y;

        Scanner sc = new Scanner(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        while (st.hasMoreTokens()){
            a = Double.valueOf(st.nextToken());
            b = Double.valueOf(st.nextToken());
            r = Double.valueOf(st.nextToken());
        }

        max = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2)) * r;
        double countVar = max / (Math.pow(a, 2) + Math.pow(b, 2));
        x = a * countVar;
        y = b * countVar;

        String xRes = String.format("%.7f", x).replaceAll(",", ".");
        String yRes = String.format("%.7f", y).replaceAll(",", ".");

        String result = max + "\n" + xRes + " " + yRes;

        FileWriter out = new FileWriter("output.txt");
        out.write(result);
        out.close();
    }
}
