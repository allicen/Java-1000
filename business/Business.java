package business;

import java.util.*;
import java.io.*;

public class Business {
    private static ArrayList<Integer> carCost = new ArrayList<>();
    private static ArrayList<Integer> startData = new ArrayList<>();

    private static void getData() throws IOException{
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        int numberLine = 0;
        while (sc.hasNextLine()){
            numberLine++;
            String str = sc.nextLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            while (st.hasMoreTokens()){
                if(numberLine != 1){
                    carCost.add(Integer.valueOf(st.nextToken()));
                }else{
                    startData.add(Integer.valueOf(st.nextToken()));
                }
            }
        }
    }

    public static void main(String[] argv) throws IOException {
        getData();
        int money = startData.get(1);
        int k = 0;
        Collections.sort(carCost);
        for (Integer aCarCost : carCost) {
            money = money - aCarCost;
            if (money >= 0) {
                k++;
            } else {
                break;
            }
        }
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(String.valueOf(k));
        pw.close();
    }
}
