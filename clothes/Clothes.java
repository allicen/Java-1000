package clothes;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Clothes {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> data = new ArrayList<>();
        Map<Integer, Integer> people = new TreeMap<>();

        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
            while (st.hasMoreTokens()){
                data.add(Integer.valueOf(st.nextToken()));
            }
        }
        data.remove(0);
        for(Integer color : data){
            int count = 1;
            if (people.containsKey(color)){
                count = people.get(color);
                count++;
            }
            people.put(color, count);
        }

        List<Map.Entry<Integer, Integer>> list = people.entrySet().stream() // Сортировка в map по значению
                .sorted((v1, v2) -> v1.getValue().compareTo(v2.getValue()))
                .collect(Collectors.toList());


        int max = list.get(list.size()-1).getValue();
        int prev = list.size() > 1 ? list.get(list.size()-2).getValue() : 0;
        int result = max == prev ? 0 : list.get(list.size()-1).getKey();

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(result));
        out.close();
    }
}
