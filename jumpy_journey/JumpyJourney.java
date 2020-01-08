package jumpy_journey;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class JumpyJourney {
    public static void main(String[] args) throws IOException {
        ArrayList<int[]> coordinate = new ArrayList<>();
        int[] frog = new int[2];
        int lengthTongue = 0;

        Scanner sc = new Scanner(new FileReader("input.txt"));
        int index = 0;
        while (sc.hasNextLine()){
            StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
            while (st.hasMoreTokens()){
                if(index == 0){
                    int n = Integer.valueOf(st.nextToken());
                    frog = new int[]{Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken())};
                    lengthTongue = Integer.valueOf(st.nextToken());
                }else {
                    coordinate.add(new int[]{Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken())});
                }
            }
            index++;
        }

        int countJump = 0;
        for(int i = 0; i < coordinate.size(); i++){
            double distance = Math.sqrt(Math.pow(coordinate.get(i)[0] - frog[0], 2) + Math.pow(coordinate.get(i)[1] - frog[1], 2));
            if(distance <= lengthTongue){
                countJump = i+1;
                break;
            }
        }

        String result = countJump == 0 ? "Yes" : String.valueOf(countJump);

        FileWriter out = new FileWriter("output.txt");
        out.write(result);
        out.close();
    }
}
