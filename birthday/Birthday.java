package birthday;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Birthday {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));

        String petya = null;
        String vasya = null;

        while (sc.hasNextLine()){
            petya = sc.nextLine();
            vasya = sc.nextLine();
        }

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yy");
        format.setTimeZone(TimeZone.getTimeZone("UTC"));

        Date datePetya = null;
        Date dateVasya = null;

        try{
            datePetya = format.parse(petya);
            dateVasya = format.parse(vasya);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        assert datePetya != null;
        assert dateVasya != null;
        long difference = dateVasya.getTime() - datePetya.getTime();

        int days = (int) (difference / (24 * 60 * 60 * 1000));

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(days));
        out.close();
    }
}
