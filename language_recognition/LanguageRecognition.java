package language_recognition;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LanguageRecognition {
    public static void main(String[] args) throws IOException {
        ArrayList<String> data = new ArrayList<>();

        Scanner sc = new Scanner(new FileReader("input.txt"));
        int lineNumber = 0;
        while (sc.hasNextLine()){
            String line = sc.nextLine();
            if(lineNumber != 0){
                data.add(line);
            }
            lineNumber++;
        }

        StringBuilder result = new StringBuilder();
        for(String line : data){
            int zero = 0, one = 0, two = 0, check = 0, other = 0;
            char[] lineArray = line.toCharArray();
            for(char i : lineArray){
                int number = i - '0';
                if(number == 0 && check == 0){
                    zero += 1;
                }else if(number == 1 && check == 0){
                    check = 1;
                    one += 1;
                }else if(number == 1 && check == 1){
                    one += 1;
                }else if(number == 2 && check == 1){
                    check = 2;
                    two += 1;
                }else if(number == 2 && check == 2){
                    two += 1;
                }else {
                    other += 1;
                }
            }
            if(other == 0 && zero == one && one == two){
                result.append("YES").append("\n");
            }else {
                result.append("NO").append("\n");
            }
        }

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(result).trim());
        out.close();
    }
}
