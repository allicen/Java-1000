package _other_tasks_.intern_day;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class InternDay {
    public static void main(String[] args) throws IOException {

        Map<String, Integer> edges = new HashMap<>();
        Set<String> vertexes = new HashSet<>();

        Scanner sc = new Scanner(new FileReader("input.txt"));
        sc.nextLine();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            int lenLine = 3;
            int lenLineNext = lenLine + 1;

            for (int i = 0; i < line.length(); i++) {

                if (i + lenLineNext > line.length()) {
                    break;
                }

                String oneVertex = line.substring(i, i + lenLine);
                String twoVertex = line.substring(i + 1, i + lenLineNext);

                vertexes.add(oneVertex);
                vertexes.add(twoVertex);

                String edge = oneVertex + " " + twoVertex;

                if (!edges.containsKey(edge)) {
                    edges.put(edge, 1);
                } else {
                    int lineCount = edges.get(edge);
                    edges.put(edge, lineCount + 1);
                }
            }
        }

        PrintWriter out = new PrintWriter(System.out);

        out.println(vertexes.size());
        out.println(edges.size());

        for (Map.Entry<String, Integer> entry : edges.entrySet()) {
            out.println(entry.getKey() + " " + entry.getValue());
        }

        out.flush();
    }
}
