package quadratic_equation;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class QuadraticEquation {
    public static void main(String[] args) throws IOException {
        double a = 0, b = 0, c = 0;

        Scanner sc = new Scanner(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        while (st.hasMoreTokens()){
            a = Double.valueOf(st.nextToken());
            b = Double.valueOf(st.nextToken());
            c = Double.valueOf(st.nextToken());
        }

        StringBuilder result = new StringBuilder();
        double d = Math.pow(b, 2) - 4*a*c;

        if(a == 0 && b == 0 && c == 0){
            result.append(-1);
        }else if(a == 0 && b == 0 || d < 0){
            result.append(0);
        }else if(a == 0){
            double x = (double)-c / b;
            result.append(1).append("\n");
            result.append(x);
        }else if(d == 0){
            double x = (double) -b/ (2*a);
            result.append(1).append("\n");
            result.append(x);
        }else {
            double x1 = (-b - Math.sqrt(d))/ (2*a);
            double x2 = (-b + Math.sqrt(d))/ (2*a);
            result.append(2).append("\n");
            result.append(x1).append("\n");
            result.append(x2);
        }

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(result));
        out.close();
    }
}
