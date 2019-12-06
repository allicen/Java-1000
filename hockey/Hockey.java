package hockey;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Hockey {
    public static void main(String[] args) throws IOException {
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        long teamCount = sc.nextLong();

        long twoTeam = (teamCount -1 > 0) ? teamCount -1 : 1;
        long threeTeam = (twoTeam-1 > 0) ? twoTeam-1 : 1;

        long combinationCount = teamCount * twoTeam * threeTeam;

        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(String.valueOf(combinationCount));
        fileOut.close();
    }
}
