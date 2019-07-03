package compression_binary_sequences;

import java.util.*;
import java.io.*;

public class CompressionBinarySequences {
    private static ArrayList<String> symbols = new ArrayList<>();
    private static void getData() throws IOException{
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        String str = sc.nextLine();
        char[] ch = str.toCharArray();
        for (char aCh : ch) {
            String st = String.valueOf(aCh);
            if (st.equals("1") || st.equals("0")) {
                symbols.add(st);
            }
        }
    }
    public static void main(String[] argv) throws IOException{
        char[] abc = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        getData();
        int k = 0; // Счетчик количества нулей перед 1
        StringBuilder code = new StringBuilder(); // Итоговая строка
        for (String symbol : symbols) {
            if (symbol.equals("1")) {
                code.append(String.valueOf(abc[k])); // Добавить к строке букву
                k = 0;
            } else {
                k++;
            }
        }
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(code);
        pw.close();
    }
}
