package dictionary;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {
    public static void main(String[] args) throws IOException {
        ArrayList<String> words = new ArrayList<>();
        String dictionary;
        int wordsCount = 0;

        Scanner sc = new Scanner(new FileReader("input.txt"));
        while (sc.hasNextLine()) {
            words.add(sc.nextLine());
        }
        dictionary = words.get(words.size()-1);
        words.remove(words.size()-1);
        words.remove(0);

        for (String word : words) {
            char[] dictionaryCopy = dictionary.toCharArray();

            char[] characters = word.toCharArray();
            boolean wordInDictionary = true;
            for (char character : characters) {
                if (!String.valueOf(dictionaryCopy).contains(String.valueOf(character))) {
                    wordInDictionary = false;
                    break;
                } else {
                    dictionaryCopy[String.valueOf(dictionaryCopy).indexOf(String.valueOf(character))] = ' ';
                }
            }

            if (wordInDictionary) {
                wordsCount++;
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        out.println(wordsCount);
        out.flush();
    }
}
