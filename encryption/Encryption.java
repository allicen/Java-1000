package encryption;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Encryption {
    private static Map<Integer, Character> _getAlphabet() {
        Map<Integer, Character> alphabet = new HashMap<>();
        int i = 0;
        for(char c = 'A'; c <= 'Z'; ++c) {
            alphabet.put(i, c);
            i++;
        }
        return alphabet;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        String encryptedString = sc.nextLine();
        String correctWord = sc.nextLine();

        Map<Integer, Character> alphabet = _getAlphabet();
        StringBuilder result = new StringBuilder();

        if (encryptedString.contains(correctWord)) {
            result.append(encryptedString);
        } else {
            for (int i = 25; i > 0; i--) {
                for (int j = 0; j < encryptedString.length(); j++) {
                    int charIndex = 0;
                    for (int k = 0; k < alphabet.size(); k++) {
                        if (encryptedString.charAt(j) == alphabet.get(k)) {
                            charIndex = k;
                        }
                    }
                    int index = (i + charIndex) % 26;
                    result.append(alphabet.get(index));
                }

                if (result.indexOf(correctWord) == -1) {
                    result.delete(0, result.length());
                } else {
                    break;
                }
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        if (result.length() == 0) {
            out.println("IMPOSSIBLE");
        } else {
            out.println(result);
        }
        out.flush();
    }
}
