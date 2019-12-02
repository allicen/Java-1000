package numerologist;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Numerologist {
    public static void main(String[] args)throws IOException {
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);

        String time = sc.nextLine();
        int index = 0;

        while (time.length() > 1){
            long timeLong = 0;
            char[] chArr = time.toCharArray();
            for (char aChArr : chArr) {
                timeLong += Character.getNumericValue(aChArr);
            }
            index++;
            time = String.valueOf(timeLong);
        }

        String result = time + " " + index;

        FileWriter out = new FileWriter("output.txt");
        out.write(result);
        out.close();
    }
}