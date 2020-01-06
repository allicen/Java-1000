package natural_number_series;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NaturalNumberSeries {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        String str = sc.nextLine();

        int len = str.length();
        StringBuilder series = new StringBuilder();
        int index = 1;
        int start = 0;



        while (true){
            if(series.length() >= len){
                String substr = series.substring(start, start+len);
                if(substr.equals(str)){
                    break;
                }
                start++;
            }
            series.append(index);
            index++;
        }

        start++;

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(start));
        out.close();
    }
}
