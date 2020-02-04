package gnome_entertainment;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class GnomeEntertainment {

    /**
     * @return Map с алфавитом
     * */
    private static Map<Integer, Character> getAbc(){
        Map<Integer, Character> abc = new TreeMap<>();
        int start = 10;
        for(char i = 'A'; i <= 'Z'; i++){
            abc.put(start, i);
            start++;
        }
        return abc;
    }


    /**
     * @param number Входное число
     * @param system Система счисления
     * @param abc Алфавит
     * @return Число, переведенное в другую систму счисления
     * */
    private static String getSystemNumber(int number, int system, Map<Integer, Character> abc){
        if(number >= 10 || number >= system){
            StringBuilder str = new StringBuilder();
            while (number > 0){
                int symbol = number % system;
                if(symbol >= 10){
                    str.append(abc.get(symbol));
                }else {
                    str.append(symbol);
                }
                number /= system;
            }
            return String.valueOf(str.reverse());
        }
        return String.valueOf(number);
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        String[] dataArr = sc.nextLine().split("/");

        int date = Integer.valueOf(dataArr[0]);
        int month = Integer.valueOf(dataArr[1]);
        int year = Integer.valueOf(dataArr[2]);
        int systemNumber = date + 1;
        Map<Integer, Character> abc = new TreeMap<>();

        if(systemNumber > 9){
            abc = getAbc();
        }

        StringBuilder result = new StringBuilder();
        result.append(getSystemNumber(date, systemNumber, abc)).append("/")
                .append(getSystemNumber(month, systemNumber, abc)).append("/")
                .append(getSystemNumber(year, systemNumber, abc));

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(result));
        out.close();
    }
}
