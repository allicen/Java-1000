package carousel;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Carousel {
    private static ArrayList<Integer> answers = new ArrayList<>();

    private static long pointTotal(){
        int startScore = 3;
        int mistakePenalty = 3;
        long total = 0;
        for(int i : answers){
            if (i == 1){
                total += startScore;
                startScore++;
            }else {
                startScore = (startScore - mistakePenalty < mistakePenalty) ? mistakePenalty : startScore - mistakePenalty;
            }
        }
        return total;
    }

    public static void main(String[] args) throws IOException {
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
            while (st.hasMoreTokens()){
                answers.add(Integer.valueOf(st.nextToken()));
            }
        }
        answers.remove(0);

        long result = pointTotal();

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(result));
        out.close();
    }
}
