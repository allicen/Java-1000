package decoding;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Decoding {
    private static Map<Integer, Character> cipher(){
        Map<Integer, Character> abc = new HashMap<>();
        int start = 1;
        for(char i = 'A'; i <= 'Z'; i++){
            abc.put(start, i);
            start++;
        }
        abc.put(start, ' ');
        return abc;
    }

    public static void main(String[] args) throws IOException {
        int numberCount = 10;
        int systemNumber = 27;
        StringBuilder result = new StringBuilder();
        Map<Integer, Character> abc = cipher();

        Scanner sc = new Scanner(new FileReader("input.txt"));
        String line = sc.nextLine();
        char[] lineArray = line.toCharArray();

        for(int i = 0; i < lineArray.length; i++) {
            int key = 0;
            if(String.valueOf(lineArray[i]).matches("[0-9]")){
                key += (lineArray[i] - '0');
            }else {
                for(int j : abc.keySet()){
                    if(lineArray[i] == abc.get(j)){
                        key = j+numberCount-1;
                    }
                }
            }
            key -= i+1;
            key = key % systemNumber;
            if(key == 0){
                result.append(" ");
            }else if(key > 0){
                result.append(abc.get(key));
            }else {
                result.append(abc.get(abc.size() + key));
            }
        }

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(result).toLowerCase());
        out.close();
    }
}
