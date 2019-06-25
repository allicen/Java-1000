package zero;

import java.io.*;
import java.util.*;

public class Zero {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> zeroCount = new ArrayList<>();
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        String str = sc.nextLine();
        char[] symbols = str.toCharArray();
        int count = 0;
        int result = 0;
        for (char symbol : symbols) {
            if (symbol - '0' == 0) {
                count++;
            } else {
                if (count != 0) {
                    zeroCount.add(count);
                }
                count = 0;
            }
        }
        if(count != 0){
            zeroCount.add(count);
        }
        if(!zeroCount.isEmpty()){
            zeroCount.sort(Collections.reverseOrder());
            result = zeroCount.get(0);
        }
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(String.valueOf(result));
        fileOut.close();
    }
}
