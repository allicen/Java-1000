package unpack_string;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UnpackString {
    public static void main(String[] args) throws IOException {
        String originalString;

        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        originalString = sc.nextLine();

        StringBuilder finishString = new StringBuilder();
        StringBuilder number = new StringBuilder();

        char[] ch = originalString.toCharArray();
        int shift = 0;
        for (char aCh : ch) {
            String symbol = String.valueOf(aCh);
            if (symbol.matches("\\d")) {
                number.append(symbol);
            } else {
                if (number.length() == 0) {
                    if(finishString.length() > 0 && (finishString.length() - shift) % 40 == 0){
                        finishString.append("\n");
                        shift++;
                    }
                    finishString.append(symbol);
                } else {
                    int countSymbol = Integer.valueOf(String.valueOf(number));
                    for (int j = 0; j < countSymbol; j++) {
                        if(finishString.length() > 0 && (finishString.length() - shift) % 40 == 0){
                            finishString.append("\n");
                            shift++;
                        }
                        finishString.append(symbol);
                    }
                    number = new StringBuilder();
                }
            }
        }

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(finishString));
        out.close();
    }
}
