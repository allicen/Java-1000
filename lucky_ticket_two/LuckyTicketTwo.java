package lucky_ticket_two;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LuckyTicketTwo{
    private static int summ(String str){
        char[] ch = str.toCharArray();
        int number = 0;

        for (char aCh : ch) {
            int symbol = aCh - '0';
            number += symbol;
        }


        while (number > 9){
            int sum = 0;
            while (number > 0) {
                sum += number % 10;
                number = (int) Math.floor(number/10);
            }
            number = sum;
        }
        return number;
    }


    public static void main(String[] args) throws IOException {
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        String data = sc.nextLine();

        int index = 1;
        boolean isHappy = false;

        char[] ch = data.toCharArray();
        if(ch.length > 1){
            for (char aCh : ch) {
                StringBuilder leftString = new StringBuilder();
                StringBuilder rightString = new StringBuilder();
                for (int a = 0; a < index; a++) {
                    leftString.append(String.valueOf(ch[a]));
                }

                int left = summ(String.valueOf(leftString));

                for (int b = ch.length - 1; b >= index; b--) {
                    rightString.append(String.valueOf(ch[b]));
                }

                int rigth = summ(String.valueOf(rightString));

                if (left == rigth) {
                    isHappy = true;
                    break;
                }
                index++;
            }
        }

        String result = isHappy ? "YES" : "NO";

        FileWriter out = new FileWriter("output.txt");
        out.write(result);
        out.close();
    }
}
