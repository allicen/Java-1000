package single_nod;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SingleNod {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> numbers = new ArrayList<>();
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        String str = sc.nextLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        while (st.hasMoreTokens()){
            numbers.add(Integer.valueOf(st.nextToken()));
        }

        int oneNumber = numbers.get(0);
        int twoNumber = numbers.get(1);

        while(oneNumber != twoNumber){
            if(oneNumber > twoNumber) oneNumber = oneNumber - twoNumber;
            else twoNumber = twoNumber - oneNumber;
        }

        int result = oneNumber;

        StringBuilder outNumber = new StringBuilder();
        for(int i = 0; i < result; i++){
            outNumber.append("1");
        }

        System.out.println(outNumber);
        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(outNumber));
        out.close();
    }
}
