package _other_tasks_.i_basketball_game;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class BasketballGame {
    public static void main(String[] args) throws IOException {

        long firstTeam = 0;
        long secondTeam = 0;

        Scanner sc = new Scanner(new FileReader("input.txt"));
        while (sc.hasNextLine()) {
            String[] goal = sc.nextLine().split(" ");
            if (goal.length == 2) {
                int team = Integer.parseInt(goal[0]);
                int distance = Integer.parseInt(goal[1]);
                int points = distance == -1 ? 1 : distance <= 6 ? 2 : 3;
                if (team == 1) {
                    firstTeam += points;
                } else secondTeam += points;
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        out.println(firstTeam + ":" + secondTeam);
        out.flush();
    }
}
