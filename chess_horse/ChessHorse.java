package chess_horse;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ChessHorse {
    public static void main(String[] args) throws IOException {
        StringBuilder result = new StringBuilder();
        int oneCoordinate, twoCoordinate;

        Scanner sc = new Scanner(new FileReader("input.txt"));
        String cellIn = sc.nextLine();
        Map<Character, Integer> field = new HashMap<>();
        Map<Integer, Character> fieldSearchValue = new HashMap<>();
        int index = 0;
        for(char i = 'a'; i <= 'h'; i++){
            index += 1;
            field.put(i, index);
            fieldSearchValue.put(index, i);
        }

        char[] ch = cellIn.toCharArray();
        oneCoordinate = field.get(ch[0]);
        twoCoordinate = ch[1] - '0';

        int max = 8;
        int min = 1;
        if(oneCoordinate - 2 >= min && twoCoordinate + 1 <= max){
            result.append(String.valueOf(fieldSearchValue.get(oneCoordinate-2))).append(twoCoordinate + 1).append("\n");
        }
        if(oneCoordinate - 1 >= min && twoCoordinate + 2 <= max){
            result.append(String.valueOf(fieldSearchValue.get(oneCoordinate - 1))).append(twoCoordinate + 2).append("\n");
        }
        if(oneCoordinate + 2 <= max && twoCoordinate + 1 <= max){
            result.append( String.valueOf(fieldSearchValue.get(oneCoordinate+2))).append(twoCoordinate + 1).append("\n");
        }
        if(oneCoordinate + 1 <= max && twoCoordinate + 2 <= max){
            result.append(String.valueOf(fieldSearchValue.get(oneCoordinate+1))).append(twoCoordinate + 2).append("\n");
        }
        if(oneCoordinate + 2 <= max && twoCoordinate - 1 >= min){
            result.append(String.valueOf(fieldSearchValue.get(oneCoordinate+2))).append(twoCoordinate - 1).append("\n");
        }
        if(oneCoordinate + 1 <= max && twoCoordinate - 2 >= min){
            result.append(String.valueOf(fieldSearchValue.get(oneCoordinate+1))).append(twoCoordinate - 2).append("\n");
        }
        if(oneCoordinate - 1 >= min && twoCoordinate - 2 >= min){
            result.append(String.valueOf(fieldSearchValue.get(oneCoordinate-1))).append(twoCoordinate - 2).append("\n");
        }
        if(oneCoordinate - 2 >= min && twoCoordinate - 1 >= min){
            result.append(String.valueOf(fieldSearchValue.get(oneCoordinate-2))).append(twoCoordinate - 1).append("\n");
        }

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(result));
        out.close();
    }
}
