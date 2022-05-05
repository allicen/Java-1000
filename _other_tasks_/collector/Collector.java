package _other_tasks_.collector;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Collector {
    public static void main(String[] args) throws IOException {

        short markUniq = 0;
        short collectionSize = 15000;
        byte[] data = new byte[collectionSize];

        BufferedReader br = new BufferedReader(new FileReader("collection.in"));

        short index = 0;

        for (String line; (line = br.readLine()) != null; ) {
            if (index == 1) {

                StringTokenizer st = new StringTokenizer(line, " ");
                while(st.hasMoreTokens()){

                    short num = Short.parseShort(st.nextToken());

                    if (data[num-1] == 0) {
                        data[num-1] = 1;
                        markUniq++;
                    }
                    if (markUniq == collectionSize) {
                        break;
                    }
                }
            }
            index++;
        }

        PrintWriter out = new PrintWriter(System.out);
        out.println(collectionSize - markUniq);
        out.flush();
    }
}
