package cross_zero;

import java.util.*;
import java.io.*;

public class CrossZero {
    private static ArrayList<Integer> data = new ArrayList<>();
    private static String result;

    private static void getData() throws IOException{
        String[][] game = new String[3][3];
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            String str = sc.nextLine();
            char[] ch = str.toCharArray();
            for (char aCh : ch) {
                switch (String.valueOf(aCh)) {
                    case "X":
                        data.add(1);
                        break;
                    case "O":
                        data.add(0);
                        break;
                    default:
                        data.add(-3);
                        break;
                }
            }
        }
    }

    private static void winnerLose(){
        result = (data.get(0) + data.get(4) + data.get(8) == 3 ||
                data.get(2) + data.get(4) + data.get(6) == 3 ||
                data.get(0) + data.get(3) + data.get(6) == 3 ||
                data.get(1) + data.get(4) + data.get(7) == 3 ||
                data.get(2) + data.get(5) + data.get(8) == 3 ||
                data.get(0) + data.get(1) + data.get(2) == 3 ||
                data.get(3) + data.get(4) + data.get(5) == 3 ||
                data.get(6) + data.get(7) + data.get(8) == 3 ) ? "Win" :
                (data.get(0) + data.get(4) + data.get(8) == 0 ||
                data.get(2) + data.get(4) + data.get(6) == 0 ||
                data.get(0) + data.get(3) + data.get(6) == 0 ||
                data.get(1) + data.get(4) + data.get(7) == 0 ||
                data.get(2) + data.get(5) + data.get(8) == 0 ||
                data.get(0) + data.get(1) + data.get(2) == 0 ||
                data.get(3) + data.get(4) + data.get(5) == 0 ||
                data.get(6) + data.get(7) + data.get(8) == 0) ? "Lose" : "Draw";
    }

    public static void main(String[] argv) throws IOException{
        getData();
        winnerLose();
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(result);
        pw.close();
    }
}
