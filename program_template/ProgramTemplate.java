package program_template;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class ProgramTemplate {

    private static int wordEnergy(int position) {
        if (position < 10) {
            return position;
        }
        return position/10 + position%10;
    }

    public static void main(String[] args) throws IOException {

        int energy = 0;
        String words = "abcdefghijklmnopqrstuvwxyz";

        Scanner sc = new Scanner(new FileReader("input.txt"));
        while (sc.hasNextLine()) {
            char[] symbols = sc.nextLine().toCharArray();
            for (char character : symbols) {
                String symbol = String.valueOf(character);

                if (words.contains(symbol.toLowerCase())) {
                    energy += wordEnergy(words.indexOf(symbol.toLowerCase())+1);

                    if (!symbol.toLowerCase().equals(symbol)) {
                        energy += 10;
                    }
                } else if (symbol.equals(" ")) {
                    energy += 4;
                } else if (symbol.equals(".")) {
                    energy += 5;
                } else if (symbol.equals(";")) {
                    energy += 7;
                } else if (symbol.equals(",")) {
                    energy += 2;
                } else if ("=+-'\"".contains(symbol)) {
                    energy += 3;
                } else if ("()".contains(symbol)) {
                    energy += 1;
                } else if ("{}[]<>".contains(symbol)) {
                    energy += 8;
                } else if (symbol.matches("\\d")) {
                    energy += 13 - Integer.parseInt(symbol);
                }
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        out.println(energy);
        out.flush();
    }
}
