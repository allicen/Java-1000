package alibaba;

import java.util.*;
import java.io.*;

public class Alibaba {
    private static ArrayList<Integer> data = new ArrayList<>();

    private static void getData() throws IOException{ // Получение данных
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

    public static void main(String[] argv) throws IOException{
        getData();

        ArrayList<Integer> resultArr = new ArrayList<>();
        int result = 0;

        int max = data.get(1);

        for(int i = 0; i < data.size(); i++){
            if(i != 0 && i != 1 && data.get(i) > 0){
                resultArr.add(data.get(i));
            }
        }

        resultArr.sort(Collections.reverseOrder());

        for(int i = 0; i < max; i++){
            if(i < resultArr.size()){
                result += resultArr.get(i);
            }
        }

        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(String.valueOf(result));
        pw.close();
    }
}
