package funny_sequence;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FunnySequence {
    public static void main(String[] args)throws IOException {
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        int number = sc.nextInt();
        Set<Integer> list = new HashSet<>(1);

        int outNumber = 1;
        for (int i = 2; i <= number; i++){
            if(list.contains(i)){
                outNumber += 3;
            }else {
                outNumber += 2;
            }
            list.add(outNumber);
        }

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(outNumber));
        out.close();
    }
}
