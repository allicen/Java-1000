package numbers_game;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.StringTokenizer;

public class NumbersGame {
    private static ArrayDeque<Integer> queue = new ArrayDeque<>();

    private static int play(){
        int player = 0;
        if(queue.getFirst() >= queue.getLast()){
            player += queue.getFirst();
            queue.removeFirst();
        }else {
            player += queue.getLast();
            queue.removeLast();
        }
        return player;
    }


    public static void main(String[] args) throws IOException {
        int firstPlayerPoints = 0;
        int secondPlayerPoints = 0;

        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            String str = sc.nextLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            while (st.hasMoreTokens()){
                queue.add(Integer.valueOf(st.nextToken()));
            }
        }
        queue.removeFirst();

        int steps = queue.size();

        for (int i = 0; i < steps; i++){
            if (i % 2 == 0){
                firstPlayerPoints += play();
            }else {
               secondPlayerPoints += play();
            }
        }

        String result = firstPlayerPoints + ":" + secondPlayerPoints;

        FileWriter out = new FileWriter("output.txt");
        out.write(result);
        out.close();
    }
}
