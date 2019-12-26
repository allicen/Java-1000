package creator;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Creator {
    public static void main(String[] args) throws IOException {
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> nameMistakes = new ArrayList<>();
        Map<String, Integer> mistakeCount = new HashMap<>();
        List<Character> abc = new ArrayList<>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'));
        Scanner sc = new Scanner(new FileReader("input.txt"));

        while (sc.hasNextLine()){
            int index = Integer.valueOf(sc.nextLine());
            while (index>0){
                String line = sc.nextLine();
                    names.add(line);
                    mistakeCount.put(line, 0);
                index--;
            }
            index = Integer.valueOf(sc.nextLine());
            while (index>0){
                nameMistakes.add(sc.nextLine());
                index--;
            }
        }

        for(String name : nameMistakes){
            if(!names.contains(name)){
                char[] chName = name.toCharArray();
                for(int i = 0; i < chName.length; i++){
                    for (Character anAbc : abc) {
                        String testName = name.substring(0, i) + String.valueOf(anAbc) + name.substring(i + 1);
                        if (names.contains(testName)) {
                            int count = mistakeCount.get(testName) + 1;
                            mistakeCount.put(testName, count);
                            break;
                        }
                    }
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (String name : names) {
            result.append(mistakeCount.get(name)).append(" ");
        }

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(result));
        out.close();
    }
}
