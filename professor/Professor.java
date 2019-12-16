package professor;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Professor {
    private static int getWordsCount(String lecture, int m){
        Map<String, Integer> wordSpace = new HashMap<>();
        char[] words = lecture.toCharArray();
        StringBuffer  temp = new StringBuffer();
        for(int i = 0; i < words.length; i++){
            if(i < m){
                temp.append(String.valueOf(words[i]));
            }else {
                if(temp.length() == m){
                    wordSpace.put(String.valueOf(temp), 0);
                    temp.delete(0, 1);
                    temp.append(String.valueOf(words[i]));
                }
            }
            if(temp.length() == m){
                wordSpace.put(String.valueOf(temp), 0);
            }
        }
        return wordSpace.size();
    }


    public static void main(String[] args) throws IOException {
        ArrayList<String> data = new ArrayList<>();
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            String line = sc.nextLine();
            StringTokenizer st = new StringTokenizer(line, " ");
            while (st.hasMoreTokens()){
               data.add(st.nextToken());
            }
        }

        int m = Integer.valueOf(data.get(1));
        String lecture = data.get(2);
        int wordCount = getWordsCount(lecture, m);


        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(wordCount));
        out.close();
    }
}
