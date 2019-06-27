package divider_two;

import java.io.*;
import java.util.*;

public class DividerTwo {
    public static void main(String[] args){
        Scanner i = new Scanner(System.in);
        PrintWriter o = new PrintWriter(System.out);
        int a = i.nextInt(), b = i.nextInt();
        while (a != b){
            if(a > b) a = a - b;
            else b = b - a;
        }
        o.print(a);
        o.flush();
    }
}
