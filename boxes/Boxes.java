package boxes;

import java.util.*;
import java.io.*;

public class Boxes {
    private static ArrayList<Integer> data = new ArrayList<>();
    private static ArrayList<Integer> boxFirst = new ArrayList<>();
    private static ArrayList<Integer> boxSecond = new ArrayList<>();

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
        for(int i = 0; i < data.size(); i++){
            if(i < 3){
                boxFirst.add(data.get(i));
            }else{
                boxSecond.add(data.get(i));
            }
        }
        Collections.sort(boxFirst);
        Collections.sort(boxSecond);
    }

    public static void main(String[] argv) throws IOException{
        getData();
        String result = (boxFirst.equals(boxSecond)) ? "Boxes are equal" :
                (boxFirst.get(0) >= boxSecond.get(0) && boxFirst.get(1) >= boxSecond.get(1) && boxFirst.get(2) >= boxSecond.get(2)) ? "The first box is larger than the second one" :
                        (boxSecond.get(0) >= boxFirst.get(0) && boxSecond.get(1) >= boxFirst.get(1) && boxSecond.get(2) >= boxFirst.get(2)) ? "The first box is smaller than the second one" :
                                "Boxes are incomparable";
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(result);
        pw.close();
    }
}
