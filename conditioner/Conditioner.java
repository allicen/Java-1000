package conditioner;

import java.io.*;
import java.util.*;

public class Conditioner {
    public static void main(String[] args) throws IOException {
        ArrayList<String> data = new ArrayList<>();
        String mode;
        String str;
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            str = sc.nextLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            while (st.hasMoreTokens()){
                data.add(st.nextToken());
            }
        }
        int tempNow = Integer.valueOf(data.get(0)); // Температура сейчас
        int tempWant = Integer.valueOf(data.get(1)); // Желаемая температура
        mode = (data.get(2).equals("fan")) ? data.get(0) : // Проверка всех условий
                (data.get(2).equals("heat") && tempNow < tempWant) ? String.valueOf(tempWant) :
                        (data.get(2).equals("heat") && tempNow > tempWant) ? String.valueOf(tempNow) :
                                (data.get(2).equals("freeze") && tempNow < tempWant) ? String.valueOf(tempNow) :
                                        (data.get(2).equals("freeze") && tempNow > tempWant) ? String.valueOf(tempWant) : String.valueOf(tempWant);

        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(mode);
        fileOut.close();
    }
}
