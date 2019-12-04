package tourist;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Tourist {
    private static int studentCount = 0;
    private static int weightMax = 0;
    private static Map<Integer, Integer> tents = new HashMap<>();

    private static void getData() throws FileNotFoundException {
        Queue<String> data = new ArrayDeque<>();
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            String str = sc.nextLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            while (st.hasMoreTokens()){
                data.add(st.nextToken());
            }
        }
        weightMax = Integer.valueOf(Objects.requireNonNull(data.poll()));
        studentCount = Integer.valueOf(Objects.requireNonNull(data.poll()));
        tents.put(Integer.valueOf(Objects.requireNonNull(data.poll())), Integer.valueOf(Objects.requireNonNull(data.poll())));
        tents.put(Integer.valueOf(Objects.requireNonNull(data.poll())), Integer.valueOf(Objects.requireNonNull(data.poll())));
        tents.put(Integer.valueOf(Objects.requireNonNull(data.poll())), Integer.valueOf(Objects.requireNonNull(data.poll())));
    }

    public static void main(String[] args) throws IOException {
        getData();
        int fitStudentsAlready = 0;
        int weightTentsAlready = 0;
        boolean success = false;
        for(int key : tents.keySet()){
            fitStudentsAlready += key;
            weightTentsAlready += tents.get(key);
            if (fitStudentsAlready <= studentCount && weightMax <= weightTentsAlready){
                success = true;
            }
        }
        String result = (success) ? "YES" : "NO";
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(result);
        fileOut.close();
    }
}
