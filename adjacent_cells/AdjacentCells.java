package adjacent_cells;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AdjacentCells {
    private static ArrayList<Integer> out = new ArrayList<>();
    private static int fieldSize = 8;
    private static int[][] chessboard = new int[fieldSize][fieldSize];

    private static void findNeighbors(int cellNumber){
        boolean stop = false;
        for(int i = 0; i < fieldSize; i++){
            for(int j = 0; j < fieldSize; j++){
                if(chessboard[i][j] == cellNumber){
                    if(i-1 >= 0){
                        out.add(chessboard[i-1][j]);
                    }
                    if(i+1 < fieldSize){
                        out.add(chessboard[i+1][j]);
                    }
                    if(j-1 >= 0){
                        out.add(chessboard[i][j-1]);
                    }
                    if(j+1 < fieldSize){
                        out.add(chessboard[i][j+1]);
                    }
                    stop = true;
                    break;
                }
            }
            if(stop) break;
        }
    }

    public static void main(String[] args) throws IOException {
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        int cellNumber = sc.nextInt();

        int count = 1;
        for(int i = 0; i < fieldSize; i++){
            for(int j = 0; j < fieldSize; j++){
                chessboard[i][j] = count;
                count++;
            }
        }

        findNeighbors(cellNumber);

        Collections.sort(out);
        StringBuilder result = new StringBuilder();

        for(int number : out){
            result.append(number).append(" ");
        }

        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(String.valueOf(result).trim());
        fileOut.close();
    }
}
