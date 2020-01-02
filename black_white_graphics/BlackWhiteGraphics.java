package black_white_graphics;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class BlackWhiteGraphics {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        int row = 0, column = 0, index = -1;
        ArrayList<String> firstImg = new ArrayList<>();
        ArrayList<String> secondImg = new ArrayList<>();
        Map<String, Integer> operation = new HashMap<>();

        while (sc.hasNextLine()){
            if(index == -1){
                StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
                column = Integer.valueOf(st.nextToken());
                row = Integer.valueOf(st.nextToken());
            }else if(index >= 0 && index < row){
                firstImg.add(sc.nextLine());
            }else if(index >= row && index < row*2){
                secondImg.add(sc.nextLine());
            }else {
                char[] ch = sc.nextLine().toCharArray();
                operation.put("00", ch[0] - '0');
                operation.put("01", ch[1] - '0');
                operation.put("10", ch[2] - '0');
                operation.put("11", ch[3] - '0');
            }
            index++;
        }

        StringBuilder result = new StringBuilder();

        for(int i = 0; i < row; i++){
            char[] first = firstImg.get(i).toCharArray();
            char[] second = secondImg.get(i).toCharArray();
            for(int j = 0; j < column; j++){
                int x = first[j] - '0';
                int y = second[j] - '0';
                if(x == 0 && y == 0){
                    result.append(operation.get("00"));
                }else if(x == 0 && y == 1){
                    result.append(operation.get("01"));
                }else if(x == 1 && y == 0){
                    result.append(operation.get("10"));
                }else {
                    result.append(operation.get("11"));
                }
            }
            result.append("\n");
        }

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(result).trim());
        out.close();
    }
}
