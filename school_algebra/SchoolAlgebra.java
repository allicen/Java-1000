package school_algebra;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SchoolAlgebra {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        int a = 0, b = 0, c = 0;
        while (st.hasMoreTokens()){
            a = Integer.valueOf(st.nextToken());
            b = Integer.valueOf(st.nextToken());
            c = Integer.valueOf(st.nextToken());
        }

        StringBuilder result = new StringBuilder();
        if(a != 0){
            result.append(a);
        }
        if(b != 0){
            if(b == 1){
                if(result.length() > 0){
                    result.append("+");
                }
                result.append("x");
            }else if(b == -1){
                result.append("-").append("x");
            }else {
                if(b > 0){
                    if(result.length() > 0){
                        result.append("+");
                    }
                    result.append(b).append("x");
                }else {
                    result.append(b).append("x");
                }
            }
        }
        if(c != 0){
            if(c == 1){
                if(result.length() > 0){
                    result.append("+");
                }
                result.append("y");
            }else if(c == -1){
                result.append("-").append("y");
            }else {
                if(c > 0){
                    if(result.length() > 0){
                        result.append("+");
                    }
                    result.append(c).append("y");
                }else {
                    result.append(c).append("y");
                }
            }
        }

        if(result.length() == 0){
            result.append(0);
        }

        System.out.println(result);

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(result));
        out.close();
    }
}
