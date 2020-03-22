package wholesale;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Wholesale {
    public static void main(String[] args) throws IOException {
        int opt = 12;
        int sockPrice = 21;
        int packPrice = 205;
        int boxPrice = 2280;

        Scanner scan = new Scanner(new FileReader("input.txt"));
        long sockCount = scan.nextInt();
        int boxes = (int) (sockCount / (opt*opt));
        int mod = (int) (sockCount % (opt*opt));
        int packs = mod / opt;
        long items = mod % opt;

        if(items * sockPrice > packPrice){
            packs++;
            items = 0;
        }
        if(packs * packPrice + items * sockPrice > boxPrice){
            boxes++;
            packs = 0;
            items = 0;
        }

        String result = boxes + " " + packs + " " + items;

        FileWriter out = new FileWriter("output.txt");
        out.write(result);
        out.close();
    }
}
