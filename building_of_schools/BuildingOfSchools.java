package building_of_schools;

import java.io.*;
import java.util.StringTokenizer;

public class BuildingOfSchools {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        int index = 0;
        while (st.hasMoreTokens() && index < n/2+1) {
            String point = st.nextToken();
            if (index == n/2) {
                out.println(point);
            }
            index++;
        }
        out.flush();
    }
}