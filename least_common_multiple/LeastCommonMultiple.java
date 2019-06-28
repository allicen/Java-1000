package least_common_multiple;

import java.util.*;
import java.io.*;

public class LeastCommonMultiple {
    public static void main(String[] args){
        Scanner i = new Scanner(System.in);
        int a = i.nextInt(), b = i.nextInt();
        int c = a, d = b;
        while (a != b){ // Используется алгоритм Евклида
            if(a > b) a = a - b;
            else b = b - a;
        }
        int result = c / a * d;
        PrintWriter o = new PrintWriter(System.out);
        o.print(result);
        o.flush();
    }
}
