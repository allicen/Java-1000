package sea_battle_two;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SeaBattleTwo {
    public static void main(String[] args) throws IOException {
        ArrayList<String> data = new ArrayList<>();
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            data.add(sc.nextLine());
        }
        int row = 0, column = 0;
        StringTokenizer st = new StringTokenizer(data.get(0), " ");
        while (st.hasMoreTokens()){
            row = Integer.valueOf(st.nextToken());
            column = Integer.valueOf(st.nextToken());
        }
        data.remove(0);

        String[] arrData = data.toArray(new String[0]);
        String[][] arrayReady = new String[row][column];

        for(int i = 0; i < row; i++){
            char[] ch = arrData[i].toCharArray();
            for(int j = 0; j < column; j++){
                arrayReady[i][j] = String.valueOf(ch[j]);
            }
        }

        int count = 0;
        if(row > 2 || column > 2){
            for(int i = 0; i < row; i++){
                for(int j = 0; j < column; j++){
                    if(arrayReady[i][j].equals(".")){
                        if(
                                ((i == 0 && arrayReady[i+1][j].equals(".") ||
                                ((i-1 > -1 && arrayReady[i-1][j].equals(".")) && (i+1 < row && (arrayReady[i+1][j].equals("."))))) ||
                                (i == row-1 && arrayReady[i-1][j].equals("."))) &&
                                ((j == 0 && arrayReady[i][j+1].equals(".")) ||
                                ((j-1 > -1 && arrayReady[i][j-1].equals(".") && (j+1 < column && arrayReady[i][j+1].equals(".")))) ||
                                (j == column-1 && arrayReady[i][j-1].equals(".")))
                        )
                        {
                            count++;
                        }
                    }
                }
            }
        }

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(count));
        out.close();
    }
}
