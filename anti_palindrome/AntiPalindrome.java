package anti_palindrome;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AntiPalindrome {
    public static void main(String[] args) throws IOException {
        Set<Character> symbols = new HashSet<>();

        Scanner sc = new Scanner(new FileReader("input.txt"));
        String str = sc.nextLine();

        char[] ch = str.toCharArray();
        boolean palindrome = true;
        int j = 0;
        for (int i = str.length()-1; i >= 0; i--){
            if(ch[j] != ch[i]){
                palindrome = false;
            }
            symbols.add(ch[i]);
            j++;
        }

        String result = (symbols.size() == 1) ? "NO SOLUTION" :
                (!palindrome) ? str : str.substring(0, str.length()-1);

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(result));
        out.close();
    }
}
