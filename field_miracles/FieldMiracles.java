package field_miracles;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FieldMiracles {
    public static void main(String[] args) throws IOException {
        int[] numbers = new int[0];
        int sectorCount = 0;

        Scanner rows = new Scanner(new FileReader("input.txt"));
        int rowIndex = 0;
        while (rows.hasNextLine()){
            String[] numbersInput = rows.nextLine().split(" ");
            if (rowIndex != 0) {
                for (int i = 0; i < numbersInput.length; i++) {
                    numbers[i] = Integer.parseInt(numbersInput[i]);
                }
            } else {
                sectorCount = Integer.parseInt(numbersInput[0]);
                numbers = new int[sectorCount];
            }
            rowIndex++;
        }

        sectorCount = sectorCount-1;

        boolean end = false;
        for (int i = 1; i < sectorCount; i++) {
            if (sectorCount % i == 0) {
                int j = 0;
                while (numbers[j % i] == numbers[j] && j < sectorCount) {
                    j++;
                    if (j == sectorCount) {
                        sectorCount = i;
                        end = true;
                        break;
                    }
                }
            }
            if (end) break;
        }

        PrintWriter out = new PrintWriter(System.out);
        out.println(sectorCount);
        out.flush();
    }
}
