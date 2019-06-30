package sum;

import java.util.*;
import java.io.*;

public class Sum {
    private static int data;
    private static void getData() throws IOException{
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        data = sc.nextInt();
    }
    public static void main(String[] argv) throws IOException{
        getData();
        int sum = 0;
        if(data > 0){
            for(int i = 0; i <= data; i++){
                sum += i;
            }
        }else{
            for(int i = 1; i >= data; i--){
                sum += i;
            }
        }
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(String.valueOf(sum));
        pw.close();
    }
}
