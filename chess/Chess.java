package chess;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Chess {
    public static void main(String[] args) throws IOException {
        String result = "";
        List<String> cell = new ArrayList<>();
        Map<Character, Integer> field = IntStream.rangeClosed('A', 'H') // Буквы шахматной доски
                .boxed()
                .collect(Collectors.toMap(
                        x -> (char) x.intValue(),
                        x -> x + (1 - 'A')));

        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        String data = sc.nextLine();

        if(data.matches("(\\w){2}-(\\w){2}")){
            StringTokenizer st = new StringTokenizer(data, "-");
            while (st.hasMoreTokens()){
                cell.add(st.nextToken());
            }

            int[][] steps = new int[2][2];
            for(int i = 0; i < cell.size(); i++){
                char[] ch = cell.get(i).toCharArray();
                for (int j = 0; j < ch.length; j++){
                    String str = String.valueOf(ch[j]);
                    if(str.matches("\\d") && j % 2 == 1){
                        if(Integer.valueOf(str) <= 8 && Integer.valueOf(str) > 0){
                            steps[i][j] = Integer.valueOf(str);
                        }else {
                            result = "ERROR";
                        }
                    }else if(j % 2 == 0) {
                        //ch[j] = Character.toUpperCase(ch[j]);
                        if (field.containsKey(ch[j])) {
                            steps[i][j] = field.get(ch[j]);
                        }else {
                            result = "ERROR";
                        }
                    }else {
                        result = "ERROR";
                    }
                }
            }

            if(result.equals("")){
                int aCoord = steps[0][0];
                int bCoord = steps[0][1];
                int cCoord = steps[1][0];
                int dCoord = steps[1][1];

                if(Math.abs((aCoord - cCoord) * (bCoord - dCoord)) == 2){
                    result = "YES";
                }else {
                    result = "NO";
                }
            }

        }else {
            result = "ERROR";
        }
        FileWriter out = new FileWriter("output.txt");
        out.write(result);
        out.close();
    }
}
