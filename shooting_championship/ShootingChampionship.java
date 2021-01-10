package shooting_championship;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ShootingChampionship {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        String n = sc.nextLine();
        ArrayList<Integer> data = new ArrayList<>();
        String[] dataArr = sc.nextLine().split(" ");

        int winnerPoints = 0;
        for (String number : dataArr) {
            int numberInt = Integer.parseInt(number);
            if (winnerPoints < numberInt) {
                winnerPoints = numberInt;
            }
            data.add(numberInt);
        }

        int pointsFather = -1;
        boolean wasFirst = false;
        for (int i = 0; i < data.size(); i++) {
            if (wasFirst && data.get(i) % 10 == 5 && i+1 < data.size() && data.get(i) > data.get(i+1) && pointsFather < data.get(i)) {
                pointsFather = data.get(i);
            }

            if (data.get(i) == winnerPoints) {
                wasFirst = true;
            }
        }

        data.sort(Comparator.reverseOrder());
        int position = 0;

        if (pointsFather > -1) {
            for (int number : data) {
                position++;
                if (number == pointsFather) {
                    break;
                }
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        out.println(position);
        out.flush();
    }
}
