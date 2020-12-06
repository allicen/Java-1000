package list_of_items;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class ListOfItems {
    public static void main(String[] args) throws IOException {
        ArrayList<String> items = new ArrayList<>();

        Scanner sc = new Scanner(new FileReader("input.txt"));
        sc.nextLine();

        while (sc.hasNextLine()) {
            items.add(sc.nextLine());
        }

        Collections.sort(items);

        int count = 0;
        for (int i = 0; i < items.size(); i++) {
            if (!(i + 1 < items.size() && items.get(i+1).indexOf(items.get(i)) == 0)) {
                count++;
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        out.println(count);
        out.flush();
    }
}
