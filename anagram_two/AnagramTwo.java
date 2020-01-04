package anagram_two;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AnagramTwo {
    public static void main(String[] args) throws IOException {
        String result = "YES";
        ArrayList<Character> one = new ArrayList<>();
        ArrayList<Character> two = new ArrayList<>();

        Scanner sc = new Scanner(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        String oneWord = st.nextToken();
        String twoWord = st.nextToken();

        char[] oneSymbols = oneWord.toCharArray();
        char[] twoSymbols = twoWord.toCharArray();

        for(char i : oneSymbols){
            one.add(i);
        }
        for(char j : twoSymbols){
            two.add(j);
        }

        Collections.sort(one);
        Collections.sort(two);

        if(!one.equals(two)){
            result = "NO";
        }else {
            for(int i = 0; i < oneSymbols.length; i++){
                if(oneSymbols[i] == twoSymbols[i]){
                    result = "NO";
                    break;
                }
            }
        }

        FileWriter out = new FileWriter("output.txt");
        out.write(result);
        out.close();
    }
}
