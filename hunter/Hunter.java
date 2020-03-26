package hunter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Hunter {
    public static void main(String[] args) throws IOException {
        ArrayList<int[]> data = new ArrayList<>();
        int maxTargetCount;

        Scanner scan = new Scanner(new FileReader("input.txt"));
        while (scan.hasNextLine()){
            String[] point = scan.nextLine().split(" ");
            if(point.length == 2){
                int x = Integer.valueOf(point[0]);
                int y = Integer.valueOf(point[1]);
                data.add(new int[]{x, y});
            }
        }

        int x0 = 0, y0 = 0;

        Map<String, Integer> directions = new HashMap<>();
        directions.put("one", 0);
        directions.put("two", 0);
        directions.put("three", 0);
        directions.put("four", 0);
        directions.put("xplus", 0);
        directions.put("yplus", 0);
        directions.put("xminus", 0);
        directions.put("yminus", 0);

        if(data.size() != 0){
            for (int i = 0; i < data.size(); i++) {
                int x1 = data.get(i)[0];
                int y1 = data.get(i)[1];
                for (int[] point : data) {
                    int x2 = point[0];
                    int y2 = point[1];

                    if ((x0 - x2) * (y1 - y2) == (x1 - x2) * (y0 - y2)) {
                        int count;
                        if(x1 > 0 && y1 > 0 && x2 > 0 && y2 > 0){
                            count = directions.get("one") + 1;
                            directions.put("one", count);
                        }else if(x1 < 0 && y1 > 0 && x2 < 0 && y2 > 0){
                            count = directions.get("two") + 1;
                            directions.put("two", count);
                        }else if(x1 < 0 && y1 < 0 && x2 < 0 && y2 < 0){
                            count = directions.get("three") + 1;
                            directions.put("three", count);
                        }else if(x1 > 0 && y1 < 0 && x2 > 0 && y2 < 0){
                            count = directions.get("four") + 1;
                            directions.put("four", count);
                        }else if(x1 > 0 && y1 == 0 && x2 > 0 && y2 == 0){
                            count = directions.get("xplus") + 1;
                            directions.put("xplus", count);
                        }else if(x1 < 0 && y1 == 0 && x2 < 0 && y2 == 0){
                            count = directions.get("xminus") + 1;
                            directions.put("xminus", count);
                        }else if(x1 == 0 && y1 > 0 && x2 == 0 && y2 > 0){
                            count = directions.get("yplus") + 1;
                            directions.put("yplus", count);
                        }else if(x1 == 0 && y1 < 0 && x2 == 0 && y2 < 0){
                            count = directions.get("yminus") + 1;
                            directions.put("yminus", count);
                        }
                    }
                }
            }
        }
        maxTargetCount = (int)(Math.sqrt(Collections.max(directions.entrySet(), Map.Entry.comparingByValue()).getValue()));

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(maxTargetCount));
        out.close();
    }
}
