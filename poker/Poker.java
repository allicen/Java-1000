package poker;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Poker {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> num = new ArrayList<>();

        String[] data = new Scanner(new FileReader("input.txt")).nextLine().split(" ");
        for (String number: data) {
            num.add(Integer.parseInt(number));
        }
        Collections.sort(num);

        PrintWriter out = new PrintWriter(System.out);

        if (num.get(0).equals(num.get(4))) {
            out.println("Impossible");
        } else if (num.get(0).equals(num.get(3)) || num.get(1).equals(num.get(4))) {
            out.println("Four of a Kind");
        } else if (num.get(0).equals(num.get(1)) && num.get(2).equals(num.get(4)) || num.get(0).equals(num.get(2)) && num.get(3).equals(num.get(4))) {
            out.println("Full House");
        } else if (num.get(0)+1 == num.get(1) && num.get(1)+1 == num.get(2) && num.get(2)+1 == num.get(3) && num.get(3)+1 == num.get(4)) {
            out.println("Straight");
        } else if (num.get(0).equals(num.get(2)) || num.get(1).equals(num.get(3)) || num.get(2).equals(num.get(4))) {
            out.println("Three of a Kind");
        } else if (num.get(0).equals(num.get(1)) && num.get(2).equals(num.get(3)) ||
                num.get(0).equals(num.get(1)) && num.get(3).equals(num.get(4)) ||
                num.get(1).equals(num.get(2)) && num.get(3).equals(num.get(4))) {
            out.println("Two Pairs");
        } else if (num.get(0).equals(num.get(1)) || num.get(1).equals(num.get(2)) || num.get(2).equals(num.get(3)) || num.get(3).equals(num.get(4))) {
            out.println("One Pair");
        } else {
            out.println("Nothing");
        }

        out.flush();
    }
}
