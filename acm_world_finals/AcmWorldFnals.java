package acm_world_finals;

import java.util.*;
import java.io.*;

public class AcmWorldFnals {
    public static void main(String[] argv) throws IOException{
        ArrayList<String> data = new ArrayList<>(); // Все данные
        ArrayList<String> names = new ArrayList<>(); // Имена участников
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            data.add(sc.nextLine());
        }
        for(int i = 0; i < data.size(); i++){
            if(i != 0){
                names.add(data.get(i));
            }
        }
        Collections.sort(names);
        System.out.println(data);
        String result = data.get(0) + ": " + String.join(", ", names); // Имена перечислить через запятую
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(result);
        pw.close();
    }
}
