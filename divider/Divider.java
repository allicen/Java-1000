package divider;

import java.util.*;
import java.io.*;

public class Divider{
    public static void main(String[] argv) throws IOException{
        Scanner sc = new Scanner(new File("input.txt"));
        int a= sc.nextInt(), b= sc.nextInt();
        while(a != b){
            if(a > b) a = a - b;
            else b = b - a;
        }
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(a);
        pw.close();
    }
}
