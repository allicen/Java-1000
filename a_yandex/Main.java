package a_yandex;

import java.util.*;
import java.io.*;

public class Main {
    private static ArrayList<String> dataLine = new ArrayList<>();
    private static ArrayList<Integer> dataOne = new ArrayList<>();
    private static ArrayList<Integer> dataTwo = new ArrayList<>();
    private static ArrayList<Integer> summData = new ArrayList<>();
    private static void getData() throws IOException{ // Получение данных
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            dataLine.add(sc.nextLine());
        }
        for(int i = 0; i < dataLine.size(); i++){
            if(i == 1){
                StringTokenizer st = new StringTokenizer(dataLine.get(i), " ");
                while (st.hasMoreTokens()){
                    dataOne.add(Integer.valueOf(st.nextToken()));
                }
            }
            if(i == 3){
                StringTokenizer st = new StringTokenizer(dataLine.get(i), " ");
                while (st.hasMoreTokens()){
                    dataTwo.add(Integer.valueOf(st.nextToken()));
                }
            }
        }
    }
    public static void main(String[] argv) throws IOException{
        getData();

        if(dataOne.size() != dataTwo.size()){
            if(dataOne.size() > dataTwo.size()){
                for(int i = dataTwo.size(); i < dataOne.size(); i++){
                    dataTwo.add(0, 0);
                }
            }else{
                for(int i = dataOne.size(); i < dataTwo.size(); i++){
                    dataOne.add(0, 0);
                }
            }
        }
        for(int i = 0; i < dataOne.size(); i++){
            summData.add(dataOne.get(i) + dataTwo.get(i));
        }

        StringBuilder summResult = new StringBuilder();
        for(Integer line : summData){
            summResult.append(line).append(" ");
        }
        int pow;
        if(summData.size() - 1 >= 0){
            pow = summData.size() - 1;
        }else{
            pow = 0;
        }
        String result = pow + "\n" + summResult;
        System.out.println(result);
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(result);
        pw.close();
    }
}
