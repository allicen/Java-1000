package economy;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Economy {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        String[] firstLineData = sc.nextLine().split(" ");
        String[] secondLineData = sc.nextLine().split(" ");

        int n = Integer.parseInt(firstLineData[0]); // кол-во бутылок
        int k = Integer.parseInt(firstLineData[1]); // кол-во человек
        ArrayList<Integer> prices = new ArrayList<>();
        for (String item : secondLineData) {
            prices.add(Integer.parseInt(item));
        }

        prices.sort(Comparator.reverseOrder());
        long result = 0;

        Map<Integer, Integer> customerPurchases = new HashMap<>();
        for (int i = 1; i <= k; i++) {
            customerPurchases.put(i, 0);
        }

        int customerNumber = 1;
        int indexPrice = 0;
        while (indexPrice < n) {
            result += (customerPurchases.get(customerNumber) + 1) * prices.get(indexPrice);
            customerPurchases.put(customerNumber, customerPurchases.get(customerNumber)+1);

            customerNumber++;
            if (customerNumber > k) {
                customerNumber = 1;
            }
            indexPrice++;
        }

        PrintWriter out = new PrintWriter(System.out);
        out.println(result);
        out.flush();
    }
}
