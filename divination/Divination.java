package divination;

import java.io.*;
import java.util.*;

public class Divination {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> numbers = new ArrayList<>();
        int result = 0;
        int str;
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        str = Integer.valueOf(sc.nextLine());
        for(int i = 1000; i >= 1; i--){
            if(str%i == 0){
                numbers.add(str/i);
            }
        }
        for(Integer i : numbers){
            result += i;
        }
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(String.valueOf(result));
        fileOut.close();
    }
}
