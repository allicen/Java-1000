package cell;

import java.io.*;
import java.util.*;

public class Cell {
    public static void main(String[] args) throws IOException {
        ArrayList<String> coordinate = new ArrayList<>();
        ArrayList<String> letter = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H"));
        String cellColor = null;
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        String str = sc.nextLine();
        char[] ch = str.toCharArray();
        for(char aCh : ch){
            coordinate.add(String.valueOf(Character.valueOf(aCh)));
        }
        for(int i = 0; i < letter.size(); i++){
            if(letter.get(i).equals(coordinate.get(0))){
                cellColor = ((i+1)%2 == 0 && Integer.valueOf(coordinate.get(1)) % 2 == 0) ? "BLACK" :
                        ((i+1)%2 == 1 && Integer.valueOf(coordinate.get(1)) % 2 == 1)  ? "BLACK" : "WHITE";
            }
        }
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(Objects.requireNonNull(cellColor));
        fileOut.close();
    }
}
