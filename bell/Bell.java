package bell;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Bell {
    public static void main(String[] args) throws IOException {
        StringBuilder result = new StringBuilder();
        ArrayList<Integer> data = new ArrayList<>();

        Scanner sc = new Scanner(new FileReader("input.txt"));
        while (sc.hasNextLine()){
            String[] symbols = sc.nextLine().split(" ");
            for(String i : symbols){
                data.add(Integer.valueOf(i));
            }
        }
        data.remove(0);
        Collections.sort(data);

        for(int i = 0; i < data.size(); i++){
            if(i % 2 == 0){
                result.append(data.get(i)).append(" ");
            }
        }

        for(int i = data.size()-1; i > 0; i--){
            if(i % 2 == 1){
                result.append(data.get(i)).append(" ");
            }
        }

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(result).trim());
        out.close();
    }
}
