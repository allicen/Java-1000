package home_school;

import java.util.*;
import java.io.*;

public class HomeSchool {
    private static ArrayList<String> data = new ArrayList<>();
    private static void getData() throws IOException{ // Получение данных
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            data.add(sc.nextLine());
        }
    }

    public static void main(String[] argv) throws IOException{
        getData();

        String stationStart = data.get(0);
        int travelCount = Integer.valueOf(data.get(1));

        String result = (stationStart.equals("School") && travelCount % 2 == 0) ? "No" : "Yes";

        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(result);
        pw.close();
    }
}
