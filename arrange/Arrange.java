package arrange;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Arrange {
    public static void main(String[] args) throws IOException {
        ArrayList<String> firstName = new ArrayList<>();
        ArrayList<String> secondName = new ArrayList<>();

        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        int ind = 0;
        while (st.hasMoreTokens()){
            String str = st.nextToken();
            char[] ch = str.toCharArray();
            for (char symbol : ch) {
                if (ind == 0) {
                    firstName.add(String.valueOf(symbol).toLowerCase());
                } else {
                    secondName.add(String.valueOf(symbol).toLowerCase());
                }
            }
            ind++;
        }

        Collections.sort(firstName);
        Collections.sort(secondName);

        String result = firstName.equals(secondName) ? "Yes" : "No";

        FileWriter out = new FileWriter("output.txt");
        out.write(result);
        out.close();
    }
}
