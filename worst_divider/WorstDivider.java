package worst_divider;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WorstDivider {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        String number = sc.nextLine();
        char[] chNumber = number.toCharArray();

        StringBuilder divider = new StringBuilder();
        divider.append("1");
        for(int i = chNumber.length-1; i > 0; i--){
            if(chNumber[i] == '0'){
                divider.append("0");
            }else break;
        }

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(divider));
        out.close();
    }
}
