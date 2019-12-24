package keyboard_two;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class KeyboardTwo {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        Map<Integer, Integer> keyboardInfo = new HashMap<>();
        Map<Integer, Integer> keyboardUse = new HashMap<>();

        int index = 0;
        while (sc.hasNextLine()){
            String line = sc.nextLine();
            if(index == 1){
                StringTokenizer st = new StringTokenizer(line, " ");
                int number = 1;
                while (st.hasMoreTokens()){
                    keyboardInfo.put(number, Integer.valueOf(st.nextToken()));
                    keyboardUse.put(number, 0);
                    number++;
                }
            }else if(index == 3){
                StringTokenizer st = new StringTokenizer(line, " ");
                while (st.hasMoreTokens()){
                    int number = Integer.valueOf(st.nextToken());
                    if(keyboardUse.containsKey(number)){
                        int val = keyboardUse.get(number);
                        val++;
                        keyboardUse.put(number, val);
                    }
                }
            }
            index++;
        }

        StringBuilder result = new StringBuilder();

        for(Integer key : keyboardUse.keySet()){
            if(keyboardUse.get(key) > keyboardInfo.get(key)){
                result.append("yes").append("\n");
            }else {
                result.append("no").append("\n");
            }
        }

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(result));
        out.close();
    }
}
