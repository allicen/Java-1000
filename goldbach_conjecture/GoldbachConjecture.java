package goldbach_conjecture;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GoldbachConjecture {
    private static boolean isSimple(int number) {
        for (int index = 2; index < number; index++) {
            if (number % index == 0) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        int numberInput = sc.nextInt();
        int[] numbersOutput = new int[2];

        for (int index = 2; index <= numberInput/2; index++) {
            int difference = numberInput - index;
            if (isSimple(index) && isSimple(difference)) {
                numbersOutput[0] = index;
                numbersOutput[1] = difference;
                break;
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        out.println(numbersOutput[0] + " " + numbersOutput[1]);
        out.flush();
    }
}
