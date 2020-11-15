package usm_dialogs;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class UsmDialogs {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner(new FileReader("input.txt"));
        ArrayList<String> lines = new ArrayList<>();

        int startTextIndex = 10;
        String authorName = "Fedya";
        String guestName = "";
        boolean isAuthor = true;

        int index = 0;
        while (sc.hasNextLine()){
            String line = sc.nextLine();

            if (index == 0) {
                guestName = line.substring(startTextIndex, line.indexOf(" signed on"));
            } else {
                lines.add(line);
            }
            index++;

        }

        lines.remove(lines.size()-1);

        for (String line : lines) {
            String text = line.substring(startTextIndex);
            char lastSymbol = text.charAt(text.length() - 1);

            out.print("\"");

            if (lastSymbol == '!' || lastSymbol == '?') {
                out.print(text);
            } else if (lastSymbol == '.') {
                out.print(text.substring(0, text.length() - 1));
                out.print(",");
            } else {
                out.print(text);
                out.print(",");
            }

            out.print("\" --- skazal ");

            if (isAuthor) {
                out.print(authorName);
            } else {
                out.print(guestName);
            }
            out.print(".\n");
            isAuthor = !isAuthor;
        }

        out.flush();
    }
}
