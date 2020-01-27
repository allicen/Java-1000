package same_numbers;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class SameNumbers {
    public static void main(String[] args) throws IOException {
        Set<Character> a = new HashSet<>();
        Set<Character> b = new HashSet<>();
        Set<Character> c = new HashSet<>();

        Scanner sc = new Scanner(new FileReader("input.txt"));
        int lineNumber = 0;
        while (sc.hasNextLine()){
            StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
            while (st.hasMoreTokens()){
                char[] ch = st.nextToken().toCharArray();
                for (char symbol : ch){
                    if (lineNumber == 0){
                        if(a.size() <= 10){
                            a.add(symbol);
                        }else break;
                    }else if(lineNumber == 1){
                        if(b.size() <= 10){
                            b.add(symbol);
                        }else break;
                    }else if(lineNumber == 2){
                        if(c.size() <= 10){
                            c.add(symbol);
                        }else break;
                    }
                }
                lineNumber++;
            }
        }

        StringBuilder result = new StringBuilder();
        ArrayList<String> same = new ArrayList<>();

        if(a.size() == b.size() && b.size() == c.size()){
            for(char symbol : a){
                if(b.contains(symbol) && c.contains(symbol)){
                    same.add(String.valueOf(symbol));
                }
            }
        }else {
            int maxSize = a.size() >= b.size() && a.size() >= c.size() ? a.size():
                    b.size() >= a.size() && b.size() >= c.size() ? b.size() : c.size();

            Set<Character> maxSet = a.size() == maxSize ? a :
                    b.size() == maxSize ? b : c;

            for(char symbol : maxSet){
                if(a.contains(symbol) && b.contains(symbol) && c.contains(symbol)){
                    same.add(String.valueOf(symbol));
                }
            }
        }

        result.append(same.size()).append("\n");
        for(String symbol : same){
            result.append(symbol).append(" ");
        }

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(result));
        out.close();
    }
}
