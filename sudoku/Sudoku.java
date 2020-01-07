package sudoku;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Sudoku {
    private static boolean differentNumbers(Map<Integer, Set<Integer>> map, int countSymbols){
        for(int i : map.keySet()){
            if(map.get(i).size() != countSymbols){
                return false;
            }else {
                int index = 1;
                for(int j : map.get(i)){
                    if(j != index){
                        return false;
                    }
                    index++;
                }
            }
        }
        return true;
    }

    private static Set<Integer> getSet(Map<Integer, Set<Integer>> square, int symbol, int key){
        Set<Integer> set;
        if(square.containsKey(key)){
            set = square.get(key);
            set.add(symbol);
        }else {
            set = new HashSet<>();
            set.add(symbol);
        }
        return set;
    }



    private static boolean correctSquare(int n, int[][] fields, int countSymbols){
        Map<Integer, Set<Integer>> square = new HashMap<>();

        for(int i = 0; i < n*n; i++){
            for(int j = 0; j < n*n; j++){
                int squareNumber = (i/n)*10 + j/n;
                int symbol = fields[i][j];
                square.put(squareNumber, getSet(square, symbol, squareNumber));
            }
        }
        return differentNumbers(square, countSymbols);
    }

    public static void main(String[] args) throws IOException {
        boolean isCorrect = true;
        int row = -1;
        int column = 0;
        int n = 0;
        int[][] fields = new int[0][];
        Map<Integer, Boolean> check = new HashMap<>();
        Map<Integer, Set<Integer>> checkColumn = new TreeMap<>();
        int sum = 0;

        Scanner sc = new Scanner(new FileReader("input.txt"));
        while (sc.hasNextLine()){
            if(row == -1){
                n = Integer.valueOf(sc.nextLine());
                fields = new int[n*n][n*n];

                for(int i = 1; i <= n*n; i++){
                    check.put(i, false);
                    sum += i;
                }

            }else {
                StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
                column = 0;

                Map<Integer, Boolean> checkRowCopy = new HashMap<>(check);

                while (st.hasMoreTokens()){
                    int columnVal = Integer.valueOf(st.nextToken());
                    if(checkRowCopy.containsKey(columnVal)){
                        if(checkRowCopy.get(columnVal)){
                            isCorrect = false;
                            break;
                        }else {
                            checkRowCopy.put(columnVal, true);
                        }
                    }else {
                        isCorrect = false;
                        break;
                    }

                    fields[row][column] = columnVal;
                    column++;

                    checkColumn.put(column, getSet(checkColumn, columnVal, column));
                }

            }
            row++;
        }

        if(isCorrect){
            if(n*n == row && n*n == column){
                isCorrect = correctSquare(n, fields, check.size());

            }else isCorrect = false;
        }

        if(isCorrect){
            isCorrect = differentNumbers(checkColumn, check.size());
        }

        String result = isCorrect ? "Correct" : "Incorrect";

        FileWriter out = new FileWriter("output.txt");
        out.write(result);
        out.close();
    }
}
