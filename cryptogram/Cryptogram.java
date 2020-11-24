package cryptogram;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Cryptogram {
    private static Map<Character, Character> _getAlphabet() {
        Map<Character, Character> alphabet = new HashMap<>();
        for(char c = 'a'; c <= 'z'; ++c) {
            alphabet.put(c, ' ');
        }
        return alphabet;
    }

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        ArrayList<String> data  = new ArrayList<>();

        Map<Character, Character> alphabet = _getAlphabet();

        String templateString = "the quick brown fox jumps over the lazy dog";
        boolean success = false; // есть ли решение

        Scanner sc = new Scanner(new FileReader("input.txt"));

        sc.nextLine(); // первая строка
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            data.add(line);
            if (line.length() == templateString.length() && !success) {
                char[] symbols = line.toCharArray();
                for (int i = 0; i < symbols.length; i++) {
                    char templateSymbol = templateString.charAt(i);
                    if (symbols[i] != ' ') {
                        alphabet.put(symbols[i], templateSymbol);
                    }
                }

                if (alphabet.containsValue(' ')) { // если заполнен не весь алфавит
                    alphabet = _getAlphabet();
                } else {
                    // новая строка
                    StringBuilder newLine = new StringBuilder();

                    // сборка новой строки
                    for (char symbol : symbols) {
                        if (symbol == ' ') {
                            newLine.append(' ');
                        } else {
                            newLine.append(alphabet.get(symbol));
                        }
                    }

                    // сравнение новой строки с шаблоном
                    if (String.valueOf(newLine).equals(templateString)) {
                        success = true;
                    }
                }
            }
        }

        if (success) {
            for (String line : data) {
                char[] symbols = line.toCharArray();
                for (char symbol: symbols) {
                    if (symbol != ' ') {
                        out.print(alphabet.get(symbol));
                    } else {
                        out.print(" ");
                    }
                }
                out.println();
            }
        } else {
            out.println("No solution");
        }
        out.flush();
    }
}
