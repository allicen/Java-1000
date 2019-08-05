package left_recursion;

import java.util.*;
import java.io.*;

public class LeftRecursion {
    private static ArrayList<String> data = new ArrayList<>();
    private static ArrayList<String> dataLine = new ArrayList<>();
    private static void getData() throws IOException{ // Получение данных
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            dataLine.add(sc.nextLine());
        }
        for(int i = 0; i < dataLine.size(); i++){
            if(i != 0){
                StringTokenizer st = new StringTokenizer(dataLine.get(i), "->");
                while (st.hasMoreTokens()){
                    data.add(st.nextToken());
                }
            }
        }
    }

    public static void main(String[] argv) throws IOException{
        getData();

        int count = 0;
        String left = "";

        for(int i = 0; i < data.size(); i++){
            if(i % 2 == 0){
                left = data.get(i);
            }else{
                char oneSymbolRight = data.get(i).charAt(0);
                if(left.equals(String.valueOf(oneSymbolRight))){
                    count++;
                }
            }
        }
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(String.valueOf(count));
        pw.close();
    }
}
