package bowling;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Bowling {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> hits = new ArrayList<>();

        Scanner sc = new Scanner(new FileReader("input.txt"));
        while (sc.hasNextLine()) {
            String[] input = sc.nextLine().split(" ");
            for (String hit: input) {
                hits.add(Integer.parseInt(hit));
            }
        }
        hits.remove(0); // удалить количество бросков

        int points = 0; // количество очков
        int attemptCount = 1; // номер попытки
        boolean firstShot = true;
        for (int index = 0; index < hits.size(); index++) {
            if (firstShot && hits.get(index) == 10 && attemptCount <= 9) {
                points += 10;
                if (index + 1 < hits.size()) {
                    points += hits.get(index + 1);
                }
                if (index + 2 < hits.size()) {
                    points += hits.get(index + 2);
                }
                firstShot = false;
            } else if (!firstShot && hits.get(index) + hits.get(index - 1) == 10 && attemptCount <= 9) {
                points += hits.get(index);
                if (index + 1 < hits.size()) {
                    points += hits.get(index + 1);
                }
            } else {
                points += hits.get(index);
            }

            if (!firstShot) {
                attemptCount++;
            }
            firstShot = !firstShot;
        }

        PrintWriter out = new PrintWriter(System.out);
        out.println(points);
        out.flush();

    }
}
