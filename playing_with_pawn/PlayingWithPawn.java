package playing_with_pawn;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PlayingWithPawn {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        int n, b;
        n = Integer.parseInt(sc.nextLine());

        int[][] points = new int[n][n];

        String[] line = sc.nextLine().split(" ");
        for(int i = 0; i < n; ++i){
            points[i][i] = Integer.parseInt(line[i]);
        }


        if(n % 2 == 0)
            for(int i = 1; i < n; ++i){
                if(i % 2 == 0)
                    for(int j = i, t = 0; j < n; ++j, ++t){
                        points[j][t] = Math.min(points[j - 1][t], points[j][t + 1]);
                    }
                else{
                    for(int j = i, t = 0; j < n; ++j, ++t){
                        points[j][t] = Math.max(points[j - 1][t], points[j][t + 1]);
                    }
                }
            }
        else
            for(int i = 1; i < n; ++i){
                if(i % 2 == 0)
                    for(int j = i, t = 0; j < n; ++j, ++t){
                        points[j][t] = Math.max(points[j - 1][t], points[j][t + 1]);
                    }
                else{
                    for(int j = i, t = 0; j < n; ++j, ++t){
                        points[j][t] = Math.min(points[j - 1][t], points[j][t + 1]);
                    }
                }
            }

        int i = n - 1;
        int j = 0;
        b = 0;
        while(i != j){
            if(b % 2 == 0){
                if(points[i - 1][j] > points[i][j + 1])
                    --i;
                else
                    ++j;
            }
            else{
                if(points[i - 1][j] > points[i][j + 1])
                    ++j;
                else
                    --i;
            }
            ++b;
        }

        PrintWriter out = new PrintWriter(System.out);
        out.println(points[i][j]);
        out.flush();
    }
}
