package chess_workshop;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ChessWorkshop {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        String[] firstLine = sc.nextLine().split(" ");

        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);
        char[][] data = new char[n][m];

        for (int i = 0; i < n; i++) {
            char[] line = sc.nextLine().toCharArray();
            if (m >= 0) System.arraycopy(line, 0, data[i], 0, m);
        }

        int recolorFirstVariant = 0;
        int recolorSecondVariant = 0;
        StringBuilder recolorFirstVariantCoordinate = new StringBuilder();
        StringBuilder recolorSecondVariantCoordinate = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // 1 вариант перекраски
                if ((i+j) % 2 == 0 && data[i][j] == 'B') {
                    recolorFirstVariant++;
                    recolorFirstVariantCoordinate.append(i+1).append(" ").append(j+1).append("\r\n");
                } else if ((i+j) % 2 == 1 && data[i][j] == 'W') {
                    recolorFirstVariant++;
                    recolorFirstVariantCoordinate.append(i+1).append(" ").append(j+1).append("\r\n");
                }

                // 2 вариант перекраски
                if ((i+j) % 2 == 0 && data[i][j] == 'W') {
                    recolorSecondVariant++;
                    recolorSecondVariantCoordinate.append(i+1).append(" ").append(j+1).append("\r\n");
                } else if ((i+j) % 2 == 1 && data[i][j] == 'B') {
                    recolorSecondVariant++;
                    recolorSecondVariantCoordinate.append(i+1).append(" ").append(j+1).append("\r\n");
                }
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        if (recolorFirstVariant <= recolorSecondVariant) {
            out.println(recolorFirstVariant);
            out.println(recolorFirstVariantCoordinate);
        } else {
            out.println(recolorSecondVariant);
            out.println(recolorSecondVariantCoordinate);
        }
        out.flush();
    }
}
