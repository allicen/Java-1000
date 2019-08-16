package lisaalisa;

import java.util.*;
import java.io.*;

public class Lisaalisa {
    private static int total;

    private static void getData() throws IOException{ // Получение данных
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        total = sc.nextInt();
    }

    public static void main(String[] argv) throws IOException{
        getData();

        int coinCat = 5;

        int coinFoxPayCount = 0;
        int coinCatPayCount = 0;

        switch (total % coinCat){
            case (0) :
                coinCatPayCount = total / coinCat;
                break;
            case (1) :
                coinCatPayCount = total / coinCat - 1;
                coinFoxPayCount = 2;
                break;
            case (2) :
                coinCatPayCount = total / coinCat - 2;
                coinFoxPayCount = 4;
                break;
            case (3) :
                coinCatPayCount = total / coinCat;
                coinFoxPayCount = 1;
                break;
            case (4) :
                coinCatPayCount = total / coinCat - 1;
                coinFoxPayCount = 3;
                break;
        }

        String result = coinCatPayCount + " " + coinFoxPayCount;

        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(result);
        pw.close();
    }
}
