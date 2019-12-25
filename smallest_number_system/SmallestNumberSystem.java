package smallest_number_system;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SmallestNumberSystem {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        String number = sc.nextLine();
        int result = -1;

        Map<Character, Integer> numberSystem = IntStream.rangeClosed('A', 'Z')
                .boxed()
                .collect(Collectors.toMap(
                        x -> (char) x.intValue(),
                        x -> x + (11 - 'A')));


        for(int i = 1; i <10 ; i++){
            numberSystem.put(Character.forDigit(i, 10), i+1);
        }

        if(Pattern.matches("\\w+", number) &&
                number.toUpperCase().equals(number) &&
                number.replaceAll("_", "").equals(number)
        ){
            char max = '!';
            char[] ch = number.toCharArray();
            for(char symbol : ch){
                if(max == '!'){
                    max = symbol;
                }else {
                    if(max < symbol){
                        max = symbol;
                    }
                }
            }
            if(max == '0'){
                result = 2;
            }else {
                result = numberSystem.get(max);
            }
        }

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(result));
        out.close();
    }
}
