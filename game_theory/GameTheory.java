package game_theory;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GameTheory {
    public static void main(String[] args) throws IOException {
        int max, min;

        Scanner scan = new Scanner(new FileReader("input.txt"));
        int lineNumber = -1;

        ArrayList<Integer> minRows = new ArrayList<>();
        ArrayList<Integer> maxColumns = new ArrayList<>();

        while (scan.hasNextLine()){
            String[] coordinates = scan.nextLine().split(" ");
            if (lineNumber != -1) {
                int minRow = 9999;
                for (int column = 0; column < coordinates.length; column++) {
                    int cellValue = Integer.parseInt(coordinates[column]);

                    if (minRow > cellValue) {
                        minRow = cellValue;
                    }
                    if (maxColumns.size() < coordinates.length) {
                        maxColumns.add(-9999);
                    }
                    if (maxColumns.get(column) < cellValue) {
                        maxColumns.set(column, cellValue);
                    }
                }
                minRows.add(minRow);
            }
            lineNumber++;
        }

        Collections.sort(minRows);
        Collections.sort(maxColumns);

        min = minRows.get(minRows.size()-1);
        max = maxColumns.get(0);

        FileWriter out = new FileWriter("output.txt");
        out.write(min + " " + max);
        out.close();
    }
}
