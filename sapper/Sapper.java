package sapper;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Sapper {
    private static StringBuilder minefield(int[][] field){
        StringBuilder out = new StringBuilder();
        for(int i = 0; i < field.length; i++){
            for (int j = 0; j < field[i].length; j++){
                int count = 0;
                if(field[i][j] == 1){
                    out.append("*");
                }else {
                    if(i-1 >= 0){
                        count += field[i-1][j];
                    }
                    if(i+1 < field.length){
                        count += field[i+1][j];
                    }
                    if(j-1 >= 0){
                        count += field[i][j-1];
                    }
                    if(j+1 < field[i].length){
                        count += field[i][j+1];
                    }
                    if(i-1 >= 0 && j-1 >= 0){
                        count += field[i-1][j-1];
                    }
                    if(i-1 >= 0 && j+1 < field[i].length){
                        count += field[i-1][j+1];
                    }
                    if(i+1 < field.length && j-1 >= 0){
                        count += field[i+1][j-1];
                    }
                    if(i+1 < field.length && j+1 < field[i].length){
                        count += field[i+1][j+1];
                    }
                    if(count == 0){
                        out.append(".");
                    }else {
                        out.append(count);
                    }
                }
            }
            out.append("\n");
        }
        return out;
    }

    public static void main(String[] args) throws IOException {
        int row, column;
        int[][] field = new int[0][];

        Scanner sc = new Scanner(new FileReader("input.txt"));
        int index = 0;
        while (sc.hasNextLine()){
            String[] arg = sc.nextLine().split(" ");
            if(index == 0){
                row = Integer.valueOf(arg[0]);
                column = Integer.valueOf(arg[1]);
                field = new int[row][column];
                index = 1;
            }else {
                int x = Integer.valueOf(arg[0])-1;
                int y = Integer.valueOf(arg[1])-1;
                field[x][y] = 1;
            }
        }

        StringBuilder result = minefield(field);

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(result).trim());
        out.close();
    }
}
