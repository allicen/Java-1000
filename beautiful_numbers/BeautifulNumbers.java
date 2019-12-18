package beautiful_numbers;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BeautifulNumbers {
    private static boolean check(int number){
        String strNumber = String.valueOf(number);
        int sum = 0;
        char[] ch = strNumber.toCharArray();
        for(char elem : ch){
            int chNumber = elem - '0';
            sum += chNumber;
        }
        return sum % strNumber.length() == 0;
    }

    public static void main(String[] args) throws IOException {
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        int number = sc.nextInt();

        int count = 0;
        int numberChecked = 0;

        while (count != number){
            numberChecked++;
            if(check(numberChecked)){
                count++;
            }
        }

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(numberChecked));
        out.close();
    }
}
