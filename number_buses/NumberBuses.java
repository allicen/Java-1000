// Недоделано еще!!!

package number_buses;

import java.io.*;
import java.util.*;


public class NumberBuses {
    public static void main(String[] args) throws IOException {
        ArrayList<String> data = new ArrayList<>();
        ArrayList<String> resultCheck = new ArrayList<>();
        String symbolCheck = "ABCEHKMOPTXY";
        int mark = 0;
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            data.add(sc.nextLine());
        }
        for(int i = 0; i < data.size(); i++){
           if(i != 0){
               System.out.println(data.get(i));
           }
        }

        //System.out.println(data);
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write("");
        fileOut.close();
    }
}
