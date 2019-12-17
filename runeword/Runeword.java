package runeword;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Runeword {
    public static void main(String[] args) throws IOException {
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        String word = sc.nextLine();

        boolean rune = true;

        char[] words = word.toCharArray();
        int serialNumber = 0;
        if(words.length > 1){
            for(int i = 0; i < words.length; i++){
                String symbol = String.valueOf(words[i]);
                if(i == 0){
                    if(!symbol.equals(symbol.toUpperCase()) || String.valueOf(words[words.length-1]).equals(String.valueOf(words[words.length-1]).toUpperCase())){
                        rune = false;
                        break;
                    }else {
                        serialNumber++;
                    }
                } else {
                    if(symbol.equals(symbol.toUpperCase())){
                        if (serialNumber == 1){
                            rune = false;
                            break;
                        }else {
                            serialNumber = 1;
                        }
                    }else {
                        if(serialNumber < 4){
                            serialNumber++;
                        }else {
                            rune = false;
                            break;
                        }
                    }
                }
            }
        }else {
            rune = false;
        }

        String result = rune ? "Yes" : "No";

        FileWriter out = new FileWriter("output.txt");
        out.write(result);
        out.close();
    }
}
