package srange_lottery;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class SrangeLottery {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        String number = sc.nextLine();

        char[] ch = number.toCharArray();
        BigInteger min = new BigInteger("0");

        for(int i = 1; i < ch.length; i++){
            if(i + 1 <= number.length()){
                String strOne = number.substring(0, i) + number.substring(i+1);
                if(!strOne.substring(0,1).equals("0")){
                    for(int j = 0; j < strOne.length(); j++){
                        String strTwo = (strOne.substring(0, j) + strOne.substring(j+1));
                        if(!strTwo.substring(0,1).equals("0")){
                            BigInteger str = new BigInteger(strTwo);
                            if(min.compareTo(str) < 0){
                                min = str;
                            }
                        }

                    }
                }
            }
        }

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(min));
        out.close();
    }
}
