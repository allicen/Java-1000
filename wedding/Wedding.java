package wedding;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Wedding {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));

        int husbandCount = Integer.parseInt(sc.nextLine());
        String[] husbandsMoney = sc.nextLine().split(" ");
        int gorgoneMoney = Integer.parseInt(sc.nextLine());

        ArrayList<Integer> money = new ArrayList<>();
        for (String husband: husbandsMoney) {
            money.add(Integer.parseInt(husband));
        }

        Collections.sort(money);

        double wifeMoney = 0;
        boolean first = true;
        for (int husbandMoney: money) {
            if (first) {
                wifeMoney = gorgoneMoney;
            }
            first = false;

            if (husbandMoney > wifeMoney) {
                double generalBudget = wifeMoney + husbandMoney;
                wifeMoney = generalBudget / 2;
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        out.printf(Locale.US, "%.6f", wifeMoney);
        out.flush();
    }
}
