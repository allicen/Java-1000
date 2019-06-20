package lucky_ticket;

import java.io.*;
import java.util.*;

public class LuckyTicket {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> data = new ArrayList<>();
        String result;
        String str;
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        str = sc.nextLine();
        char[] symbols = str.toCharArray();
        for (char symbol : symbols) {
            data.add(Character.getNumericValue(symbol));
        }
        result = (data.get(0) + data.get(1) + data.get(2) == data.get(3) + data.get(4) + data.get(5)) ? "YES" : "NO";
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(result);
        fileOut.close();
    }
}
