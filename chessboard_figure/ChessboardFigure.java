package chessboard_figure;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ChessboardFigure {
    private static int perimeter(ArrayList data, int[][] chessboard, int cellCount){
        int perimeter = 0;
        for(int i = 0; i < cellCount; i++){
            for(int j = 0; j < cellCount; j++){
                if(chessboard[i][j] == 1){
                    if(i == 0){
                        perimeter++;
                    }
                    if(i == cellCount-1){
                        perimeter++;
                    }
                    if(i-1 >= 0 && chessboard[i-1][j] == 0){
                        perimeter++;
                    }
                    if(i+1 < cellCount && chessboard[i+1][j] == 0){
                        perimeter++;
                    }


                    if(j == 0){
                        perimeter ++;
                    }
                    if(j == cellCount - 1){
                        perimeter++;
                    }
                    if(j-1 >= 0 && chessboard[i][j-1] == 0){
                        perimeter++;
                    }
                    if(j+1 < cellCount && chessboard[i][j+1] == 0){
                        perimeter++;
                    }

                }
            }
        }
        return perimeter;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        ArrayList<int[]> data = new ArrayList<>();

        int index = 0;
        while (sc.hasNextLine()){
            if(index != 0){
                StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
                data.add(new int[]{Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken())});
            }else {
                sc.nextLine();
            }
            index++;
        }

        int cellCount = 8;
        int[][] chessboard = new int[cellCount][cellCount];

        for (int[] aData : data) {
            int one = aData[0]-1;
            int two = aData[1]-1;

            for (int i = 0; i < cellCount; i++) {
                for (int j = 0; j < cellCount; j++) {
                    if (i == one && j == two && chessboard[i][j] == 0) {
                        chessboard[i][j] = 1;
                    }
                }
            }
        }

        int perimeter = perimeter(data, chessboard, cellCount);

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(perimeter));
        out.close();
    }
}
