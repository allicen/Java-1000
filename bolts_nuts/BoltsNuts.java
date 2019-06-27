package bolts_nuts;

import java.util.*;
import java.io.*;

public class BoltsNuts {
    private static ArrayList<String> data = new ArrayList<>();
    private static ArrayList<Double> bolt = new ArrayList<>();
    private static ArrayList<Double> nuts = new ArrayList<>();

    private static void getData() throws IOException{
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            data.add(sc.nextLine());
        }
        StringTokenizer stBolts = new StringTokenizer(data.get(0), " ");
        while (stBolts.hasMoreTokens()){
            bolt.add(Double.valueOf(stBolts.nextToken()));
        }
        StringTokenizer stNuts = new StringTokenizer(data.get(1), " ");
        while (stNuts.hasMoreTokens()){
            nuts.add(Double.valueOf(stNuts.nextToken()));
        }
    }
    public static void main(String[] argv) throws IOException{
        getData();
        double subtotal = bolt.get(0) * (bolt.get(1) / 100) * bolt.get(2) + nuts.get(0) * (nuts.get(1) / 100) * nuts.get(2);

        double boltSave = bolt.get(0) - bolt.get(0) * (bolt.get(1) / 100);
        double nutsSave = nuts.get(0) - nuts.get(0) * (nuts.get(1) / 100);
        double diffrentDetail = (boltSave > nutsSave) ? (boltSave - nutsSave) * bolt.get(2) :
                (boltSave < nutsSave) ? (nutsSave - boltSave) * nuts.get(2) : 0;
        double result = subtotal + diffrentDetail;
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(String.valueOf((int)result));
        pw.close();
    }

}
