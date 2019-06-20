package floret;

import java.io.*;
import java.util.*;

public class Floret {
    public static void main(String[] args) throws IOException {
        ArrayDeque<String> queue = new ArrayDeque<>(Arrays.asList("G", "C", "V"));
        StringBuilder result = null;
        int str;
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        str = Integer.valueOf(sc.nextLine());
        for(int i = 0; i < str; i++){
            queue.addFirst(queue.getLast());
            queue.removeLast();
        }
        for(String flovers : queue){
            if(result != null){
                result.append(flovers);
            }else{
                result = new StringBuilder(flovers);
            }
        }
        FileWriter fileOut = new FileWriter("output.txt");
        assert result != null;
        fileOut.write(Objects.requireNonNull(result.toString()));
        fileOut.close();
    }
}
