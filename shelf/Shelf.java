package shelf;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Shelf {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);

        ArrayDeque<String> discs = new ArrayDeque<>();

        Scanner sc = new Scanner(new FileReader("input.txt"));
        int index = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (index != 0) {
                String[] actions = line.split(" ");
                if (actions.length == 2 && actions[0].equals("1")) {
                    discs.addFirst(actions[1]);
                } else if (actions.length == 2 && actions[0].equals("2")) {
                    discs.addLast(actions[1]);
                } else if (actions[0].equals("3")) {
                    out.print(discs.getFirst() + " ");
                    discs.removeFirst();
                } else {
                    out.print(discs.getLast() + " ");
                    discs.removeLast();
                }
            }
            index++;
        }

        out.flush();
    }
}
