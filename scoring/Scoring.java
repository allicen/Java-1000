package scoring;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Scoring {
    public static void main(String[] args) throws IOException {
        StringBuilder result = new StringBuilder();
        ArrayList<Integer> testsPoints = new ArrayList<>();
        int bonus = 0;

        Scanner sc = new Scanner(new FileReader("input.txt"));
        int index = 0;
        int penalty = 0;
        int max = 0;
        boolean isPoints = false;
        while (sc.hasNextLine()){
            String line = sc.nextLine();
            if(index == 2){
                bonus = Integer.valueOf(line);
            }else if(index != 0 && index != 3){
                StringTokenizer st = new StringTokenizer(line, " ");
                int successTests = 0, successTotal = 0;
                int i = 0;
                while (st.hasMoreTokens()){
                    int number = Integer.valueOf(st.nextToken());
                    if(index == 1){
                        testsPoints.add(number);
                    }else {
                        isPoints = true;
                        successTests += number;
                        successTotal += number * testsPoints.get(i);
                        i++;
                    }
                }

                if(isPoints){
                    if(successTests == testsPoints.size()){
                        successTotal += bonus;
                    }

                    successTotal -= penalty;

                    if(successTotal < 0){
                        successTotal = 0;
                    }

                    max = successTotal > max ? successTotal : max;
                    result.append(max).append("\n");

                    penalty += 2;
                }
            }
            index++;
        }

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(result));
        out.close();
    }
}
