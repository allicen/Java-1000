package construction_of_roads;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class ConstructionOfRoads {
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(new Scanner(new FileReader("input.txt")).nextLine());
        PrintWriter out = new PrintWriter(System.out);
        BigInteger res = BigInteger.valueOf(3).pow((n*(n-1))/2);
        out.println(res);
        out.flush();
    }
}
