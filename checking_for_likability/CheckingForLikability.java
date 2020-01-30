package checking_for_likability;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class CheckingForLikability {

    /**
     * @param arr Двумерный массив
     * @return true, если массив симпатичный, false в противном случае
     * */

    private static boolean check(int[][] arr){
        for (int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                if (i - 1 >= 0 && j - 1 >= 0){
                    if(arr[i][j] == arr[i][j-1] && arr[i][j] == arr[i-1][j] && arr[i][j] == arr[i-1][j-1]){
                        return false;
                    }
                }
            }
        }
        return true;
    }


    public static void main(String[] args) throws IOException {
        ArrayList<int[][]> data = new ArrayList<>();

        Scanner sc = new Scanner(new FileReader("input.txt"));
        sc.nextLine(); // Отбросить 1 строку

        int[][] arr = new int[0][];
        int n, m = 0, row = 0;

        while (sc.hasNextLine()){
            String[] lineArr = sc.nextLine().split(" ");
            if(lineArr.length == 2){
                if(arr.length > 0){
                    data.add(arr);
                    row = 0;
                }
                n = Integer.valueOf(lineArr[0]);
                m = Integer.valueOf(lineArr[1]);
                arr = new int[n][m];
            }else {
                if(arr.length > 0){
                    for (int i = 0; i < m; i++){
                        arr[row][i] = Integer.valueOf(lineArr[i]);
                    }
                    row++;
                }
            }
        }
        data.add(arr);

        StringBuilder result = new StringBuilder();
        for (int[][] arrays : data){
            if(check(arrays)){
                result.append("YES").append("\n");
            }else result.append("NO").append("\n");
        }

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(result));
        out.close();
    }
}
