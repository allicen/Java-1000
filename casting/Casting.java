package casting;

import java.util.*;
import java.io.*;

public class Casting {
    private static ArrayList<Integer> data = new ArrayList<>();
    private static int actorCount = 0;

    private static void getData() throws IOException{
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            String str = sc.nextLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            while (st.hasMoreTokens()){
                data.add(Integer.valueOf(st.nextToken()));
            }
        }
    }

    private static void dataProcessing(){
        int typeCasting  = data.get(0);
        int n = data.get(1);
        data.remove(data.get(0));
        data.remove(data.get(0));
        Collections.sort(data);
        int aFactor = data.get(0);
        int bFactor = data.get(1);
        int cFactor = data.get(2);
        if(typeCasting == 2){ // Вычисление максимального кол-ва актеров
            actorCount = aFactor;
        }else{ // Вычисление минимального кол-ва актеров
            if(aFactor != 0 && bFactor != 0 && cFactor != 0){
                actorCount = (aFactor + bFactor + cFactor) - 2 * n; // Пересечение множеств
                actorCount = (actorCount <= 0) ? 0 : actorCount; // Если значение менее или = 0, множества не пересекаются
            }
        }
    }

    public static void main(String[] argv) throws IOException{
        getData();
        dataProcessing();
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(String.valueOf(actorCount));
        pw.close();
    }
}

