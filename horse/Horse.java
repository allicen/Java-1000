package horse;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Horse {

    private static ArrayList<String> move (String cellFrom) {
        ArrayList<String> firstMove = new ArrayList<>();
        char character = cellFrom.charAt(0);
        int number = Integer.parseInt(cellFrom.substring(1));

        if (character-2 >= 'a' && number-1 >= 1) {
            firstMove.add(String.valueOf((char)(character-2)) + (number - 1));
        }
        if (character-1 >= 'a' && number-2 >= 1) {
            firstMove.add(String.valueOf((char)(character-1)) + (number - 2));
        }
        if (character-2 >= 'a' && number+1 <= 8) {
            firstMove.add(String.valueOf((char)(character-2)) + (number + 1));
        }
        if (character-1 >= 'a' && number+2 <= 8) {
            firstMove.add(String.valueOf((char)(character-1)) + (number + 2));
        }

        if (character+2 <= 'h' && number-1 >= 1) {
            firstMove.add(String.valueOf((char)(character+2)) + (number - 1));
        }
        if (character+1 <= 'h' && number-2 >= 1) {
            firstMove.add(String.valueOf((char)(character+1)) + (number - 2));
        }
        if (character+2 <= 'h' && number+1 <= 8) {
            firstMove.add(String.valueOf((char)(character+2)) + (number + 1));
        }
        if (character+1 <= 'h' && number+2 <= 8) {
            firstMove.add(String.valueOf((char)(character+1)) + (number + 2));
        }

        return firstMove;
    }

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);

        String[] cells = new Scanner(new FileReader("input.txt")).nextLine().split(", ");
        String cellFrom = cells[0];
        String cellTo = cells[1];

        ArrayList<String> firstMove = move(cellFrom);
        if (firstMove.contains(cellTo)) {
            out.println(1);
        } else {
            boolean flag = false;
            for (String cell : firstMove) {
                ArrayList<String> secondMove = move(cell);
                if (secondMove.contains(cellTo)) {
                    out.println(2);
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                out.println("NO");
            }
        }

        out.flush();
    }
}
