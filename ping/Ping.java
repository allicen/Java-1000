package ping;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Ping {
    public static void main(String[] args) throws IOException {

        ArrayList<String> packets = new ArrayList<>();

        Scanner sc = new Scanner(new FileReader("input.txt"));
        String ip = sc.nextLine().substring(5);

        for (int i = 0; i < 4; i++) {
            packets.add(sc.nextLine());
        }

        int received, lost = 0, percentLost = 0;
        int minimum = 10000, maximum = 0, average, timeSum = 0;

        for (String packet : packets) {
            if (packet.equals("Time out")) {
                lost++;
                percentLost += 25;
            } else {
                int time = Integer.parseInt(packet.substring(packet.lastIndexOf("=")+1));
                timeSum += time;
                if (time < minimum) {
                    minimum = time;
                }

                if (time > maximum) {
                    maximum = time;
                }
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        received = 4 - lost;
        out.println("Ping statistics for " + ip + ":");
        out.println("Packets: Sent = 4 Received = " + received + " Lost = " + lost + " (" + percentLost + "% loss)");
        if (lost < 4) {
            average = Math.round((float) timeSum / received);
            out.println("Approximate round trip times:");
            out.println("Minimum = " + minimum + " Maximum = " + maximum + " Average = " + average);
        }

        out.flush();
    }
}
