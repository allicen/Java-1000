package topcoder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class TopCoder {
    public static void main(String[] args) throws IOException {
        Map<Float, ArrayList<String>> data = new TreeMap<>(Collections.reverseOrder());

        Scanner sc = new Scanner(new FileReader("input.txt"));
        while (sc.hasNextLine()){
            String line = sc.nextLine();
            if(line.contains(" ")){
                StringTokenizer st = new StringTokenizer(line, " ");
                float points = Float.valueOf(st.nextToken());
                String name = st.nextToken();

                if(data.containsKey(points)){
                    ArrayList<String> arr = data.get(points);
                    arr.add(name);
                    data.put(points, arr);
                }else {
                    data.put(points, new ArrayList<>(Collections.singletonList(name)));
                }
            }
        }

        int count = 0;
        StringBuilder rating = new StringBuilder();

        for(Float points : data.keySet()){
            String formattedDouble = String.format("%.2f", points).replaceAll(",", ".");
            Collections.sort(data.get(points));
            for(String name : data.get(points)){
                rating.append(formattedDouble).append(" ").append(name).append("\n");
                count++;
            }
        }

        String result = String.valueOf(count) + "\n" + String.valueOf(rating);

        FileWriter out = new FileWriter("output.txt");
        out.write(result);
        out.close();
    }
}
