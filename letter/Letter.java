package letter;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Letter {
    public static void main(String[] args) throws IOException {
        ArrayList<String> lines = new ArrayList<>();
        boolean conditionIsFeasible = true;

        Scanner rows = new Scanner(new InputStreamReader(System.in, "cp866"));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out, "cp866"));

        String[] data = rows.nextLine().split(" ");
        int k = Integer.parseInt(data[0]);
        int n = Integer.parseInt(data[1]);

        while (n > 0) {
            String line = rows.nextLine().trim();
                if (line.length() > k) { // проверка на выполнимость условий
                    conditionIsFeasible = false;
                    out.println("Impossible.");
                    break;
                }
                lines.add(line);
            n--;
        }

     //   System.out.println(lines);

        if (conditionIsFeasible) {
            for (String line : lines) {
                int numberOfSpaces = k - line.length(); // общее кол-во пробелов
                int numberOfSpacesStart = numberOfSpaces/2; // количество пробелов в начале строки
                int numberOfSpacesEnd = numberOfSpaces/2 + numberOfSpaces%2; // количество пробелов в начале строки

                for (int i = 0; i < numberOfSpacesStart; i++) {
                    out.print(" ");
                }
                out.print(line);
                for (int i = 0; i < numberOfSpacesEnd; i++) {
                    out.print(" ");
                }
                out.print('\n');
            }
        }

        out.flush();
    }
}
