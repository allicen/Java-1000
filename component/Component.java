package component;

import java.util.*;
import java.io.*;

public class Component {
    private static ArrayList<Integer> data = new ArrayList<>();
    private static void getData() throws IOException{ // Получение данных
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        int numberLine = 0;
        while (sc.hasNextLine()){
            numberLine++;
            String str = sc.nextLine();
            char[] ch = str.toCharArray();
            int k = 0;
            for (char aCh : ch) {
                String symbol = String.valueOf(aCh);
                if (symbol.equals(".")) {
                    k++;
                }
            }
            if(numberLine != 1){
                data.add(k);
            }
        }
    }

    public static void main(String[] argv) throws IOException{
        getData();
        Collections.sort(data);
        String cellCount = String.valueOf(data.get(0));
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(cellCount);
        pw.close();
    }
}
