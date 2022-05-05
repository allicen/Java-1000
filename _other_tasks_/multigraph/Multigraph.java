package _other_tasks_.multigraph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class Multigraph {
    public static void main(String[] args) throws IOException {

        Set<String> set = new HashSet<>();
        int nodeCount = 0;

        BufferedReader br = new BufferedReader(new FileReader("multigraph.in"));

        short index = 0;

        for (String line; (line = br.readLine()) != null;) {
            String[] st = line.split(" ");
            if (st.length != 2) {
                continue;
            }
            int first = Integer.parseInt(st[0]);
            int second = Integer.parseInt(st[1]);

            if (index == 1) {
                if (first < second) {
                    set.add(first+ " " + second);
                    continue;
                }

                if (first > second) {
                    set.add(second+ " " + first);
                }
            }

            if (index == 0) {
                nodeCount = first;
                index = 1;
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        out.println(nodeCount + " " + set.size());
        for (String line : set) {
            out.println(line);
        }
        out.flush();
    }
}
