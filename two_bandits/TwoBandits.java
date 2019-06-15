package two_bandits;

import java.io.*;
import java.util.*;

public class TwoBandits {
    public static void main(String[] args) throws IOException {
        int count = 0;
        int a, b;
        ArrayList<Integer> numberIn = new ArrayList<>();
        String str;
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        str = sc.nextLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        while(st.hasMoreTokens()){
            numberIn.add(Integer.valueOf(st.nextToken()));
        }
        for (Integer aNumberIn : numberIn) { // Посчитать колво банок с простреленной дважды банкой (+1)
            count += aNumberIn;
        }
        count--;
        a = count - numberIn.get(0);
        b = count - numberIn.get(1);

        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(a + " "  + b);
        fileOut.close();
    }
}
