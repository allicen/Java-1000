package _other_tasks_.g_couriers_implementation;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CouriersImplementation {
    public static void main(String[] args) throws IOException {
        ArrayList<ArrayList<Integer>> orders = new ArrayList<>();

        Scanner sc = new Scanner(new FileReader("input.txt"));
        while (sc.hasNextLine()) {
            String[] data = sc.nextLine().split(" ");
            if (data.length == 1) {
                continue;
            }

            String[] firstTime = data[0].split(":");
            String[] secondTime = data[1].split(":");

            ArrayList<Integer> time = new ArrayList<>();
            time.add(Integer.parseInt(firstTime[0]) * 60 * 60 + Integer.parseInt(firstTime[1]) * 60 + Integer.parseInt(firstTime[2]));
            time.add(Integer.parseInt(secondTime[0]) * 60 * 60 + Integer.parseInt(secondTime[1]) * 60 + Integer.parseInt(secondTime[2]));

            orders.add(time);
        }

        orders.sort((a, b) -> {
            if(a.get(0).compareTo(b.get(0)) == 0) {
                return a.get(1).compareTo(b.get(1));
            } else return a.get(0).compareTo(b.get(0));
        });

        int usedCouriers = 0;
        int[] availableAt = new int[orders.size()];

        for (int orderId = 0; orderId < orders.size(); orderId++) {
            int availableCourier = -1;

            for (int courierId  = 0; courierId < orders.size(); courierId++) {
                if (availableAt[courierId] <= orders.get(orderId).get(0)) {
                    availableCourier = courierId;
                    break;
                }
            }

            if (availableAt[availableCourier] == 0) {
                usedCouriers += 1;
            }

            availableAt[availableCourier] = orders.get(orderId).get(1);
        }

        PrintWriter out = new PrintWriter(System.out);
        out.println(usedCouriers);
        out.flush();
    }
}