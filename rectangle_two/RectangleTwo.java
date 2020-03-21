package rectangle_two;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class RectangleTwo {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new FileReader("input.txt"));

        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();
        int sideOne, sideTwo, sideThree;

        StringTokenizer elements = new StringTokenizer(scan.nextLine(), " ");
        int count = elements.countTokens();

        for (int i = 0; i < count; i++){
            int elem = Integer.valueOf(elements.nextToken());
            if(i % 2 == 0){
                x.add(elem);
            }else {
                y.add(elem);
            }
        }

        sideOne = (int) Math.sqrt(Math.pow(x.get(0) - x.get(1), 2) + Math.pow(y.get(0) - y.get(1), 2));
        sideTwo = (int) Math.sqrt(Math.pow(x.get(1) - x.get(2), 2) + Math.pow(y.get(1) - y.get(2), 2));
        sideThree = (int) Math.sqrt(Math.pow(x.get(0) - x.get(2), 2) + Math.pow(y.get(0) - y.get(2), 2));

        int hypotenuseSide = (sideOne > sideTwo && sideOne > sideThree) ? 1 :
                (sideTwo > sideOne && sideTwo > sideThree) ? 2 : 3;

        int x4 = 0, y4 = 0, xOneDiagonalSum, yOneDiagonalSum;
        switch (hypotenuseSide){
            case (1):
                xOneDiagonalSum = x.get(0) + x.get(1);
                yOneDiagonalSum = y.get(0) + y.get(1);

                x4 = xOneDiagonalSum - x.get(2);
                y4 = yOneDiagonalSum - y.get(2);

                break;
            case (2):
                xOneDiagonalSum = x.get(1) + x.get(2);
                yOneDiagonalSum = y.get(1) + y.get(2);

                x4 = xOneDiagonalSum - x.get(0);
                y4 = yOneDiagonalSum - y.get(0);
                break;
            case (3):
                xOneDiagonalSum = x.get(0) + x.get(2);
                yOneDiagonalSum = y.get(0) + y.get(2);

                x4 = xOneDiagonalSum - x.get(1);
                y4 = yOneDiagonalSum - y.get(1);
                break;
        }

        String result = x4 + " " + y4;

        FileWriter out = new FileWriter("output.txt");
        out.write(result);
        out.close();
    }
}
